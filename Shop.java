public class Shop {
    private Yoke[] yokes;
    private int total = 0;

    public Shop(int numberItems) {
        yokes = new Yoke[numberItems];
    }

    private boolean isFull() {
        return total == yokes.length;
    }

    private boolean isEmpty() {
        return total == 0;
    }

    public boolean add(Yoke ayoke) {
        if (isFull()) {
            return false;
        } else {
            yokes[total] = ayoke;
            total++;
            return true;
        }
    }

    public String list() {
        if (isEmpty()) {
            return "No yokes in the store";
        } else {
            String listOfYokes = "";
            for (int i = 0; i < total; i++) {
                listOfYokes += i + ": " + yokes[i] + "\n";
            }
            return listOfYokes;
        }
    }

    public Yoke find(String name) {

        Yoke foundYoke =  null;

        if (!isEmpty()) {
            for (int i = 0; i < total; i++)
                if (yokes[i].getName().equals(name))
                    foundYoke = yokes[i];
        }
        else {
            return null;
        }
        return foundYoke;
    }
}
