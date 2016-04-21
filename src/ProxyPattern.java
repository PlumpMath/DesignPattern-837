/**
 * Created by Wikipedia
 */
interface Image {
    public void display();
}

class RealImage {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
    }

    private void loadImageFromDisk() {
        System.out.println("Loading " + filename);
    }

    public void display() {
        System.out.println("Display " + filename);
    }
}

class ProxyImage implements Image {
    private RealImage image = null;
    private String filename = null;

    public ProxyImage(final String filename) {
        this.filename = filename;
    }

    public void display() {
        if (image == null) {
            image = new RealImage(filename);
        }
        image.display();
    }

}

public class ProxyPattern {
    public static void main(String[] args) {
        final Image fruit = new ProxyImage("fruit.jpg");
        final Image vegetable = new ProxyImage("vegetable.jpg");

        fruit.display();
        vegetable.display();
    }
}
