package week1.unit2;

/**
 * Java OOP Foundation - Unit 2. Each file can run on its own via Run As > Java
 * Application in Eclipse.
 */
public class Example02AttributesMethods {

	public static void main(String[] args) {
		PackageData p = new PackageData();
		p.trackingNumber = "PK001";
		p.updateLocation("Bangkok");
		System.out.println(p.trackingNumber + " -> " + p.location);
		p.updateLocation("Chiang Mai");
		System.out.println("Updated -> " + p.location);
	}

	static class PackageData {
		String trackingNumber; // Attribute: data
		String location; // Attribute: data

		void updateLocation(String newLocation) { // Method: behavior
			location = newLocation;
		}
	}
}
