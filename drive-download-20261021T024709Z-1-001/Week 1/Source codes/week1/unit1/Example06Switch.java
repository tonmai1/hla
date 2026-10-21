package week1.unit1;

/**
 * Unit 1 - Slide 9: switch statement และ switch expression Run As > Java
 * Application (Java 17+)
 */
public class Example06Switch {

	public static void main(String[] args) {
		int menu = 2;
		// Traditional switch (as shown in the PDF)
		switch (menu) {
		case 1:
			System.out.println("Add");
			break;
		case 2:
			System.out.println("Update");
			break;
		case 3:
			System.out.println("Search");
			break;
		case 0:
			System.out.println("Exit");
			break;
		default:
			System.out.println("Invalid");
		}

		// Modern switch expression (Java 14+), no break required.
		String command = switch (menu) {
		case 1 -> "Add";
		case 2 -> "Update";
		case 3 -> "Search";
		case 0 -> "Exit";
		default -> "Invalid";
		};
		System.out.println("Switch expression result = " + command);

	}
}
