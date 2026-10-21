package week1.unit3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Example03ForEach {
	static class PackageData {
		String trackingNumber;
		String location;

		PackageData(String trackingNumber, String location) {
			this.trackingNumber = trackingNumber;
			this.location = location;
		}

		void printInfo() {
			System.out.println(trackingNumber + " -> " + location);
		}
	}

	public static void main(String[] args) {
		// Slide 6: Enhanced for loop for both Strings and custom Objects.
		ArrayList<String> rooms = new ArrayList<>();
		rooms.add("A101");
		rooms.add("A102");
		for (String room : rooms)
			System.out.println("Room: " + room);

		ArrayList<PackageData> packageList = new ArrayList<>();
		packageList.add(new PackageData("PK001", "Bangkok"));
		packageList.add(new PackageData("PK002", "London"));
		for (PackageData pkg : packageList)
			pkg.printInfo();

		HashMap<String, String> statusMap = new HashMap<>();
		statusMap.put("PK001", "READY");
		statusMap.put("PK002", "IN_TRANSIT");
		for (Map.Entry<String, String> entry : statusMap.entrySet()) {
			System.out.println(entry.getKey() + " status: " + entry.getValue());
		}
	}
}
