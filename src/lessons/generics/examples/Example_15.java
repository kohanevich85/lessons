package lessons.generics.examples;

/**
 * Erasure of Generic Methods
 */
public class Example_15 {
    public static void main(String[] args) {

    }

    public static <T> int count(T[] anArray, T elem) {
        int cnt = 0;
        for (T e : anArray)
            if (e.equals(elem))
                ++cnt;
        return cnt;
    }

    /**
     * Because T is unbounded, the Java compiler replaces it with Object:
     */
    public static int count_(Object[] anArray, Object elem) {
        int cnt = 0;
        for (Object e : anArray)
            if (e.equals(elem))
                ++cnt;
        return cnt;
    }

    public static <T extends Shape> void draw(T shape) { /* ... */ }

    public static void draw_(Shape shape) { /* ... */ }

    class Shape { /* ... */ }
    class Circle extends Shape { /* ... */ }
    class Rectangle extends Shape { /* ... */ }
}
