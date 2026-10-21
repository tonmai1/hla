package week1.unit2;

/**
 * Java OOP Foundation - Unit 2. Each file can run on its own via Run As > Java
 * Application in Eclipse.
 */
public class Example08Interface {

	public static void main(String[] args) {
		Trackable p = new PackageData();
		p.updateLocation("Bangkok");
		p.addLocation("London");
		// All methods required by Trackable must be implemented.
	}

	interface Trackable {
		void updateLocation(String location);

		void addLocation(String location);
	}

	static class PackageData implements Trackable {
		@Override
		public void updateLocation(String location) {
			System.out.println("Current location: " + location);
		}

		@Override
		public void addLocation(String location) {
			System.out.println("Added history: " + location);
		}
	}
}
