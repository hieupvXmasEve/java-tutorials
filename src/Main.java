import java.io.*;

public class Main {
    public static void main(String[] args) {
//        How to write a file using Java (4 popular options)
//        FileWriter = Good for small or medium-sized text files.
//        BufferedWriter = Better performance for large amount
//        PrintWriter = Best for structured data, like reports or logs
//        FileOutputStream = Best for binary files (e.g., images, audio files)

//        try (FileWriter writer = new FileWriter("text.txt")) {
//            writer.write("I like pizza!");
//
//        } catch (IOException e) {
//            System.out.println("Could not write file");
//        }

//        How to read a file using Java (3 popular options)
//        BufferedReader + FileReader: Best for reading text files line-by-line
//        FileInputStream: Best for binary files (e.g., images, audio file)
//        RandomAccessFile: Best for read/write specific portions of a large file.

        String filePath = "/Users/hunt2412/hieupvdev/learn/java/java-tutorials/test.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not locate file");
        } catch (IOException e) {
            System.out.println("Could not read file");
        }
    }
}
