# HLA Java Coursework

Java labs for **High Level Architecture (HLA)**, starting with Week 1: language fundamentals, OOP, and collections.

Requires **Java 17+** (this workspace is set up for OpenJDK 21).

## Layout

```
week1/unit1/     Java fundamentals (variables, strings, conditions, loops, arrays)
week1/unit2/     OOP (class, encapsulation, inheritance, polymorphism, exceptions)
week1/unit3/     Collections, packages, sockets
week1/test/      Scratch / practice files
notebooks/       Jupyter notebooks that compile and run the Java examples
scripts/         Helpers (create a new Java package/class)
```

Original slides and source dumps live under `drive-download-20261021T024709Z-1-001/`.

## Run a Java example

From the repo root:

```bash
javac -d bin week1/unit1/Example01Variables.java
java -cp bin week1.unit1.Example01Variables
```

In Cursor / VS Code, open a `.java` file and use **Run | Debug**.

Create a new package or class (Eclipse-style):

```bash
python3 scripts/new_java.py
```

## Notebooks

Each notebook loads `notebooks/java_lab.py`, then compiles and runs the matching `.java` file.

| Notebook | Topic |
| --- | --- |
| `notebooks/Week1_Unit1_Fundamentals.ipynb` | Variables, operators, strings, Scanner, conditions, switch, loops, arrays |
| `notebooks/Week1_Unit2_OOP.ipynb` | Class, methods, constructor, encapsulation, inheritance, interfaces |
| `notebooks/Week1_Unit3_Collections.ipynb` | ArrayList, HashMap, for-each, packages, sockets |

Run any code cell (Shift+Enter). You do not have to start from the first cell. To try your own Java, edit the `run_snippet` cell in the notebook.
