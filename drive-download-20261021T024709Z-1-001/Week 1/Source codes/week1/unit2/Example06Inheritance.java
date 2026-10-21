package week1.unit2;

/**
 * Java OOP Foundation - Unit 2. Each file can run on its own via Run As > Java
 * Application in Eclipse.
 */
public class Example06Inheritance {

	public static void main(String[] args) {
		Car car = new Car();
		Train train = new Train();
		Ship ship = new Ship();
		car.start();
		train.start();
		ship.start();
		car.honk();
	}

	static class Vehicle { // Parent class
		void start() {
			System.out.println("Vehicle started");
		}
	}

	static class Car extends Vehicle {
		void honk() {
			System.out.println("Car: Beep!");
		}
	}

	static class Train extends Vehicle {
	}

	static class Ship extends Vehicle {
	}
}
