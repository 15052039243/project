public class Item {

    private String name;
    private double score;

    public Item() {
        this.name = "a Name";
        this.score = 99.9;
    }

    public Item(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Sports{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}