package lessons.generics;

/**
 * Examples of code with and without generics
 */
public class Example_1 {
    public static void main(String[] args) {
        /** non-generic example */
        ObjectBox objBox = new ObjectBox();
        objBox.set("hello");
        objBox.set(3);
        String item = (String) objBox.get();  // runtime error!

        /** narrowly typed */
        StringBox strBox = new StringBox();
        strBox.set("hello");
        // strBox.set(5);  compile error!

        /** Generic version */
        Box<String> box = new Box<>();
        box.set("hello");
        // genBox.set(5);  compile error!
    }
}

/**
 * Begin by examining a non-generic Box class
 */
class ObjectBox {
    private Object item;

    public void set(Object item) {
        this.item = item;
    }

    public Object get() {
        return item;
    }
}

/**
 * Begin by examining a non-generic Box class. Alternative to Object, but narrowly typed
 */
class StringBox {
    private String item;

    public void set(String item) {
        this.item = item;
    }

    public String get() {
        return item;
    }
}

/**
 * Generic version of the Box class.
 * @param <T> the type of the value being boxed
 */
class Box<T> {
    // T stands for "Type"
    private T item;

    public void set(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }
}