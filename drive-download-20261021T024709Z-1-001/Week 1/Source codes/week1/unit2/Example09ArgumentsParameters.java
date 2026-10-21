package week1.unit2;

/**
 * Java OOP Foundation - Unit 2. Each file can run on its own via Run As > Java
 * Application in Eclipse.
 */
public class Example09ArgumentsParameters {

	public static void main(String[] args) {
		int packageCount = 5;
		printPackageCount(packageCount); // packageCount = argument
		String code = "PK001";
		printTracking(code); // code = argument
	}

	static void printPackageCount(int count) { // count = parameter
		System.out.println("Package count = " + count);
	}

	static void printTracking(String trackingNumber) { // parameter
		System.out.println("Tracking = " + trackingNumber);
	}
}
