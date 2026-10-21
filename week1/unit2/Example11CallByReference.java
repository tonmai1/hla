package week1.unit2;

/**
 * Java OOP Foundation - Unit 2. Each file can run on its own via Run As > Java
 * Application in Eclipse.
 */
public class Example11CallByReference {

	public static void main(String[] args) {
		Aircraft a = new Aircraft();
		a.name = "Gripen";
		System.out.println("Before: " + a.name);
		change(a);
		System.out.println("After: " + a.name); // F-16
		replace(a);
		System.out.println("After replace(): " + a.name); // Still F-16
	}

	static class Aircraft {
		String name;
	}

	static void change(Aircraft aircraft) {
		aircraft.name = "F-16"; // Same underlying object
	}

	static void replace(Aircraft aircraft) {
		aircraft = new Aircraft(); // Reassign only local reference
		aircraft.name = "F-35";
	}
}
