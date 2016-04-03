package lessons.generics.examples;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Wildcards. Upper Bounded Wildcards
 */
public class UpperBoundedWildcards {
    public static void main(String[] args) {
        List<Integer> li = asList(1, 2, 3);
        System.out.println("sum = " + sumOfList(li));


        List<Double> ld = asList(1.2, 2.3, 3.5);
        System.out.println("sum = " + sumOfList(ld));
    }

    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }
}
