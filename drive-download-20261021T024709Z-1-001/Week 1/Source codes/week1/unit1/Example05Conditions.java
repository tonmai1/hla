package week1.unit1;

/**
 * Unit 1 - Slide 8: เงื่อนไข if / else if / else Run As > Java Application (Java
 * 17+)
 */
public class Example05Conditions {

	public static void main(String[] args) {
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
}
