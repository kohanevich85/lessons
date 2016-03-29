package lessons.generics;

/**
 * Generics, Inheritance, and Subtypes
 */
public class Example_7 {
    public static void main(String[] args) {
        Object someObject = new Object();
        Integer someInteger = new Integer(10);
        someObject = someInteger;   // OK


        someMethod(10);   // OK
        someMethod(10.1);   // OK


        Box<Number> box = new Box<>();
        box.set(10);   // OK
        box.set(10.1);  // OK

        Box<Integer> box_ = new Box<>();
        boxTest(box);

        //box = box_;

    }

    public static void someMethod(Number n) { /* ... */ }
    public static void boxTest(Box<Number> n) { /* ... */ }
}
