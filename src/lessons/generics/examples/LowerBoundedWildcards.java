package lessons.generics.examples;

import java.util.Arrays;
import java.util.List;

/**
 * Lower Bounded Wildcards
 */
public class LowerBoundedWildcards {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        List<Number> numbers = Arrays.asList(1L, 2L, 3L, 4L);
        List<Double> doubles = Arrays.asList(1D, 2D, 3D, 4D);

        addNumbers(numbers);
        addNumbers(integers);
        //addNumbers(doubles);
    }

    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }
}
