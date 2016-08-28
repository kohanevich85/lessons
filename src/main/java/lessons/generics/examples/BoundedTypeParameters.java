package lessons.generics.examples;

import java.io.Serializable;

/**
 * Bounded Type Parameters
 */
public class BoundedTypeParameters {

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        integerBox.set(10);
        integerBox.inspect(5D);
        //integerBox.inspect("some text"); // error: this is still String!
    }

    static class Box<T extends Number & Serializable> {
        private T t;
        public void set(T t) { this.t = t; }
        public T get() { return t; }

        public <U extends Number> void inspect(U u){
            System.out.println("T: " + t.getClass().getName());
            System.out.println("U: " + u.getClass().getName());
        }
    }
}
