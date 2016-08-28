package lessons.generics.extras;

/**
 * Effects of Type Erasure and Bridge Methods
 */
public class Example_06 {
    public static void main(String[] args) {

        MyNode mn = new MyNode(5);
        Node n = mn;            // A raw type - compiler throws an unchecked warning
        n.setData("Hello");
        Integer x = mn.data;    // Causes a ClassCastException to be thrown.

        // after transform
        MyNode mn_ = new MyNode(5);
        Node n_ = (MyNode)mn_;         // A raw type - compiler throws an unchecked warning
        n_.setData("Hello");
       // Integer x_ = (String)mn_.data; // Causes a ClassCastException to be thrown.
    }

    static class Node<T> {
        public T data;
        public Node(T data) { this.data = data; }
        public void setData(T data) {
            System.out.println("Node.setData");
            this.data = data;
        }
    }

    static class MyNode extends Node<Integer> {
        public MyNode(Integer data) { super(data); }

        public void setData(Integer data) {
            System.out.println("MyNode.setData");
            super.setData(data);
        }
    }
}


