package week1.unit2;

/**
 * Java OOP Foundation - Unit 2. Each file can run on its own via Run As > Java
 * Application in Eclipse.
 */
public class Example07PolymorphismOverride {

	public static void main(String[] args) {
		Animal a1 = new Animal();
		Animal a2 = new Dog(); // Parent type, child object
		Animal a3 = new Cat();
		a1.speak();
		a2.speak(); // Calls Dog.speak()
		a3.speak(); // Calls Cat.speak()
		// Like overriding an HLA FederateAmbassador callback.
	}

	static class Animal {
		void speak() {
			System.out.println("...");
		}
	}

	static class Dog extends Animal {
		@Override
		void speak() {
			System.out.println("Bark");
		}
	}

	static class Cat extends Animal {
		@Override
		void speak() {
			System.out.println("Meow");
		}
	}
}
