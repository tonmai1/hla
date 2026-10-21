package week1.unit1;

import java.util.Scanner;

/**
 * Java Fundamentals & Program Logic - Unit 1 Slide reference: Chapter 1, pages
 * 1-12 Run from Eclipse: Run As > Java Application
 */
public class Unit1Fundamental {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		variables();
//		operators();
//		strings();
//		scannerInput(sc);
//		conditions();
//		switchExamples();
//		loops();
//		arrays();
//		packageScoreChecker(sc);
	}

	// Use nextLine + parseInt, so newline characters do not break the main menu.
	private static int readInt(Scanner sc) {
		while (true) {
			String line = sc.nextLine().trim();
			try {
				return Integer.parseInt(line);
			} catch (NumberFormatException ex) {
				System.out.print("Please enter an integer: ");
			}
		}
	}

	// SLIDES 3-4: Type -> Name -> Value; camelCase naming
	private static void variables() {
		int studentAge = 20;
		double score = 87.5;
		boolean isPassed = true;
		char grade = 'A';
		String name = "Student"; // String is an object, not a primitive.

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

	// SLIDE 5: arithmetic, comparison, logic, assignment vs equality
	private static void operators() {
		int a = 10;
		int b = 3;
		System.out.println("a + b = " + (a + b));
		System.out.println("a - b = " + (a - b));
		System.out.println("a * b = " + (a * b));
		System.out.println("a / b (integer division) = " + (a / b));
		System.out.println("a % b = " + (a % b));
		System.out.println("a / (double)b = " + (a / (double) b));

		System.out.println("a == b: " + (a == b));
		System.out.println("a != b: " + (a != b));
		System.out.println("a > b: " + (a > b));
		System.out.println("a < b: " + (a < b));
		System.out.println("a >= b: " + (a >= b));
		System.out.println("a <= b: " + (a <= b));

		int amount = 5; // = assigns a value, == compares values.
		double price = 12.50;
		double total = amount * price;
		boolean canShip = amount > 0 && total < 1000;
		boolean needsReview = amount == 0 || total >= 1000;
		System.out.println("Total: " + total);
		System.out.println("Can ship: " + canShip);
		System.out.println("Not allowed: " + !canShip);
		System.out.println("Needs review: " + needsReview);
	}

	// SLIDE 6: concatenation, length, equals, contains, toUpperCase
	private static void strings() {
		String name = "Jira";
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

	// SLIDE 7: Scanner and the nextInt() / nextLine() newline issue
	private static void scannerInput(Scanner sc) {
		System.out.print("Enter name: ");
		String name = sc.nextLine();
		System.out.print("Enter age: ");
		int age = sc.nextInt();
		sc.nextLine(); // Consume the remaining Enter before nextLine().
		System.out.print("Enter city: ");
		String city = sc.nextLine();
		System.out.println(name + " / " + age + " / " + city);
	}

	// SLIDE 8: conditional flow
	private static void conditions() {
		int score = 75;
		if (score >= 80) {
			System.out.println("A");
		} else if (score >= 70) {
			System.out.println("B");
		} else {
			System.out.println("Need improve");
		}

		boolean connected = true;
		boolean packetValid = false;
		if (connected && packetValid) {
			System.out.println("Process HLA packet");
		} else {
			System.out.println("Skip invalid or disconnected packet");
		}
	}

	// SLIDE 9: traditional switch from the slide + arrow switch in Java 17+
	private static void switchExamples() {
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

	// SLIDE 10: for, while, do-while, break, continue
	private static void loops() {
		System.out.println("for:");
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		}

		System.out.println("while:");
		int attempt = 0;
		boolean isRunning = true;
		while (isRunning) {
			System.out.println("Attempt " + attempt);
			attempt++;
			if (attempt >= 3) {
				isRunning = false; // Avoid an infinite loop in the demo.
			}
		}

		System.out.println("do-while:");
		int count = 0;
		do {
			System.out.println("Run at least once: " + count);
			count++;
		} while (count < 2);

		System.out.println("continue (skip 3), break (stop at 5):");
		for (int i = 1; i <= 10; i++) {
			if (i == 3)
				continue;
			if (i == 5)
				break;
			System.out.println(i);
		}
	}

	// SLIDE 11: index starts at 0; length; two ways to iterate
	private static void arrays() {
		int[] scores = { 10, 20, 30 };
		System.out.println("scores[0] = " + scores[0]);
		System.out.println("Length = " + scores.length);

		System.out.println("Index-based for:");
		for (int i = 0; i < scores.length; i++) {
			System.out.println("scores[" + i + "] = " + scores[i]);
		}

		System.out.println("Enhanced for:");
		for (int score : scores) {
			System.out.println(score);
		}
	}

	// SLIDE 12: combined lab - input -> decision -> loop -> array -> summary
	private static void packageScoreChecker(Scanner sc) {
		System.out.print("How many packages? ");
		int count = readInt(sc);
		if (count <= 0) {
			System.out.println("Package count must be greater than 0.");
			return;
		}

		int[] scores = new int[count];
		int passed = 0;

		for (int i = 0; i < count; i++) {
			System.out.print("Package " + (i + 1) + " score: ");
			scores[i] = readInt(sc);
			if (scores[i] >= 60) {
				passed++;
			}
		}

		System.out.println("\n===== PACKAGE SUMMARY =====");
		for (int i = 0; i < scores.length; i++) {
			String result = scores[i] >= 60 ? "PASS" : "FAIL";
			System.out.println("Package " + (i + 1) + ": " + scores[i] + " -> " + result);
		}
		System.out.println("Total: " + count);
		System.out.println("Passed: " + passed);
		System.out.println("Failed: " + (count - passed));
	}
}
