import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Java hangman game

        String filePath = "words.txt";
        ArrayList<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Create string variable
            String line = reader.readLine(); // Read each line

            while (line != null) {
                words.add(line.trim());
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }

        Random random = new Random();
        String word = words.get(random.nextInt(words.size()));
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> wordState = new ArrayList<>();
        int wrongGuesses = 0;
        for (int i = 0; i < word.length(); i++) {
            wordState.add('_');

        }

        System.out.println("**********************");
        System.out.println("Welcome to Java Hangman!");
        System.out.println("**********************");

        while (wrongGuesses < 6) {
            System.out.println(getHangmanArt(wrongGuesses));
            System.out.print("Word: ");
            for (char c : wordState) {
                System.out.print(c + " ");
            }
            System.out.println();
            System.out.print("Guess a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            if (word.indexOf(guess) >= 0) {
                System.out.println("Correct guess! \n");
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        wordState.set(i, guess);
                    }
                }
                if (!wordState.contains('_')) {
                    System.out.println("You won!");
                    System.out.println("The word was: " + word);
                    break;
                }
            } else {
                wrongGuesses++;
                System.out.println("Wrong guess");
            }
        }
        if (wrongGuesses >= 6) {
            System.out.println(getHangmanArt(wrongGuesses));
            System.out.println("GAME OVER!");
            System.out.println("The word was: " + word);
        }
        scanner.close();
    }

    static String getHangmanArt(int wrongGuesses) {
        return switch (wrongGuesses) {
            case 0 -> """
                    
                    
                    
                    """;
            case 1 -> """
                        0
                    
                    
                    """;
            case 2 -> """
                        0
                        |
                    
                    """;
            case 3 -> """
                        0
                       /|
                    
                    """;
            case 4 -> """
                        0
                       /|\
                    
                    """;
            case 5 -> """
                        0
                       /|\\
                       /
                    """;
            case 6 -> """
                        0
                       /|\\
                       / \\
                    """;
            default -> "";
        };
    }
}
