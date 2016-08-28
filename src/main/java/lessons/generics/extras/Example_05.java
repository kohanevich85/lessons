package lessons.generics.extras;

/**
 * Arrays inheritance problem
 */
public class Example_05 {
    public static void main(String[] args) {
        String[] strings = new String[1];
        Object[] objects = strings;
        objects[0] = new Object();
        f(strings);
    }

    static void f(String[] st) {
        for (String s : st) {
            s.charAt(1);
        }
    }
}
