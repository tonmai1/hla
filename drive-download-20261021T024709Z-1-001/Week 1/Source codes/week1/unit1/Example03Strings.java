package week1.unit1;

/**
 * Unit 1 - Slide 6: การทำงานกับ String Run As > Java Application (Java 17+)
 */
public class Example03Strings {

	public static void main(String[] args) {
		String name = "Student";
		String status = "Ready";
		System.out.println(name + " is " + status);
		System.out.println("Name length = " + name.length());
		System.out.println("Uppercase = " + name.toUpperCase());
		System.out.println("Contains 'ea'? " + status.contains("ea"));

		if (status.equals("Ready")) {
			System.out.println("Start");
		}
		// Use .equals() to compare text contents, not ==.
		String inputStatus = new String("Ready");
		System.out.println("equals: " + status.equals(inputStatus)); // true
		System.out.println("== : " + (status == inputStatus)); // false

	}
}
