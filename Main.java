import java.util.Scanner;

public class Driver {

    private Scanner input = new Scanner(System.in);
    private Shop shop;

    public static void main(String[] args) {
        System.out.println("Yoke Project V 1.0");

        Driver driver = new Driver();
        driver.setup();
        driver.runMenu();

    }

    ///////////////////////////////////////////////////////
    private int mainMenu(){
        System.out.print("""
               Yoke Shop Menu
               ---------
                  1) Add a Yoke
                  2) List All Yokes
                  3) Find a Yoke
                  0) Exit
               ==>> """);
        int option = input.nextInt();
        return option;
    }
    ///////////////////////////////////////////////////////
    private void runMenu(){
        int option = mainMenu();

        while (option != 0){

            switch (option){
                case 1 -> addAYoke();
                case 2 -> printAllYokes();
                case 3 -> findAYoke();
                default -> System.out.println("Invalid option entered: " + option);
            }

            //pause the program so that the user can read what we just printed to the terminal window
            System.out.println("\nPress enter key to continue...");
            input.nextLine();
            input.nextLine(); //second read is required - bug in Scanner class; a String read is ignored straight after reading an int.

            //display the main menu again
            option = mainMenu();
        }

        //the user chose option 0, so exit the program
        System.out.println("Exiting...bye bye");
        System.exit(0);
    }

    private void findAYoke() {
        input.nextLine();

        System.out.print("Please Enter a Yoke Name to Find : ");
        String yokeName = input.nextLine();

        Yoke foundYoke = shop.find(yokeName);

        if (foundYoke != null) {
            System.out.println("The found Thing is:  " + foundYoke);
        }
        else{
            System.out.println("There are no Things with the name [" + yokeName + "] in the Shop.");
        }
    }


    private void addAYoke(){
        input.nextLine();  //dummy read of String to clear the buffer - bug in Scanner class.

        System.out.print("Enter the Yoke Name:  ");
        String yokeName = input.nextLine();
        System.out.print("Enter the Price:  ");
        double yokePrice = input.nextDouble();

        Yoke temp = new Yoke(yokeName, yokePrice);
        boolean isAdded = shop.add(temp);
        if (isAdded){
            System.out.println("Yoke Added Successfully");
        }
        else{
            System.out.println("No Yoke Added");
        }
    }

    private void printAllYokes() {
        System.out.println("List of Yokes are:");
        System.out.println(shop.list());
    }

    private void setup(){
        //find out from the user how many products they would like to order
        System.out.print("How many Yokes would you like to have in your Store?  ");
        int numberProducts = input.nextInt();
        shop = new Shop(numberProducts);
    }
///////////////////////////////////////////////////////

}
