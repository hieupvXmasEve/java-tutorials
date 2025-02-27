import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("hieupv", 22, 4.5);
//        System.out.println(student1.name);

        // abstract = Used to define abstract classes and methods.
        //            Abstraction is the process of hiding implementation details
        //            and showing only the essential features.
        //            Abstract classes CAN'T be instantiated directly
        //            Can contain 'abstract' methods (which must be implemented)
        //            Can contain 'concrete' methods (which are inherited)

        Circle circle = new Circle(3);
//        System.out.println(circle.getArea());


        // interface = A blueprint for a class that specifies a set of abstract methods
        //             that implementing classes MUST define.
        //             Supports multiple inheritance-like behavior

        Rabbit rabbit = new Rabbit();
//        rabbit.flee();
//        rabbit.hunt();

        // Aggregation = Represents a "has-a" relationships between objects.
        //               One object contains another object as part of its structure,
        //               but the contained object/s can exist independently

        Book book1 = new Book("The Fellow of the Ring", 123);
        Book book2 = new Book("The Fellow of the Ring", 234);
        Book book3 = new Book("The Fellow of the Ring", 356);

        Book[] books = {book1, book2, book3};

        Library library = new Library(books);
//        library.displayBooks();
//        library.removeBook(book2);
//        library.displayBooks();

        // Composition = Represents a "part-of" relationship between objects.
        //               For example, an Engine is "part of" a Car.
        //               Allows complex objects to be constructed from smaller objects.
//        Car car = new Car("F9", 2025, "V8");
//        System.out.println(car.engine.type);

        // Wrapper classes = Allow primitive values (int, char, double, boolean)
        //                   to be used as objects. "Wrap them in an object"
        //                   Generally, don't wrap primitive unless you need an object.
        //                   Allows use of Collection Framework and static Utility Methods
        // Integer a = new Integer(1);

        //  Autoboxing
//        Integer a = 12;
        // Unboxing
//        int x = a;
        String c = Character.toString('@');

    }
}
