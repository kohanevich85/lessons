package lessons.generics;

/**
 * Generic Methods and Bounded Type Parameters
 */
public class Example_6 {
    public static void main(String[] args) {
        int result = Example_6.<String>countGreaterThan(new String[]{"1", "2", "3"}, "2");
        System.out.println(result);
    }

    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            if (e.compareTo(elem) > 0) ++count;
        return count;
    }
}
