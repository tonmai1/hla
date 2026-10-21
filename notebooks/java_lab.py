"""Run Week 1 Java examples from a Python notebook."""

from __future__ import annotations

import os
import subprocess
import tempfile
import textwrap
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
BIN = ROOT / "bin"
JAVA_HOME = Path("/opt/homebrew/opt/openjdk@21/libexec/openjdk.jdk/Contents/Home")
JAVA = JAVA_HOME / "bin" / "java"
JAVAC = JAVA_HOME / "bin" / "javac"


def _env() -> dict[str, str]:
    env = os.environ.copy()
    env["JAVA_HOME"] = str(JAVA_HOME)
    env["PATH"] = f"{JAVA_HOME / 'bin'}{os.pathsep}{env.get('PATH', '')}"
    return env


def _print_proc(proc: subprocess.CompletedProcess[str]) -> None:
    if proc.stdout:
        print(proc.stdout, end="" if proc.stdout.endswith("\n") else "\n")
    if proc.stderr:
        print(proc.stderr, end="" if proc.stderr.endswith("\n") else "\n")


def show_java(src: Path) -> None:
    """Show the Java source in the notebook with a dark theme."""
    code = src.read_text(encoding="utf-8")
    rel = src.relative_to(ROOT)
    try:
        from IPython.display import HTML, display
        from pygments import highlight
        from pygments.formatters import HtmlFormatter
        from pygments.lexers import JavaLexer

        formatter = HtmlFormatter(style="one-dark", noclasses=True)
        highlighted = highlight(code, JavaLexer(), formatter)
        display(
            HTML(
                "<div style='"
                "background:#1e1e1e;color:#d4d4d4;border-radius:10px;"
                "padding:12px 16px;margin:8px 0;overflow:auto;"
                "font-family:ui-monospace,SFMono-Regular,Menlo,Consolas,monospace;"
                "font-size:13px;line-height:1.45;'>"
                f"<div style='color:#9cdcfe;margin-bottom:8px;'>ไฟล์ Java: {rel}</div>"
                f"{highlighted}"
                "</div>"
            )
        )
    except Exception:
        print(f"=== {rel} ===")
        print(code)
        if not code.endswith("\n"):
            print()


def run_java(main_class: str, stdin: str | None = None, show: bool = True) -> None:
    """Compile the example's package, then run the class."""
    parts = main_class.split(".")
    src = ROOT.joinpath(*parts).with_suffix(".java")
    if not src.exists():
        raise FileNotFoundError(f"Java file not found: {src}")

    if show:
        show_java(src)
        print("--- ผลลัพธ์ ---")

    package_dir = src.parent
    sources = sorted(package_dir.glob("*.java"))
    BIN.mkdir(parents=True, exist_ok=True)

    compiled = subprocess.run(
        [str(JAVAC), "-d", str(BIN), *[str(p) for p in sources]],
        cwd=ROOT,
        env=_env(),
        capture_output=True,
        text=True,
    )
    if compiled.returncode != 0:
        _print_proc(compiled)
        return

    ran = subprocess.run(
        [str(JAVA), "-cp", str(BIN), main_class],
        cwd=ROOT,
        env=_env(),
        input=stdin,
        capture_output=True,
        text=True,
    )
    _print_proc(ran)


def run_snippet(code: str, class_name: str = "Play", stdin: str | None = None) -> None:
    """Compile and run a Java snippet typed in a notebook cell."""
    source = textwrap.dedent(code).strip()
    if "class " not in source:
        body = textwrap.indent(source, "        ")
        source = (
            f"public class {class_name} {{\n"
            f"    public static void main(String[] args) {{\n"
            f"{body}\n"
            f"    }}\n"
            f"}}\n"
        )

    BIN.mkdir(parents=True, exist_ok=True)
    with tempfile.TemporaryDirectory() as tmp:
        src = Path(tmp) / f"{class_name}.java"
        src.write_text(source + "\n", encoding="utf-8")
        compiled = subprocess.run(
            [str(JAVAC), "-d", str(BIN), str(src)],
            env=_env(),
            capture_output=True,
            text=True,
        )
        if compiled.returncode != 0:
            _print_proc(compiled)
            return

    ran = subprocess.run(
        [str(JAVA), "-cp", str(BIN), class_name],
        env=_env(),
        input=stdin,
        capture_output=True,
        text=True,
    )
    _print_proc(ran)
