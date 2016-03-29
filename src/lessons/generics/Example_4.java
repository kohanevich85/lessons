package lessons.generics;

/**
 * Examples of Generic Methods
 */
public class Example_4 {

    public static void main(String[] args) {
        Pair<Integer, String> p1 = new Pair<>(1, "apple");
        Pair<Integer, String> p2 = new Pair<>(2, "pear");
        Pair<Integer, Integer> p3 = new Pair<>(2, 3);
        boolean same = Util.<Integer, String>compare(p1, p2); // but not allowed compare p1 with p3
        System.out.println(same);
    }
}

class Util {
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
    }
}
