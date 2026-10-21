package week1.unit2;

/**
 * Java OOP Foundation - Unit 2. Each file can run on its own via Run As > Java
 * Application in Eclipse.
 */
public class Example10CallByValue {

	public static void main(String[] args) {
		int number = 10;
		System.out.println("Before: " + number);
		change(number);
		System.out.println("After: " + number); // 10: unchanged
	}

	static void change(int x) {
		System.out.println("Inside before: " + x);
		x = 100; // Change local copy
		System.out.println("Inside after: " + x);
	}
}
