package week1.unit3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Example08PackageTracking {
	static class PackageData {
		final String trackingNumber;
		String location;

		PackageData(String id, String location) {
			this.trackingNumber = id;
			this.location = location;
		}

		void printInfo() {
			System.out.println(trackingNumber + " -> " + location);
		}
	}

	static final ArrayList<PackageData> packageList = new ArrayList<>();
	static final HashMap<String, PackageData> byId = new HashMap<>();

	static void add(String id, String location) {
		if (byId.containsKey(id)) {
			System.out.println("Duplicate ID: " + id);
			return;
		}
		PackageData p = new PackageData(id, location);
		packageList.add(p);
		byId.put(id, p);
		System.out.println("Added " + id);
	}

	static void update(String id, String location) {
		PackageData p = byId.get(id);
		if (p == null)
			System.out.println("Not found: " + id);
		else {
			p.location = location;
			System.out.println("Updated " + id);
		}
	}

	static void listAll() {
		if (packageList.isEmpty())
			System.out.println("No packages.");
		for (PackageData p : packageList)
			p.printInfo();
	}

	public static void main(String[] args) {
		// Mini project outlined on slide 2: interactive Package Tracking System.
		try (Scanner sc = new Scanner(System.in)) {
			while (true) {
				System.out.println("\n1 Add | 2 Search | 3 Update | 4 List | 0 Exit");
				System.out.print("Choose: ");
				String option = sc.nextLine().trim();
				switch (option) {
				case "1" -> {
					System.out.print("Tracking number: ");
					String id = sc.nextLine().trim();
					System.out.print("Location: ");
					String loc = sc.nextLine().trim();
					if (id.isEmpty() || loc.isEmpty())
						System.out.println("Fields required.");
					else
						add(id, loc);
				}
				case "2" -> {
					System.out.print("Search ID: ");
					PackageData p = byId.get(sc.nextLine().trim());
					if (p == null)
						System.out.println("Not found.");
					else
						p.printInfo();
				}
				case "3" -> {
					System.out.print("Update ID: ");
					String id = sc.nextLine().trim();
					System.out.print("New location: ");
					String loc = sc.nextLine().trim();
					if (loc.isEmpty())
						System.out.println("Location required.");
					else
						update(id, loc);
				}
				case "4" -> listAll();
				case "0" -> {
					System.out.println("Bye!");
					return;
				}
				default -> System.out.println("Invalid option.");
				}
			}
		}
	}
}
