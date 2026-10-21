package week1.unit2;

/**
 * Java OOP Foundation - Unit 2.
 * Each file can run on its own via Run As > Java Application in Eclipse.
 */
import java.util.Scanner;

/**
 * Combined demonstrations from all Unit 2 slides (including
 * call-by-value/reference).
 */
public class Unit2Oop {
	public static void main(String[] args) {
//		class_object();
//		attributes_methods();
//		constructor_this();
//		encapsulation();
//		static_final();
//		inheritance();
//		polymorphism_override();
//		interface_demo();
//		arguments_parameters();
//		call_by_value();
//		call_by_reference();
//		exception_handling();
	}

	private static void class_object() {
		PackageData1 p1 = new PackageData1();
		p1.trackingNumber = "PK001";
		p1.location = "Bangkok";
		PackageData1 p2 = new PackageData1();
		p2.trackingNumber = "PK002";
		p2.location = "London";
		System.out.println("p1 = " + p1.trackingNumber + ", " + p1.location);
		System.out.println("p2 = " + p2.trackingNumber + ", " + p2.location);
	}

	static class PackageData1 {
		String trackingNumber;
		String location;
	}

	private static void attributes_methods() {
		PackageData2 p = new PackageData2();
		p.trackingNumber = "PK001";
		p.updateLocation("Bangkok");
		System.out.println(p.trackingNumber + " -> " + p.location);
		p.updateLocation("Chiang Mai");
		System.out.println("Updated -> " + p.location);
	}

	static class PackageData2 {
		String trackingNumber; // Attribute: data
		String location; // Attribute: data

		void updateLocation(String newLocation) { // Method: behavior
			location = newLocation;
		}
	}

	private static void constructor_this() {
		PackageData3 p = new PackageData3("PK001");
		System.out.println("Tracking: " + p.trackingNumber);
		// 'this.trackingNumber' is the field of the current object.
		PackageData3 p2 = new PackageData3("PK002");
		System.out.println("Tracking 2: " + p2.trackingNumber);
	}

	static class PackageData3 {
		String trackingNumber;

		PackageData3(String trackingNumber) { // Constructor: same name as class
			this.trackingNumber = trackingNumber;
		}
	}

	private static void encapsulation() {
		PackageData4 p = new PackageData4();
		// p.location = "Bangkok"; // Compile ERROR: location is private
		p.setLocation("Bangkok");
		System.out.println(p.getLocation());
		p.setLocation(""); // Validation in setter rejects blank data
		System.out.println("After invalid update: " + p.getLocation());
	}

	static class PackageData4 {
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

	private static void static_final() {
		System.out.println("Federation: " + Config5.FEDERATION_NAME);
		System.out.println("Before: " + Config5.packageCount);
		new PackageData5();
		new PackageData5();
		System.out.println("After two objects: " + Config5.packageCount);
		// Config5.FEDERATION_NAME = "NEW"; // Compile ERROR: final cannot change
	}

	static class Config5 {
		static int packageCount = 0; // Shared by all objects
		static final String FEDERATION_NAME = "HLA_DEMO"; // Constant
	}

	static class PackageData5 {
		PackageData5() {
			Config5.packageCount++;
		}
	}

	private static void inheritance() {
		Car6 car = new Car6();
		Train6 train = new Train6();
		Ship6 ship = new Ship6();
		car.start();
		train.start();
		ship.start();
		car.honk();
	}

	static class Vehicle6 { // Parent class
		void start() {
			System.out.println("Vehicle6 started");
		}
	}

	static class Car6 extends Vehicle6 {
		void honk() {
			System.out.println("Car6: Beep!");
		}
	}

	static class Train6 extends Vehicle6 {
	}

	static class Ship6 extends Vehicle6 {
	}

	private static void polymorphism_override() {
		Animal7 a1 = new Animal7();
		Animal7 a2 = new Dog7(); // Parent type, child object
		Animal7 a3 = new Cat7();
		a1.speak();
		a2.speak(); // Calls Dog7.speak()
		a3.speak(); // Calls Cat7.speak()
		// Like overriding an HLA FederateAmbassador callback.
	}

	static class Animal7 {
		void speak() {
			System.out.println("...");
		}
	}

	static class Dog7 extends Animal7 {
		@Override
		void speak() {
			System.out.println("Bark");
		}
	}

	static class Cat7 extends Animal7 {
		@Override
		void speak() {
			System.out.println("Meow");
		}
	}

	private static void interface_demo() {
		Trackable8 p = new PackageData8();
		p.updateLocation("Bangkok");
		p.addLocation("London");
		// All methods required by Trackable8 must be implemented.
	}

	interface Trackable8 {
		void updateLocation(String location);

		void addLocation(String location);
	}

	static class PackageData8 implements Trackable8 {
		@Override
		public void updateLocation(String location) {
			System.out.println("Current location: " + location);
		}

		@Override
		public void addLocation(String location) {
			System.out.println("Added history: " + location);
		}
	}

	private static void arguments_parameters() {
		int packageCount = 5;
		printPackageCount9(packageCount); // packageCount = argument
		String code = "PK001";
		printTracking9(code); // code = argument
	}

	static void printPackageCount9(int count) { // count = parameter
		System.out.println("Package count = " + count);
	}

	static void printTracking9(String trackingNumber) { // parameter
		System.out.println("Tracking = " + trackingNumber);
	}

	private static void call_by_value() {
		int number = 10;
		System.out.println("Before: " + number);
		change10(number);
		System.out.println("After: " + number); // 10: unchanged
	}

	static void change10(int x) {
		System.out.println("Inside before: " + x);
		x = 100; // Change local copy
		System.out.println("Inside after: " + x);
	}

	private static void call_by_reference() {
		Aircraft11 a = new Aircraft11();
		a.name = "Gripen";
		System.out.println("Before: " + a.name);
		change11(a);
		System.out.println("After: " + a.name); // F-16
		replace11(a);
		System.out.println("After replace11(): " + a.name); // Still F-16
		// Java always passes by value: objects pass a COPY of the reference.
	}

	static class Aircraft11 {
		String name;
	}

	static void change11(Aircraft11 aircraft) {
		aircraft.name = "F-16"; // Same underlying object
	}

	static void replace11(Aircraft11 aircraft) {
		aircraft = new Aircraft11(); // Reassign only local reference
		aircraft.name = "F-35";
	}

	private static void exception_handling() {
		String[] inputs = { "123", "abc", "456" };
		for (String input : inputs) {
			try {
				int number = Integer.parseInt(input);
				System.out.println("Valid number: " + number);
			} catch (NumberFormatException e) {
				System.out.println("Invalid number: " + input);
			}
		}
		System.out.println("Program continues normally");
	}

	// In HLA code, methods can also declare: throws Exception
}
