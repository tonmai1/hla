package week1.unit2;

/**
 * Java OOP Foundation - Unit 2. Each file can run on its own via Run As > Java
 * Application in Eclipse.
 */
public class Example01ClassObject {

	public static void main(String[] args) {
		PackageData p1 = new PackageData();
		p1.trackingNumber = "PK001";
		p1.location = "Bangkok";
		PackageData p2 = new PackageData();
		p2.trackingNumber = "PK002";
		p2.location = "London";
		System.out.println("p1 = " + p1.trackingNumber + ", " + p1.location);
		System.out.println("p2 = " + p2.trackingNumber + ", " + p2.location);
	}

	static class PackageData {
		String trackingNumber;
		String location;
	}
}
