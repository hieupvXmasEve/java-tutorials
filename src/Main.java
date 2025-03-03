import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Multithreading = Enables a program to run multiple threads concurrently
//        (Thread = A set of instructions that run Independently)
//        Useful for background task or time-consuming operations

        // Creating a thread
//        Thread thread1 = new Thread(new MyRunnable("Ping"));
//        Thread thread2 = new Thread(new MyRunnable("Pong"));
//        System.out.println("Game start!");
//        thread1.start();
//        thread2.start();
//        try {
//            thread1.join();
//            thread2.join();
//        } catch (InterruptedException e) {
//            System.out.println("Thread interrupted");
//        }
//        System.out.println("Game over!");

//        Exercise: Java Alarm Clock

        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;

        while (alarmTime == null) {
            try {
                System.out.println("Enter an alarm time (HH:mm:ss): ");
                String inputTime = scanner.nextLine();
                alarmTime = LocalTime.parse(inputTime, formatter);
                System.out.println(alarmTime.toString());
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. Please use HH:mm:ss");
            }
        }

        AlarmClock alarmClock = new AlarmClock(alarmTime);
        Thread alarmThread = new Thread(alarmClock);
        alarmThread.start();
        scanner.close();
    }
}
