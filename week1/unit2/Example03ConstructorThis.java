package week1.unit2;

/**
 * Java OOP Foundation - Unit 2. Each file can run on its own via Run As > Java
 * Application in Eclipse.
 */
public class Example03ConstructorThis {

	public static void main(String[] args) {
		PackageData p = new PackageData("PK001");
		System.out.println("Tracking: " + p.trackingNumber);
		// 'this.trackingNumber' is the field of the current object.
		PackageData p2 = new PackageData("PK002");
		System.out.println("Tracking 2: " + p2.trackingNumber);
	}

	static class PackageData {
		String trackingNumber;

		PackageData(String trackingNumber) { // Constructor: same name as class
			this.trackingNumber = trackingNumber;
		}
	}
}
