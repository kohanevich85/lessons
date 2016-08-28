package lessons.generics.examples;

/**
 * Erasure of Generic Types
 */
public class ErasureType {
    public static void main(String[] args) {

    }
}

/**
 * Erasure unbounded type
 */
class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }
}

/**
 * Because the type parameter T is unbounded, the Java compiler replaces it with Object:
 */
class Node_ {
    private Object data;
    private Node_ next;

    public Node_(Object data, Node_ next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() { return data; }
}

/**
 *  Erasure bounded type
 */
class _Node_<T extends Comparable<T>> {

    private T data;
    private _Node_<T> next;

    public _Node_(T data, _Node_<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() { return data; }
}

/**
 * The Java compiler replaces the bounded type parameter T with the first bound class, Comparable:
 */
class _Node__ {

    private Comparable data;
    private _Node__ next;

    public _Node__(Comparable data, _Node__ next) {
        this.data = data;
        this.next = next;
    }

    public Comparable getData() { return data; }
}
