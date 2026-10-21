package week1.unit2;

/**
 * Java OOP Foundation - Unit 2. Each file can run on its own via Run As > Java
 * Application in Eclipse.
 */
public class Example04Encapsulation {

	public static void main(String[] args) {
		PackageData p = new PackageData();
		// p.location = "Bangkok"; // Compile ERROR: location is private
		p.setLocation("Bangkok");
		System.out.println(p.getLocation());
		p.setLocation(""); // Validation in setter rejects blank data
		System.out.println("After invalid update: " + p.getLocation());
	}

	static class PackageData {
		private String location;

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			if (location == null || location.isBlank()) {
				System.out.println("Invalid location");
				return;
			}
			this.location = location;
		}
	}
}
