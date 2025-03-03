public class Main {
    public static void main(String[] args) {
//        Enum = (Enumerations) A special kind of class that represents a fixed set of constants.
//        They improve code readability and are easy to maintain.
//        More efficient with switches when comparing Strings.

        Day day = Day.SUNDAY;

        switch (day) {
            case SUNDAY:
                System.out.println("Sunday");
                break;
            case MONDAY:
                System.out.println("Monday");
                break;
            case TUESDAY:
                System.out.println("Tuesday");
                break;
            case WEDNESDAY:
                System.out.println("Wednesday");
                break;
            case THURSDAY:
                System.out.println("Thursday");
                break;
            case FRIDAY:
                System.out.println("Friday");
                break;
            case SATURDAY:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Invalid day");
        }
    }
}
