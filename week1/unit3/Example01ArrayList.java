package week1.unit3;

import java.util.ArrayList;

public class Example01ArrayList {
	public static void main(String[] args) {
		// Slide 4: ArrayList - a resizable list with indexes starting at 0.
		ArrayList<String> rooms = new ArrayList<>();
		rooms.add("A101");
		rooms.add("A102");
		rooms.add("A103");
		System.out.println("Rooms: " + rooms);
		System.out.println("Index 1: " + rooms.get(1)); // A102
		System.out.println("Size: " + rooms.size());
		rooms.remove("A102");
		System.out.println("After remove: " + rooms);
	}
}
