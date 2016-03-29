package lessons.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Wildcards. Unbounded Wildcards
 */
public class Example_11 {
    public static void main(String[] args) {


        List<Object> li_ = Arrays.asList(1, 2, 3);
        List<Object> ls_ = Arrays.asList("one", "two", "three");

        printList(li_);
        printList(ls_);



        List<Integer> li = Arrays.asList(1, 2, 3);
        List<String> ls = Arrays.asList("one", "two", "three");

        _printList(li);
        _printList(ls);
        // printList(li); does not compile
        // printList(ls);



        List<Object> list = new ArrayList<>();
        list.add(new Object());
        list.add(5);
        list.add("hello");

        List<?> list_ = new ArrayList<>();
        list_.add(null);
    }

    public static void printList(List<Object> list) {
        for (Object elem : list)
            System.out.println(elem + " ");
        System.out.println();
    }

    public static void _printList(List<?> list) {
        for (Object elem: list)
            System.out.print(elem + " ");
        System.out.println();
    }
}
