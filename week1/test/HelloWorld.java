package week1.test;

import week1.unit2.Example01ClassObject;
import week1.unit2.Visibility;

public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello from week1.test.HelloWorld");

		// Bring public members from package week1.unit2
		Visibility v = new Visibility();
		System.out.println("public field: " + v.pub);
		v.showAll(); // public method

		// These would not compile from this package:
		// System.out.println(v.pack); // no keyword = same package only
		// System.out.println(v.priv); // private

		System.out.println("--- public class Example01ClassObject ---");
		Example01ClassObject.main(args);
	}
}
