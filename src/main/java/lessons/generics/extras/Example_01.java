package lessons.generics.extras;

public class Example_01 {

    public static void main(String[] args) {
        P<Integer> i = new P<>();
        i.pItem = 5;
        System.out.println(i.pItem);

        C<Integer, String> str = new C<>();
        str.cItem = "child";
        str.pItem = 5;
        System.out.println(str.cItem);
        System.out.println(str.pItem);
    }

    static class P<T> {
        public T pItem;
    }

    static class C<T,U> extends P<T> {
        public U cItem;
    }
}
