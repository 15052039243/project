public class Yoke {

    private String name;
    private double price;

    public Yoke() {
        this.name = "a Name";
        this.price = 99.99;
    }

    public Yoke(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Yoke{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
