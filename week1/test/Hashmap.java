package week1.test;

import java.util.HashMap;

public class Hashmap {
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

        @Override
        public String toString() {
            return trackingNumber + " : " + location;
        }
    }
	public static void main(String[] args) {
		HashMap<String, PackageData> data = new HashMap<String, PackageData>();
		data.put("PK001", new PackageData("PK001", "Bangkok, Thailand"));
		data.put("PK002", new PackageData("PK002", "London, UK"));
		data.put("PK003", new PackageData("PK003", "New York City, USA"));

		// Instead of calling toString directly, use printInfo for each package
		for (String key : data.keySet()) {
			data.get(key).printInfo();
		}
	}
}
