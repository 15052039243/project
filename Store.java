public class Store {
    private Item[] items;
    private int total = 0;

    public Store(int numberItems) {
        items = new Item[numberItems];
    }
    private boolean isFull() {
        return total == items.length;
    }

    private boolean isEmpty() {
        return total == 0;
    }

    public boolean add(Item aitem) {
        if (isFull()) {
            return false;
        }
        else {
            items[total] = aitem;
            total++;
            return true;
        }
    }

    public String list() {
        if (isEmpty()) {
            return "No items in the store";
        } else {
            String listOfItems = "";
            for (int i = 0; i < total; i++) {
                listOfItems += i + ": " + items[i] + "\n";
            }
            return listOfItems;
        }
    }

    public Item find(String name) {

        Item foundItem = null;

        if (!isEmpty()) {
            for (int i = 0; i < total; i++)
                if (items[i].getName().equals(name))
                    foundItem = items[i];
        } else {
            return null;
        }
        return foundItem;
    }
}