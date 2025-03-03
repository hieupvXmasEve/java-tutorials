public class Main {
    public static void main(String[] args) {
//        Hãy viết một chương trình mô phỏng 3 thread:
//        Thread 1: In các số chẵn từ 0 đến 10.
//        Thread 2: In các số lẻ từ 1 đến 9.
//        Thread 3: Chờ 2 thread kia hoàn thành, rồi in "Done!".

        Runnable evenTask = () -> {
            for (int i = 0; i <= 10; i += 2) {
                System.out.println("Even Thread: " + i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
            }
        };

        Runnable oddTask = () -> {
            for (int i = 1; i <= 9; i += 2) {
                System.out.println("Odd Thread: " + i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
            }
        };
        Thread evenThread = new Thread(evenTask);
        Thread oddThread = new Thread(oddTask);

        Runnable doneTask = () -> {
            try {
                evenThread.join();
                oddThread.join();
                System.out.println("Done!");
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        };
        Thread doneThread = new Thread(doneTask);

        evenThread.start();
        oddThread.start();
        doneThread.start();
    }
}
