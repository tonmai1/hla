package week1.unit3;

import java.util.ArrayList;
import java.util.HashMap;

public class Example04ObjectCollection {
	static class PackageData {
		private final String trackingNumber;
		private String location;

		PackageData(String trackingNumber, String location) {
			this.trackingNumber = trackingNumber;
			this.location = location;
		}

		String getTrackingNumber() {
			return trackingNumber;
		}

		void updateLocation(String newLocation) {
			this.location = newLocation;
		}

		void printInfo() {
			System.out.println(trackingNumber + " -> " + location);
		}
	}

	public static void main(String[] args) {
		// Slides 2-3, 6: Objects can live in Collections.
		ArrayList<PackageData> packages = new ArrayList<>();
		packages.add(new PackageData("PK001", "Bangkok"));
		packages.add(new PackageData("PK002", "Khon Kaen"));

		HashMap<String, PackageData> byTracking = new HashMap<>();
		for (PackageData pkg : packages)
			byTracking.put(pkg.getTrackingNumber(), pkg);

		PackageData found = byTracking.get("PK002");
		if (found != null)
			found.updateLocation("London");
		for (PackageData pkg : packages)
			pkg.printInfo();
		// Same object is stored in the list and referenced by the map.
	}
}
