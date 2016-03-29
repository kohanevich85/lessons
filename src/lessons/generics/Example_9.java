package lessons.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Type Inference
 */
public class Example_9 {
    public static void main(String[] args) {
       /*T result = */ pick("d", new ArrayList<String>()); // which type T would be returned?

        new<String> MyClass<Integer>("");


        List<String> listOne = Collections.emptyList();
        List<String> listTwo = Collections.<String>emptyList();
        processStringList(Collections.emptyList());  // does not compile in Java SE 7
    }

    static <T> T pick(T a1, T a2) { return a2; }
    static void processStringList(List<String> stringList) { /* process stringList*/  }
}

class BoxDemo {
    public static <U> void addBox(U u, List<Box<U>> boxes) {
        Box<U> box = new Box<>();
        box.set(u);
        boxes.add(box);
    }

    public static <U> void outputBoxes(List<Box<U>> boxes) {
        int counter = 0;
        for (Box<U> box: boxes) {
            U boxContents = box.get();
            System.out.println("Box #" + counter + " contains [" + boxContents.toString() + "]");
            counter++;
        }
    }

    public static void main(String[] args) {
        ArrayList<Box<Integer>> listOfIntegerBoxes = new ArrayList<>();
        BoxDemo.<Integer>addBox(10, listOfIntegerBoxes);
        BoxDemo.addBox(20, listOfIntegerBoxes);
        BoxDemo.addBox(30, listOfIntegerBoxes);
        BoxDemo.outputBoxes(listOfIntegerBoxes);
    }
}

class MyClass<X> {
    <T> MyClass(T t) {
        // ...
    }
}