import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
//        Array list = A resizeable array that stores objects (autoboxing)
//        Arrays are fixed in size, but ArrayLists can change

        ArrayList<Double> list = new ArrayList<>();
        list.add(3.3);
        list.add(1.1);
        list.add(2.2);
//        list.removeFirst(); // list.remove(0)

//        list.set(1, 2.2);
//        System.out.println(list.getLast());

        Collections.sort(list);
        System.out.println(list);
    }
}
