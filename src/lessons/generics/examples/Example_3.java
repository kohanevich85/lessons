package lessons.generics.examples;

/**
 * Examples of Raw Types
 */
public class Example_3 {

    public static void main(String[] args) {
        /** For backward compatibility, assigning a parameterized type to its raw type is allowed: */
        Box<String> stringBox = new Box<>();  // not raw box
        Box rawBox = stringBox;               // OK

        rawBox.set(8); // warning: unchecked invocation to set(T)
        Integer i = (Integer) rawBox.get();
        System.out.println(i);
    }
}

class Example_3_1 {
    public static void main(String[] args) {
        /** But if you assign a raw type to a parameterized type, you get a warning: */
        Box rawBox = new Box();           // rawBox is a raw type of Box<T>
        /** @SuppressWarnings("unchecked")*/
        Box<Integer> intBox = rawBox;     // warning: unchecked conversion
    }
}
