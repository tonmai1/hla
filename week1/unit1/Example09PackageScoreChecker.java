package week1.unit1;

import java.util.Scanner;

/**
 * Unit 1 - Slide 12: Lab: Package Score Checker Run As > Java Application (Java
 * 17+)
 */
public class Example09PackageScoreChecker {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
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

		sc.close();
	}

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
}
