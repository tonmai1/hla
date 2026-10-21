package week1.unit1;

/**
 * Unit 1 - Slide 3-4: ตัวแปร ชนิดข้อมูล และการตั้งชื่อตัวแปร Run As > Java
 * Application (Java 17+)
 */
public class Example01Variables {

	public static void main(String[] args) {
		int studentAge = 20;
		double score = 87.5;
		boolean isPassed = true;
		char grade = 'A';
		String name = "Jira"; // String is an object, not a primitive.

		System.out.println("Age = " + studentAge);
		System.out.println("Score = " + score);
		System.out.println("Passed = " + isPassed);
		System.out.println("Grade = " + grade);
		System.out.println("Hello " + name);

		// HLA-related examples: identifying appropriate types
		int sequence = 1;
		boolean connected = true;
		String federation = "Workshop";
		byte[] payload = { 10, 20, 30 };
		System.out.println("HLA: " + federation + " / seq=" + sequence + " / connected=" + connected + " / bytes="
				+ payload.length);

	}
}
