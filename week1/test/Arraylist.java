package week1.test;

import java.util.ArrayList;
import java.util.Iterator;
public class Arraylist {
    // Simple PackageData class
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
        ArrayList<PackageData> packageList = new ArrayList<>();

        // Add some PackageData objects
        packageList.add(new PackageData("PK001", "Bangkok"));
        packageList.add(new PackageData("PK002", "London"));
        packageList.add(new PackageData("PK003", "NYC"));

		for (Iterator<PackageData> it = packageList.iterator(); it.hasNext(); ) {
			System.out.println(it.next().toString());
		}

        // Print all package data
        System.out.println("All Packages in ArrayList:");
        for (PackageData pkg : packageList) {
            pkg.printInfo();
        }
    }
}
