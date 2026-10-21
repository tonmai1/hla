package week1.unit1;

/**
 * Unit 1 - Slide 10: for / while / do-while / break / continue Run As > Java
 * Application (Java 17+)
 */
public class Example07Loops {

	public static void main(String[] args) {
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
			// or you can use while (attempt < 3) as well
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
}
