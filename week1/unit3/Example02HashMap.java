package week1.unit3;

import java.util.HashMap;

public class Example02HashMap {
	public static void main(String[] args) {
		// Slide 5: A tracking number (Key) identifies a location (Value).
		HashMap<String, String> locationMap = new HashMap<>();
		locationMap.put("PK001", "Bangkok");
		locationMap.put("PK002", "Khon Kaen");
		System.out.println("PK001: " + locationMap.get("PK001"));
		System.out.println("Has PK003? " + locationMap.containsKey("PK003"));
		locationMap.put("PK002", "London"); // Update an existing key.
		System.out.println("PK002 updated: " + locationMap.get("PK002"));
		System.out.println("Missing key: " + locationMap.get("PK003")); // null
	}
}
