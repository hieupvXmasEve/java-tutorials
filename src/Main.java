import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello World!");
//        String name = "hieupv";
//
//        int length = name.length();
//        char letter = name.charAt(0);
//
//        System.out.println(length);
//        System.out.println(letter);
//
//        String email = "hieupv@gmail.com";
//
//        System.out.println(email.substring(0, email.indexOf("@")));
//        System.out.println(email.substring(email.indexOf("@")));
//
//        String day = "day";
//        switch (day) {
//            case "day" -> System.out.println("Day");
//        }

        // Array
        String[] fruits = {"apple", "orange", "banana", "coconut"};

        Arrays.sort(fruits);

        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        String[] foods = new String[1];
        foods[0] = "pizza";
        System.out.println(Arrays.toString(foods));
    }
}
