#!/usr/bin/env python3
"""Generate Week 1 lab notebooks. Run from this folder."""

from pathlib import Path

import nbformat as nbf

HERE = Path(__file__).resolve().parent


def md(source: str):
    return nbf.v4.new_markdown_cell(source.strip() + "\n")


BOOTSTRAP = """
import sys
from pathlib import Path

def _find_java_lab():
    here = Path.cwd().resolve()
    for p in [here, *here.parents]:
        for candidate in (p, p / "notebooks"):
            if (candidate / "java_lab.py").exists():
                return candidate
    raise FileNotFoundError("java_lab.py not found")

_p = _find_java_lab()
if str(_p) not in sys.path:
    sys.path.insert(0, str(_p))
from java_lab import run_java, run_snippet
""".strip()


def py(source: str):
    body = source.strip()
    if "from java_lab import" not in body:
        body = BOOTSTRAP + "\n" + body
    return nbf.v4.new_code_cell(body + "\n")


def write(name: str, cells: list) -> None:
    nb = nbf.v4.new_notebook()
    nb["metadata"] = {
        "kernelspec": {
            "display_name": "Python 3",
            "language": "python",
            "name": "python3",
        },
        "language_info": {"name": "python", "pygments_lexer": "ipython3"},
    }
    nb["cells"] = cells
    path = HERE / name
    nbf.write(nb, path)
    print(f"wrote {path}")


SETUP = 'print("พร้อมรัน Java แล้ว")'


write(
    "Week1_Unit1_Fundamentals.ipynb",
    [
        md(
            """# สัปดาห์ที่ 1 — หน่วยที่ 1: พื้นฐาน Java

กดปุ่ม **play** ที่เซลล์โค้ด (หรือ Shift+Enter) ไม่จำเป็นต้องเริ่มจากเซลล์แรก

แต่ละเซลล์จะโหลด Java ให้แล้วรันตัวอย่าง แก้โค้ดในเซลล์ `run_snippet` เพื่อลองเขียนเอง

ถ้าต้องการปุ่ม **Run | Debug** ให้เปิดไฟล์ `.java` แทน"""
        ),
        py(SETUP),
        md(
            """## 1. ตัวแปรและชนิดข้อมูล
`int` `double` `boolean` `char` เป็นชนิดพื้นฐาน (primitive) ส่วน `String` เป็นอ็อบเจ็กต์

ไฟล์: `week1/unit1/Example01Variables.java`"""
        ),
        py('run_java("week1.unit1.Example01Variables")'),
        md(
            """### ลองเอง
เปลี่ยนค่าตัวแปร แล้วกด Shift+Enter"""
        ),
        py(
            """run_snippet('''
int age = 20;
double score = 87.5;
String name = "Jira";
System.out.println(name + " is " + age + " years old, score=" + score);
''')"""
        ),
        md(
            """## 2. ตัวดำเนินการ
`/` ระหว่าง `int` สองตัวจะตัดเศษทิ้ง ถ้าต้องการทศนิยมให้แปลงเป็น `double`

`=` คือการกำหนดค่า  `==` คือการเปรียบเทียบ  `&&` และ  `||` หรือ  `!` ไม่

ไฟล์: `week1/unit1/Example02Operators.java`"""
        ),
        py('run_java("week1.unit1.Example02Operators")'),
        md("### ลองเอง"),
        py(
            """run_snippet('''
int a = 10;
int b = 3;
System.out.println("int division: " + (a / b));
System.out.println("decimal division: " + (a / (double) b));
System.out.println("remainder: " + (a % b));
System.out.println("can ship: " + (a > 0 && b < 1000));
''')"""
        ),
        md(
            """## 3. สตริง (ข้อความ)
เปรียบเทียบเนื้อข้อความด้วย `.equals()` ส่วน `==` เปรียบว่าเป็นอ็อบเจ็กต์ตัวเดียวกันหรือไม่ ไม่ได้ดูตัวอักษร

ไฟล์: `week1/unit1/Example03Strings.java`"""
        ),
        py('run_java("week1.unit1.Example03Strings")'),
        md(
            """## 4. รับค่าจากคีย์บอร์ดด้วย Scanner
ตัวอย่างนี้รอรับอินพุต เซลล์ด้านล่างใส่คำตอบตัวอย่างไว้ให้รันในโน้ตบุ๊กได้

ไฟล์: `week1/unit1/Example04ScannerInput.java`"""
        ),
        py(
            'run_java("week1.unit1.Example04ScannerInput", stdin="Jira\\n20\\nBangkok\\n")'
        ),
        md(
            """## 5. เงื่อนไข if / else if / else
ไฟล์: `week1/unit1/Example05Conditions.java`"""
        ),
        py('run_java("week1.unit1.Example05Conditions")'),
        md(
            """### ลองเอง
เปลี่ยนค่า `score` แล้วดูเกรดที่ได้"""
        ),
        py(
            """run_snippet('''
int score = 75;
if (score >= 80) {
    System.out.println("A");
} else if (score >= 70) {
    System.out.println("B");
} else {
    System.out.println("Need improve");
}
''')"""
        ),
        md(
            """## 6. switch
`switch` แบบเดิมต้องมี `break` ส่วนแบบลูกศร (`->`) ไม่ต้องใส่ `break`

ไฟล์: `week1/unit1/Example06Switch.java`"""
        ),
        py('run_java("week1.unit1.Example06Switch")'),
        md(
            """## 7. ลูป
`for`, `while`, `do-while` รวมถึง `continue` และ `break`

ไฟล์: `week1/unit1/Example07Loops.java`"""
        ),
        py('run_java("week1.unit1.Example07Loops")'),
        md(
            """## 8. อาร์เรย์
ดัชนีเริ่มที่ `0` ขนาดดูจาก `.length`

ไฟล์: `week1/unit1/Example08Arrays.java`"""
        ),
        py('run_java("week1.unit1.Example08Arrays")'),
        md(
            """## 9. แล็บ — ตรวจคะแนนพัสดุ
แล็บแบบโต้ตอบ ตัวอย่างอินพุต: พัสดุ 3 ชิ้น คะแนน 80, 55, 90

ไฟล์: `week1/unit1/Example09PackageScoreChecker.java`"""
        ),
        py(
            'run_java("week1.unit1.Example09PackageScoreChecker", stdin="3\\n80\\n55\\n90\\n")'
        ),
    ],
)


write(
    "Week1_Unit2_OOP.ipynb",
    [
        md(
            """# สัปดาห์ที่ 1 — หน่วยที่ 2: พื้นฐาน OOP

คลาส อ็อบเจ็กต์ คอนสตรักเตอร์ การห่อหุ้ม (encapsulation) การสืบทอด (inheritance) อินเทอร์เฟซ และข้อผิดพลาด (exception)

ไฟล์ Java อยู่ใน `week1/unit2/`"""
        ),
        py(SETUP),
        md("## 1. คลาสและอ็อบเจ็กต์"),
        py('run_java("week1.unit2.Example01ClassObject")'),
        md("## 2. คุณสมบัติและเมธอด"),
        py('run_java("week1.unit2.Example02AttributesMethods")'),
        md("## 3. คอนสตรักเตอร์และ `this`"),
        py('run_java("week1.unit2.Example03ConstructorThis")'),
        md("## 4. การห่อหุ้ม (encapsulation)"),
        py('run_java("week1.unit2.Example04Encapsulation")'),
        md("## 5. static และ final"),
        py('run_java("week1.unit2.Example05StaticFinal")'),
        md("## 6. การสืบทอด (inheritance)"),
        py('run_java("week1.unit2.Example06Inheritance")'),
        md("## 7. พอลิมอร์ฟิซึม / การทับเมธอด (override)"),
        py('run_java("week1.unit2.Example07PolymorphismOverride")'),
        md("## 8. อินเทอร์เฟซ (interface)"),
        py('run_java("week1.unit2.Example08InterfaceDemo")'),
        md("## 9. อาร์กิวเมนต์และพารามิเตอร์"),
        py('run_java("week1.unit2.Example09ArgumentsParameters")'),
        md("## 10. ส่งค่าแบบ call by value"),
        py('run_java("week1.unit2.Example10CallByValue")'),
        md("## 11. ส่งค่าแบบ call by reference (อ้างอิงอ็อบเจ็กต์)"),
        py('run_java("week1.unit2.Example11CallByReference")'),
        md("## 12. การจัดการข้อผิดพลาด (exception)"),
        py('run_java("week1.unit2.Example12ExceptionHandling")'),
        md(
            """### ลองเอง
เขียนคลาสสั้น ๆ ในเซลล์นี้"""
        ),
        py(
            """run_snippet('''
class Packet {
    String id;
    Packet(String id) { this.id = id; }
    void printId() { System.out.println("packet " + id); }
}
public class Play {
    public static void main(String[] args) {
        Packet p = new Packet("HLA-1");
        p.printId();
    }
}
''')"""
        ),
    ],
)


write(
    "Week1_Unit3_Collections.ipynb",
    [
        md(
            """# สัปดาห์ที่ 1 — หน่วยที่ 3: คอลเลกชัน ไบต์ และซ็อกเก็ต

`ArrayList`, `HashMap`, foreach ตัวอย่างพัสดุ/ไบต์แบบ HLA และการส่ง-รับด้วย socket

ไฟล์ Java อยู่ใน `week1/unit3/`

ตัวอย่าง socket ต้องรันสองโปรแกรม (ตัวรับ + ตัวส่ง) ให้เปิดไฟล์ `.java` อย่ารันในเซลล์เดียว"""
        ),
        py(SETUP),
        md("## 1. ArrayList"),
        py('run_java("week1.unit3.Example01ArrayList")'),
        md("## 2. HashMap"),
        py('run_java("week1.unit3.Example02HashMap")'),
        md("## 3. for-each"),
        py('run_java("week1.unit3.Example03ForEach")'),
        md("## 4. คอลเลกชันของอ็อบเจ็กต์"),
        py('run_java("week1.unit3.Example04ObjectCollection")'),
        md("## 5. การ import แพ็กเกจ"),
        py('run_java("week1.unit3.Example05PackageImport")'),
        md("## 6. อาร์เรย์ไบต์"),
        py('run_java("week1.unit3.Example06ByteArray")'),
        md("## 7. ค่าแฮนเดิล (handle value)"),
        py('run_java("week1.unit3.Example07HandleValue")'),
        md("## 8. การติดตามพัสดุ"),
        py('run_java("week1.unit3.Example08PackageTracking")'),
        md(
            """## 9–10. ซ็อกเก็ต
เปิดไฟล์ Java เหล่านี้ แล้วรัน **ตัวรับก่อน** จากนั้นค่อยรัน **ตัวส่ง**:

- `week1/unit3/Example09SocketReceiver.java`
- `week1/unit3/Example10SocketSender.java`"""
        ),
    ],
)
