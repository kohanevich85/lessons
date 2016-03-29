package lessons.generics.examples;

import java.util.ArrayList;
import java.util.List;

/**
 * Wildcard Use
 */
public class Example_13 {
    public static void main(String[] args) {

        List<Integer> le = new ArrayList<>();
        List<? extends Number> ln = le;       // OK
       // ln.add(5);                          // compile-time error
        ln.add(null);
        ln.clear();
        ln.remove(0);
    }


    /** An "In" Variable like read operation / Upper bounded wildcard */
    public static void f(List<? extends Number> ln) {
        for (Number number : ln) {
            System.out.println(number.intValue());
        }
    }

    /** An "Out" Variable like write operation / Lower bounded wildcard */
    public static void f_(List<? super Integer> ln) {
        ln.add(5);
    }
}
