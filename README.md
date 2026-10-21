# งานแลป Java — HLA

โปรเจกต์นี้ใช้เรียน **High Level Architecture (HLA)** เริ่มจากสัปดาห์ที่ 1: พื้นฐาน Java, OOP และ Collections

**จุดประสงค์คือไม่ต้องติดตั้ง Eclipse IDE** เขียน รัน และดีบัก Java ได้ใน Cursor / VS Code พร้อมปุ่ม Run | Debug เหมือน Eclipse และสร้างแพ็กเกจ/คลาสใหม่ด้วยสคริปต์แทนเมนู New ของ Eclipse

ต้องการ **Java 17 ขึ้นไป** (โปรเจกต์นี้ตั้งค่าไว้กับ OpenJDK 21)

## ส่วนขยายที่แนะนำ

เมื่อเปิดโฟลเดอร์นี้ Cursor / VS Code จะแนะนำส่วนขยายให้ติดตั้ง กด **Install** ได้เลย หรือค้นจากชื่อด้านล่าง

| ส่วนขยาย | รหัส | ใช้ทำอะไร |
| --- | --- | --- |
| **Extension Pack for Java** | `vscjava.vscode-java-pack` | รัน / ดีบัก / IntelliSense ไฟล์ `.java` ไม่ต้องใช้ Eclipse |
| **Python** | `ms-python.python` | รัน `scripts/new_java.py` และตัวช่วยในโน้ตบุ๊ก |
| **Jupyter** | `ms-toolsai.jupyter` | เปิดโน้ตบุ๊กแล้วกด play เพื่อรันตัวอย่าง Java |

ส่วนขยาย Java นี้รวม Language Support for Java, Debugger for Java และ Project Manager for Java ไว้แล้ว

## โครงสร้างโฟลเดอร์

```
week1/unit1/     พื้นฐาน Java (ตัวแปร, สตริง, เงื่อนไข, ลูป, อาร์เรย์)
week1/unit2/     OOP (คลาส, encapsulation, inheritance, polymorphism, exception)
week1/unit3/     Collections, แพ็กเกจ, ซ็อกเก็ต
week1/test/      ไฟล์ทดลองเขียนเอง
notebooks/       โน้ตบุ๊ก Jupyter ที่คอมไพล์แล้วรันตัวอย่าง Java
scripts/         สร้างแพ็กเกจ / คลาสใหม่ (แทน Eclipse New)
```

สไลด์และซอร์สต้นฉบับอยู่ใน `drive-download-20261021T024709Z-1-001/`

## วิธีรันตัวอย่าง Java

เปิดไฟล์ `.java` แล้วกด **Run | Debug** ที่เมธอด `main`

หรือรันจากเทอร์มินัลที่รากโปรเจกต์:

```bash
javac -d bin week1/unit1/Example01Variables.java
java -cp bin week1.unit1.Example01Variables
```

สร้างแพ็กเกจหรือคลาสใหม่ (แทน Eclipse: New > Package / Class):

```bash
python3 scripts/new_java.py
```

## โน้ตบุ๊ก

แต่ละโน้ตบุ๊กโหลด `notebooks/java_lab.py` แล้วคอมไพล์และรันไฟล์ `.java` ที่ตรงกัน

| โน้ตบุ๊ก | เนื้อหา |
| --- | --- |
| `notebooks/Week1_Unit1_Fundamentals.ipynb` | ตัวแปร, ตัวดำเนินการ, สตริง, Scanner, เงื่อนไข, switch, ลูป, อาร์เรย์ |
| `notebooks/Week1_Unit2_OOP.ipynb` | คลาส, เมธอด, constructor, encapsulation, inheritance, interface |
| `notebooks/Week1_Unit3_Collections.ipynb` | ArrayList, HashMap, for-each, แพ็กเกจ, ซ็อกเก็ต |

กด play ที่เซลล์โค้ด หรือ Shift+Enter ไม่จำเป็นต้องเริ่มจากเซลล์แรก ถ้าอยากลองเขียนเอง ให้แก้เซลล์ `run_snippet` ในโน้ตบุ๊ก
