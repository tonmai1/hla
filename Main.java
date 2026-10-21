import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");

        int a =5;
        double b = 10.5;
        int c =(int)b;
        double d =a +b+c;

        System.out.println("a;"+a+", b;"+b
        +", c;"+c+", d;"+d + (", sum:")+(a+b+c+d));

        String name = "John";
        String status = "active";

        if(status.equals(name)){
            System.out.println("equals:"+ name);
        }else if(status.equals("active")){
            System.out.println("equals:"+ "active");
        }else
            System.out.println("!equals:");

        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter name: ");
        // name = sc.nextLine();
        // System.out.print("Enter age: ");
        // int age = sc.nextInt();
        // System.out.println(name + " / " + age);

        int scoress = 75;
        if (scoress >= 80) {
        System.out.println("A");
        } else if (scoress1
             >= 70) {
        System.out.println("B");
        } else {
        System.out.println("Need improve");
        }

        int menu = 1;
        switch (menu) {
            case 1:
            System.out.println("Add");
            break;
            case 2:
            System.out.println("Update");
            break;
            case 3:
            System.out.println("Search");
            break;
            case 0:
            System.out.println("Exit");
            break;
            default:
            System.out.println("Invalid");
            }
        
        // Print numbers from 0 to 4
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        // Simulate a process running flag
        boolean isRunning = false; // Set to true if you want the loop to run
        while (isRunning) {
            // keep working
        }

        // Simple menu loop example
        int choice;
        do {
            // This is a placeholder for menu. Define showMenu if needed.
            System.out.println("Menu:\n1. Option\n0. Exit");
            // To keep it running for the example, we will set choice = 0.
            // In real code, you would get input from user.
            choice = 0;
        } while (choice != 0);

        int[] scores = {10, 20, 30};
        System.out.println(scores[0]);
        //10

        for (int i = 0; i < scores.length; i++) {
        System.out.println(scores[i]);
        }
        for (int score : scores) {
        System.out.println(score);
        }

    }
}
