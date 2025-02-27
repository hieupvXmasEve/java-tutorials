public class Car {

    String make = "Ferrari";
    String model = "F9";
    int year = 2025;
    double price = 58000.99;
    boolean isRunning = false;

    Engine engine;

    Car(String model, int year, String engineType) {
        this.model = model;
        this.year = year;
        this.engine = new Engine(engineType);
    }


    void start() {
        isRunning = true;
        System.out.println("You start the engine");
    }

    void stop() {
        System.out.println("You start the engine");
    }
}
