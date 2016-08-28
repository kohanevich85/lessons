package lessons.generics.examples;

import java.util.ArrayList;
import java.util.List;

/**
 * Wildcard Use
 */
public class UseWildcard {
    public static void main(String[] args) {

        List<Integer> le = new ArrayList<>();
        List<Integer> o = new ArrayList<>();
        List<? extends Number> ln = le;       // OK
       // ln.add(5);                          // compile-time error
        ln.add(null);
        ln.clear();
        ln.remove(0);
        f_(o);
    }


    /** An "In" Variable like read operation / Upper bounded wildcard */
    public static void f(List<? extends Number> in) {
        for (Number number : in) {
            System.out.println(number.intValue());
        }
    }

    /** An "Out" Variable like write operation / Lower bounded wildcard */
    public static void f_(List<? super Integer> out) {
        out.add(5);
    }

    public static void f(List<? extends Integer> src, List<? super Integer> dest) {
        for (Integer n : src) {
            dest.add(n);
        }
    }
}
