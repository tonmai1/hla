package week1.unit1;

/**
 * Unit 1 - Slide 5: ตัวดำเนินการคณิตศาสตร์ เปรียบเทียบ และตรรกศาสตร์ Run As >
 * Java Application (Java 17+)
 */
public class Example02Operators {

	public static void main(String[] args) {
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
}
