import java.io.File;
import java.io.FileWriter;

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
        } else {
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

    // 存储用户信息
    public static void storeUserInfo(String username, String password) {
        try {
            File file = new File("users.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file, true);
            writer.write(username + "," + password + "\n");
            writer.close();
            System.out.println("User info stored successfully.");
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
    public static void storeRecord(String username, double record){
            try {
                File file = new File("record.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter writer = new FileWriter(file, true);
                writer.write(username + "," + record + "\n");
                writer.close();
            } catch (Exception e) {
                System.out.println("Exception caught: " + e.getMessage());
            }

    }
}
