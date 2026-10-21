package week1.unit2;

/**
 * Java OOP Foundation - Unit 2. Each file can run on its own via Run As > Java
 * Application in Eclipse.
 */
public class Example12ExceptionHandling {

	public static void main(String[] args) {
		String[] inputs = { "123", "abc", "456" };
		for (String input : inputs) {
			try {
				int number = Integer.parseInt(input);
				System.out.println("Valid number: " + number);
			} catch (NumberFormatException e) {
				System.out.println("Invalid number: " + input);
			}
		}
		System.out.println("Program continues normally");
	}

	// In HLA code, methods can also declare: throws Exception
}
