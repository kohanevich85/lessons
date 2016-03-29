package lessons.generics.examples;

import java.util.List;

/**
 * Wildcard Capture and Helper Methods
 */
public class Example_04 {
    public static void main(String[] args) {

    }
}

class WildcardErrorBad<T extends Number> {

    void swapFirst(List<? extends Number> l1, List<? extends Number> l2) {
        Number temp = l1.get(0);
       // l1.set(0, l2.get(0)); // expected a CAP#1 extends Number,
        // got a CAP#2 extends Number;
        // same bound, but different types
      //  l2.set(0, temp);	    // expected a CAP#1 extends Number,
        // got a Number
    }
}
