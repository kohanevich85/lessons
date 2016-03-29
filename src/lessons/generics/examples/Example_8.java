package lessons.generics.examples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Generic Classes and Subtyping
 */
public class Example_8 {
    public static void main(String[] args) {

        Collection<String> collection = new ArrayList<>();
        List<String> list = new ArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();

        f(collection);
        f(list);
        f(arrayList);

        // ???
        PayloadList<String, String> payloadList = null;
        //f(payloadList);  // is it ok?

       /* PayloadList<String, Integer> payloadList_ = null;
        //f(payloadList_);  // is it ok?*/
    }

    public static void f(Collection<String> collection) {/*...*/}

    public static void f(PayloadList<String, String> payloadList) {/*...*/}

    interface PayloadList<E, P> extends List<E> {
        void setPayload(int index, P val);
    }
}

