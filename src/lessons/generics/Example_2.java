package lessons.generics;

/**
 * Example of using generics
 */
public class Example_2 {
    public static void main(String[] args) {
        Pair<String, Integer> p1 = new Pair<>("Even", 8);
        Pair<String, String> p2 = new Pair<>("hello", "world");

        // You can also substitute a type parameter (i.e., K or V) with a parameterized type (i.e., List<String>)
        Pair<String, Box<Integer>> p = new Pair<>("primes", new Box<>());
    }
}

class Pair<K, V> {
    private K key;
    private V value;
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }
}
