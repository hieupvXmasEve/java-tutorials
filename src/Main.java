import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Threading =  Allows a program to run multiple tasks at the same time (=simultaneously).
//        Helps improve performance with time-consuming operations.
//        (File I/O, Database operations, Network operations, or any background tasks etc.)
//
//        Advantages:
//        1. Can improve performance.
//        2. Can make the program more responsive.
//        3. Can make the program more efficient.
//
//        Disadvantages:
//        1. Can make the program more complex.
//        2. Can make the program more difficult to debug.
//        3. Can make the program more difficult to test.

//        How to create a Thread
//        Option 1: Extend the Thread class (simpler)
//        Option 2: Implement the Runnable interface (better)

        Scanner scanner = new Scanner(System.in);

        System.out.println("You have 5 seconds to enter your number");

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.setDaemon(true);
        thread.start();

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello " + name);

        scanner.close();
    }
}
