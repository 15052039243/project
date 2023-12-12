import java.util.Scanner;

public class Main {

    private Scanner input = new Scanner(System.in);
    private Store store;
    public static void main(String[] args) {
        System.out.print("Welcome to campus physical test management system!    ₍˄·͈༝·͈˄*₎◞ ̑̑");
        Main main = new Main();
        main.login();
        main.setup();
        main.choice();
    }
///////////////////////////////////////////////////////////////////////////////////////////////////
    private void setup() {
        System.out.print("How many records would you like to add?Write the number and you can open the menu.");
        int numberProducts = input.nextInt();
        store = new Store(numberProducts);
    }

    private void login() {
        input.nextLine();

        System.out.print("Please enter your username");
        input.nextLine();

        System.out.print("Please enter your password");
        input.nextLine();

        System.out.print("""
                 The current location is detected correctly.
                   Checking-in successfully........
                """);
        input.nextLine();
    }

    private int mainMenu() {
        System.out.print("""
                    
                    Menu
                ---------
                  1) Store
                  2) Add sport records
                  3) List all records
                  4) Find a record
                  0) Exit
                ==>> """);
        int option = input.nextInt();
        return option;
    }
    private void choice() {
        int option = mainMenu();

        while (option != 0) {

            switch (option) {
                case 1 -> choice0();
                case 2 -> addARecord();
                case 3 -> printAllRecords();
                case 4 -> findARecord();
                default -> System.out.println("Invalid option entered: " + option);
            }

            System.out.println("\nPress enter key to continue...");
            input.nextLine();
            input.nextLine();
            option = mainMenu();
        }
        System.out.println("""
                          Exiting....
                          Hope that you are satisfied with our services.
                          Bye bye~~
                          """);
        System.exit(0);
    }

    private int Menu() {
        System.out.print("""
                Please enter a number to select you item.
                             //Menu//
                    /Item/               /Price/
                1).basketball         120rmb/each
                2).football           100rmb/each
                3).table tennis bats  80rmb/each pair
                4).battledore         100rmb/each pair
                5).sneaker            150rmb/each pair
                6).solid ball         30rmb/each
                7).a swimming outfit(contain a swim cap,a swimsuit,a pair of goggles)
                                      80rmb/each 
                0).exit
                 // ... """);
        int option = input.nextInt();
        return option;

    }

    private void choice1() {
        int option = Choice();
            switch (option) {
                case 1 -> yes();
                case 2 -> choice0();
            }
        }


    private void choice0() {
        int option = Menu();
            switch (option) {
                case 0 -> choice();
                case 1 -> choice1();
                case 2 -> choice1();
                case 3 -> choice1();
                case 4 -> choice1();
                case 5 -> choice1();
                case 6 -> choice1();
                case 7 -> choice1();
                default -> System.out.println("Invalid option entered: " + option);
            }
            input.nextLine();
            input.nextLine();
            option = Menu();
    }

    private int Choice() {
        System.out.println("Are you sure to spend money on this item?");
        System.out.print("""
                1).Yes
                2).No
                 // ... """);
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
                case 1 -> choice0();
                case 2 -> choice0();
                default -> System.out.println("Invalid option entered: " + option);
            }
            input.nextLine();
            input.nextLine();
            option = back();

    }
    private void addARecord(){
        input.nextLine();
        System.out.print("Enter the Studemt Name:  ");
        String studentName = input.nextLine();
        System.out.print("Enter the cost time:  ");
        double studentTime = input.nextDouble();

        Item temp = new Item(studentName, studentTime);
        boolean isAdded =store.add(temp);
        if (isAdded){
            System.out.println("Yoke Added Successfully");
        }
        else{
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
        }
        else{
            System.out.println("There are no Records with the name [" + recordName + "] in the System.");
        }
    }
}