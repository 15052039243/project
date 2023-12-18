import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private Scanner input = new Scanner(System.in);
    private Store store;

    public static void main(String[] args) {
        System.out.print("Welcome to campus physical test management system!    ₍˄·͈༝·͈˄*₎◞ \n");
        Main main = new Main();

        System.out.println("User login/register. \n[0]login\n[1]register");
        int option = main.input.nextInt();
        main.input.nextLine();
        if(option==1){
            main.register();
        }
        main.login();
        main.choice();
    }

    private void register() {
        String username;
        while (true){
            System.out.print("Please enter your username: ");
            username = input.nextLine();
            if (this.is_user_exist(username)){
                System.out.println("Error: user name already exist!");
                continue;
            }
            break;
        }
        System.out.print("Please enter your password: ");
        String password = input.nextLine();
        Store.storeUserInfo(username, password);
        System.out.println("User create success! Please login.");
    }

    private boolean is_user_exist(String username){
        try {
            File file = new File("users.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts[0].strip().equals(username)) {
                    return true;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            return false;
        }
        return false;
    }

    // 登录方法
    private void login() {
        System.out.println("Please enter your username: ");
        String username = input.nextLine();

        System.out.println("Please enter your password: ");
        String password = input.nextLine();


        try {
            File file = new File("users.txt");
            Scanner scanner = new Scanner(file);
            boolean success = false;
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts[0].strip().equals(username) && parts[1].strip().equals(password)) {
                    success = true;
                    break;
                }
            }
            scanner.close();
            if (!success) {
                System.out.println("Username or password is incorrect.");
                login(); // 如果登录不成功，递归调用自身重新登录
            } else {
                System.out.println("The current location is detected correctly.\n" +
                        "                       Login successfully........"

                );
            }
        } catch (FileNotFoundException e) {
            System.out.println("User is not found.Please register.");
            register();
        }
    }


    private int mainMenu() {
        System.out.print("                \n" +
                "                Menu\n" +
                "            ---------\n" +
                "              1) Shop\n" +
                "              2) Add sport records\n" +
                "              3) List all records\n" +
                "              4) Find a record\n" +
                "              0) Exit\n" +
                "            ==>>");
        int option = input.nextInt();
        return option;
    }

    private void choice() {
        int option = mainMenu();

        while (option != 0) {

            switch (option) {
                case 1:
                    choice0();
                    break;
                case 2:
                    System.out.print("How many records would you like to add?\n");
                    int numberProducts = input.nextInt();
                    int n=numberProducts;
                    store = new Store(numberProducts);
                    int i = 0;
                    while (n>i)
                    {
                        addARecord();
                        i++;
                    }
                    break;
                case 3:
                    printAllRecords();
                    break;
                case 4:
                    findARecord();
                    break;
                default:
                    System.out.println("Invalid option entered: " + option);
            }

            System.out.println("\nPress enter key to continue...");
            input.nextLine();
            option = mainMenu();
        }
        System.out.println("Exiting....\n" +
                "                      Hope that you are satisfied with our services.\n" +
                "                      Bye bye~~");
        System.exit(0);
    }

    private int Menu() {
        System.out.print("            Please enter a number to select your item.\n" +
                "                         //Menu//\n" +
                "                /Item/               /Price/\n" +
                "            1).basketball         120rmb/each\n" +
                "            2).football           100rmb/each\n" +
                "            3).table tennis bats  80rmb/each pair\n" +
                "            4).battledore         100rmb/each pair\n" +
                "            5).sneaker            150rmb/each pair\n" +
                "            6).solid ball         30rmb/each\n" +
                "            7).a swimming outfit(contain a swim cap,a swimsuit,a pair of goggles)\n" +
                "                                  80rmb/each \n" +
                "            0).exit\n" +
                "             // ...");
        int option = input.nextInt();
        return option;

    }

    private void choice1() {
        int option = Choice();
        switch (option) {
            case 1:
                yes();
                break;
            case 2:
                choice0();
                break;
            default:
                System.out.println("Invalid option entered: " + option);
        }
    }

    private void choice0() {
        int option = Menu();
        switch (option) {
            case 0:
                choice();
                break;
            case 1:
                choice1();
                break;
            case 2:
                choice1();
            case 3:
                choice1();
                break;
            case 4:
                choice1();
                break;
            case 5:
                choice1();
                break;
            case 6:
                choice1();
                break;
            case 7:
                choice1();
                break;
            default:
                System.out.println("Invalid option entered: " + option);
        }
        input.nextLine();
        input.nextLine();
        option = Menu();
    }

    private int Choice() {
        System.out.println("Are you sure to spend money on this item?\");\n" +
                "        System.out.print(\"\"\"\n" +
                "            1).Yes\n" +
                "            2).No\n" +
                "             // ... ");
        int option = input.nextInt();
        return option;

    }

    private int back() {
        System.out.print("Please enter 1 to come back.");
        int option = input.nextInt();
        return option;
    }

    private void yes() {
        System.out.println("The purchase is successful!");
        int option = back();
        switch (option) {
            case 1:
                choice0();
                break;
            case 2:
                choice0();
                break;
            default:
                System.out.println("Invalid option entered: " + option);
        }
        input.nextLine();
        input.nextLine();

    }

    private void addARecord() {
        input.nextLine();

        System.out.print("Enter the Student Name:  ");
        String studentName = input.nextLine();
        System.out.print("Enter the cost time:  ");
        double studentTime = input.nextDouble();
        input.nextLine();
        Store.storeRecord(studentName,studentTime);
        Item temp = new Item(studentName, studentTime);
        boolean isAdded = store.add(temp);
        if (isAdded) {
            System.out.println("Record added successfully. Do you want to check in (y/n)?");
            if (input.nextLine().strip().equals("y")){
                studentCheckIn(studentName);
            }
        } else {
            System.out.println("No Record Added");
        }
    }

    private void printAllRecords() {
        System.out.println("List of Records are:");
        System.out.println(store.list());
    }

    private void findARecord() {
        input.nextLine();

        System.out.print("Please Enter a Record Name to Find : ");
        String recordName = input.nextLine();

        Item foundRecord = store.find(recordName);

        if (foundRecord != null) {
            System.out.println("The found Record is:  " + foundRecord);
        } else {
            System.out.println("There are no Records with the name [" + recordName + "] in the System.");
        }
    }

    // 学生签到方法
    private void studentCheckIn(String name) {
        Item foundRecord = store.find(name);

        if (foundRecord != null) {
            foundRecord.checkIn(name);
        } else {
            System.out.println("There is no record with the name [" + name + "] in the System.");
        }
    }
}
