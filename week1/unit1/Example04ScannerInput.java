package week1.unit1;

import java.util.Scanner;

/**
 * Unit 1 - Slide 7: การรับข้อมูลจากคีย์บอร์ดด้วย Scanner Run As > Java
 * Application (Java 17+)
 */
public class Example04ScannerInput {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name: ");
		String name = sc.nextLine();
		System.out.print("Enter age: ");
		int age = sc.nextInt();
		sc.nextLine(); // Consume the remaining Enter before nextLine().
		System.out.print("Enter city: ");
		String city = sc.nextLine();
		System.out.println(name + " / " + age + " / " + city);

		sc.close();
	}
}
