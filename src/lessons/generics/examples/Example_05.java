package lessons.generics.examples;

/**
 * Arrays inheritance problem
 */
public class Example_05 {
    public static void main(String[] args) {
        Object[] objects = new Object[1];
        String[] strings = new String[1];
        objects = strings;
        objects[0] = new Object();
    }
}
