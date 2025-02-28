import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
//        Anonymous class = A class that doesn't have a name. Cannot be referenced.
//        Add custom behavior without having to create a new class
//        Often used for one time uses (timerTask, Runnable, callbacks)
//        Dog dog1 = new Dog();
//        Dog dog2 = new Dog() {
//            @Override
//            void speak() {
//                System.out.println("Scooby Doo says *Ruh Roh*");
//            }
//        };
//        dog1.speak();
//        dog2.speak();

//        Timer = Class that schedules tasks at specific times or periodically
//        Useful for: sending notifications, scheduled updates, repetitive actions
//        TimerTask = Represents the task that will be executed by the Timer
//        You will extend the TimerTask class to define your task
//        Create a subclass of TimerTask and @Override the run() method
//        Timer timer = new Timer();
//        TimerTask task = new TimerTask() {
//            int count = 3;
//
//            @Override
//            public void run() {
//                System.out.println("Hello");
//                count--;
//                if (count < 0) {
//                    System.out.println("Task complete!");
//                    timer.cancel();
//                }
//            }
//        };
//
//        timer.schedule(task, 0, 1000);

//        Exercise: Countdown Timer
//        B1: Create a class that extends TimerTask
//        B2: Override run()
//        B3: Create a timer
//        B4: Schedule the timer to run every second

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            int count = number;

            @Override
            public void run() {
                System.out.println(count);
                count--;
                if (count < 0) {
                    System.out.println("HPNY!");
                    timer.cancel();
                }
            }
        };

        timer.scheduleAtFixedRate(task, 0, 1000);
    }
}
