public class Student {

    private String name;
    private double price;

    public Student() {
        this.name = "a Name";
        this.price = 99.99;
    }

    public Student(String name, double price) {
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
        return "Student{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}