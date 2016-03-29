package lessons.generics.extras;

public class Example_02 {

    public static void main(String[] args) {
        I<String> ref = new Impl<>();
        ref.f("hello");
        String f = ref.f();
        System.out.println(f);
    }

    interface I<T> {
        void f(T arg);

        T f();
    }

    static class Impl<T> implements I<T> {

        private T item;

        @Override
        public void f(T arg) {
            /** do smth useful here*/
            item = arg;
            System.out.println(arg);
        }

        @Override
        public T f() {
            return item;
        }
    }
}


