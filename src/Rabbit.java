public class Rabbit implements Prey, Predator {

    @Override
    public void flee() {
        System.out.println("Rabbit flee");
    }

    @Override
    public void hunt() {
        System.out.println("Rabbit hunt");
    }
}
