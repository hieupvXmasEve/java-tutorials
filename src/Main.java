import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

/*
        How to work with Dates & Times using Java
        (LocalDate, LocalTime, LocalDateTime, Instant, UTC timestamps)
        LocalDateTime date = LocalDateTime.now();

        Instant instant = Instant.now();
        System.out.println(date);
        System.out.println(instant);
        Custom format
*/
//        LocalDateTime dateTime = LocalDateTime.now();
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//        System.out.println(dateTime.format(formatter));

        LocalDateTime date = LocalDateTime.of(2024, 1, 1, 12, 3, 2);
        LocalDateTime date1 = LocalDateTime.of(2024, 1, 1, 12, 3, 2);
        if (date.isBefore(date1)) {
            System.out.println(date + " is before " + date1);
        } else if (date.isAfter(date1)) {
            System.out.println(date + " is later than " + date1);
        } else {
            System.out.println(date + " is equal to " + date1);
        }
    }
}
