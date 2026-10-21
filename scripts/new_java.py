#!/usr/bin/env python3
"""Create a Java package (and optional class) the way Eclipse New > Package / Class does.

Run with no arguments to get a menu:
  python3 scripts/new_java.py
"""

from __future__ import annotations

import argparse
import re
import sys
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]

KEYWORDS = {
    "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char",
    "class", "const", "continue", "default", "do", "double", "else", "enum",
    "extends", "final", "finally", "float", "for", "goto", "if", "implements",
    "import", "instanceof", "int", "interface", "long", "native", "new",
    "package", "private", "protected", "public", "return", "short", "static",
    "strictfp", "super", "switch", "synchronized", "this", "throw", "throws",
    "transient", "try", "void", "volatile", "while", "true", "false", "null",
}

IDENT = re.compile(r"[A-Za-z_][A-Za-z0-9_]*")


def die(msg: str) -> None:
    print(f"Error: {msg}", file=sys.stderr)
    sys.exit(1)


def package_error(name: str) -> str | None:
    name = name.strip()
    if not name:
        return "package name is empty"
    for part in name.split("."):
        if not IDENT.fullmatch(part):
            return f"invalid package part '{part}' (use letters, digits, _)"
        if part in KEYWORDS:
            return f"'{part}' is a Java keyword"
    return None


def class_error(name: str) -> str | None:
    name = name.strip()
    if not IDENT.fullmatch(name):
        return f"invalid class name '{name}'"
    if name in KEYWORDS:
        return f"'{name}' is a Java keyword"
    return None


def check_package(name: str) -> str:
    err = package_error(name)
    if err:
        die(err)
    return name.strip()


def check_class(name: str) -> str:
    err = class_error(name)
    if err:
        die(err)
    return name.strip()


def class_source(package: str, class_name: str, with_main: bool) -> str:
    lines = [f"package {package};", "", f"public class {class_name} {{"]
    if with_main:
        lines += [
            "\tpublic static void main(String[] args) {",
            f'\t\tSystem.out.println("Hello from {package}.{class_name}");',
            "\t}",
        ]
    lines.append("}")
    lines.append("")
    return "\n".join(lines)


SKIP_DIRS = {
    "bin",
    "notebooks",
    "scripts",
    "drive-download-20261021T024709Z-1-001",
    "__pycache__",
}


def source_dir_choices() -> list[tuple[str, Path]]:
    choices: list[tuple[str, Path]] = [("Project root (hla)", ROOT)]
    week1 = ROOT / "week1"
    if week1.is_dir():
        choices.append(("week1", week1))
        for child in sorted(week1.iterdir()):
            if child.is_dir() and not child.name.startswith(".") and child.name not in SKIP_DIRS:
                rel = child.relative_to(ROOT).as_posix()
                choices.append((rel, child))
    for child in sorted(ROOT.iterdir()):
        if (
            child.is_dir()
            and child.name not in SKIP_DIRS
            and not child.name.startswith(".")
            and child.name != "week1"
        ):
            choices.append((child.name, child))
    return choices


def join_package(base_dir: Path, relative_package: str) -> str:
    if base_dir == ROOT:
        prefix = ""
    else:
        prefix = base_dir.relative_to(ROOT).as_posix().replace("/", ".")
    entered = relative_package.strip()
    if not prefix:
        return entered
    if entered == prefix or entered.startswith(prefix + "."):
        return entered
    return f"{prefix}.{entered}"


def create(package: str, class_name: str = "", with_main: bool = True) -> None:
    folder = ROOT.joinpath(*package.split("."))
    folder.mkdir(parents=True, exist_ok=True)
    print(f"Package folder: {folder.relative_to(ROOT)}  ({package})")

    if not class_name:
        print("Done. Package only — no class file yet.")
        return

    path = folder / f"{class_name}.java"
    if path.exists():
        die(f"{path.relative_to(ROOT)} already exists")

    path.write_text(class_source(package, class_name, with_main), encoding="utf-8")
    print(f"Class created: {path.relative_to(ROOT)}")


def ask(prompt: str) -> str:
    try:
        return input(prompt).strip()
    except EOFError:
        die("no input (run this in the Terminal, not the Output panel)")


def ask_choice(title: str, options: list[str]) -> int:
    print()
    print(title)
    for i, option in enumerate(options, start=1):
        print(f"  {i}) {option}")
    while True:
        raw = ask(f"Choose 1-{len(options)}: ")
        if raw.isdigit() and 1 <= int(raw) <= len(options):
            return int(raw)
        print(f"  Type a number 1-{len(options)}")


def ask_until(prompt: str, validator) -> str:
    while True:
        value = ask(prompt)
        err = validator(value)
        if not err:
            return value.strip()
        print(f"  {err}")


def ask_directory() -> Path:
    dirs = source_dir_choices()
    labels = [label for label, _ in dirs]
    labels.append("Other folder (type a path)")
    labels.append("Quit")
    pick = ask_choice("Which directory should the package be created in?", labels)
    if pick == len(labels):
        print("Cancelled.")
        sys.exit(0)
    if pick == len(labels) - 1:
        while True:
            raw = ask("Folder relative to project (example: week1): ")
            if not raw:
                print("  Path is empty")
                continue
            path = (ROOT / raw).resolve()
            try:
                path.relative_to(ROOT.resolve())
            except ValueError:
                print("  Stay inside the project folder")
                continue
            path.mkdir(parents=True, exist_ok=True)
            return path
    return dirs[pick - 1][1]


def wizard() -> None:
    print("====================================")
    print("  New Java  (like Eclipse)")
    print("====================================")

    choice = ask_choice(
        "What do you want to create?",
        [
            "New Package only",
            "New Package + Class  (with main)",
            "New Package + Class  (no main)",
            "Quit",
        ],
    )
    if choice == 4:
        print("Cancelled.")
        return

    base_dir = ask_directory()
    if base_dir == ROOT:
        example = "test"
        hint = "created in the project root"
    else:
        example = "test"
        hint = f"created under {base_dir.relative_to(ROOT).as_posix()}/"

    package_part = ask_until(
        f"Package name under that folder (example: {example}): ",
        package_error,
    )
    package = join_package(base_dir, package_part)
    print(f"  -> {hint}  package {package}")

    class_name = ""
    with_main = False
    if choice in (2, 3):
        class_name = ask_until("Class name (example: HelloWorld): ", class_error)
        with_main = choice == 2

    print()
    create(package, class_name, with_main)


def main() -> None:
    parser = argparse.ArgumentParser(
        description="Eclipse-style New Java Package / New Java Class"
    )
    parser.add_argument("--package", help="e.g. week1.lab or test")
    parser.add_argument("--dir", dest="base_dir", default="", help="parent folder, e.g. week1")
    parser.add_argument("--class", dest="class_name", default="", help="e.g. App")
    parser.add_argument(
        "--main",
        default="yes",
        choices=["yes", "no"],
        help="add public static void main",
    )
    args = parser.parse_args()

    if not args.package:
        wizard()
        return

    package_part = check_package(args.package)
    if args.base_dir.strip():
        base_dir = (ROOT / args.base_dir.strip()).resolve()
        try:
            base_dir.relative_to(ROOT.resolve())
        except ValueError:
            die("--dir must be inside the project")
        package = join_package(base_dir, package_part)
    else:
        package = package_part
    class_name = check_class(args.class_name) if args.class_name.strip() else ""
    create(package, class_name, args.main == "yes")


if __name__ == "__main__":
    main()
