package lessons.generics.task.solution;

/**
 * Created by Denis on 4/3/2016
 */
public class Task_1 {
    public static void main(String[] args) {
        Product product_1 = new Product();
        product_1.setPrice(100);
        Product product_2 = new Product();
        product_2.setPrice(105);

        Phone phone_1 = new Phone();
        phone_1.setMemory(64);
        phone_1.setPrice(400);

        Phone phone_2 = new Phone();
        phone_2.setMemory(32);
        phone_2.setPrice(350);

        Camera camera_1 = new Camera();
        camera_1.setMegaPixels(16);
        camera_1.setPrice(500);

        Camera camera_2 = new Camera();
        camera_2.setMegaPixels(18);
        camera_2.setPrice(550);

        System.out.println(Util.min(camera_1, camera_2));
        System.out.println(Util.min(phone_1, phone_2));
        System.out.println(Util.min(product_1, product_2));

       /* System.out.println(Util.min(product_1, phone_1));  // compile error
        System.out.println(Util.min(camera_1, phone_1));*/
    }
}

class Product<T extends Product<T> & Comparable<T>> implements Comparable<T> {
    private int price;
    @Override
    public int compareTo(T that) {
        return this.price - that.getPrice();
    }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
    public String toString() { return "Product{price=" + price + '}'; }
}

class Phone extends Product<Phone> implements Comparable<Phone> {
    private int memory;
    @Override
    public int compareTo(Phone that) {
        return super.compareTo(that) + this.memory - that.getMemory();
    }
    public int getMemory() { return memory; }
    public void setMemory(int memory) { this.memory = memory; }
    public String toString() { return "Phone{memory=" + memory + '}'; }
}

class Camera extends Product<Camera> implements Comparable<Camera> {
    private int megaPixels;
    @Override
    public int compareTo(Camera that) {
        return super.compareTo(that) + this.megaPixels - that.getMegaPixels();
    }
    public int getMegaPixels() { return megaPixels; }
    public void setMegaPixels(int megaPixels) { this.megaPixels = megaPixels; }
    public String toString() { return "Camera{megaPixels=" + megaPixels + '}'; }
}

class Util {
    public static <T extends Product<T>> T min(T one, T two) {
        return one.compareTo(two) < 0 ? one : one.compareTo(two) > 0 ? two : one;
    }
}