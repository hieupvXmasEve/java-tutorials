import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        How to Play Audio with Java (.wav, .au, .aiff)

        String filePath = "src/What If So Then - Karneef.wav";
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(System.in)) {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            String response = "";

            while (!response.equals("Q")) {
                System.out.println("P = Play");
                System.out.println("S = Stop");
                System.out.println("R = Restart");
                System.out.println("Q = Quit");
                System.out.println("Enter your choise: ");

                response = scanner.next().toUpperCase();

                switch (response) {
                    case "P" -> clip.start();
                    case "S" -> clip.stop();
                    case "R" -> clip.setMicrosecondPosition(0);
                    default -> System.out.println("Invalid choice");
                }
            }


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (UnsupportedAudioFileException e) {
            System.out.println("Audio file is not supported");
        } catch (IOException e) {
            System.out.println("Something went wrong");
        } catch (LineUnavailableException e) {
            System.out.println("Unable to access audio resource");
        } finally {
            System.out.println("Done");
        }
    }
}
