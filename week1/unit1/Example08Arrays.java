package week1.unit1;

/**
 * Unit 1 - Slide 11: Array และการวนอ่านสมาชิก Run As > Java Application (Java
 * 17+)
 */
public class Example08Arrays {

	public static void main(String[] args) {
		int[] scores = { 10, 20, 30, 40 };
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
}
