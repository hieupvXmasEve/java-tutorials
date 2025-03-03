import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2); // Tạo pool với 2 thread

        executor.submit(() -> {
            for (int i = 0; i < 5; i++) System.out.println("Task 1: " + i);
        });
        executor.submit(() -> {
            for (int i = 0; i < 5; i++) System.out.println("Task 2: " + i);
        });

        executor.shutdown(); // Đóng executor sau khi hoàn thành
    }
}