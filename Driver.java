import java.util.Scanner;

public class Driver {

    private Scanner input = new Scanner(System.in);
    private Shop shop;

    public static void main(String[] args) {
        System.out.println("Student Project V 1.0");

        Driver driver = new Driver();
        driver.setup();
        driver.runMenu();

    }

    ///////////////////////////////////////////////////////
    private int mainMenu(){
        System.out.print("""
               Student Shop Menu
               ---------
                  1) Add a Student
                  2) List All Students
                  3) Find a Students
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
                case 1 -> addAStudent();
                case 2 -> printAllStudents();
                case 3 -> findAStudent();
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

    private void findAStudent() {
        input.nextLine();

        System.out.print("Please Enter a Student Name to Find : ");
        String studentName = input.nextLine();

        Student foundStudent = shop.find(studentName);

        if (foundStudent != null) {
            System.out.println("The found Thing is:  " + foundStudent);
        }
        else{
            System.out.println("There are no Things with the name [" + studentName + "] in the Shop.");
        }
    }


    private void addAStudent(){
        input.nextLine();  //dummy read of String to clear the buffer - bug in Scanner class.

        System.out.print("Enter the Student Name:  ");
        String studentName = input.nextLine();
        System.out.print("Enter the Price:  ");
        double studentPrice = input.nextDouble();

        Student temp = new Student(studentName, studentPrice);
        boolean isAdded = shop.add(temp);
        if (isAdded){
            System.out.println("Student Added Successfully");
        }
        else{
            System.out.println("No Student Added");
        }
    }

    private void printAllStudents() {
        System.out.println("List of Students are:");
        System.out.println(shop.list());
    }

    private void setup(){
        //find out from the user how many products they would like to order
        System.out.print("How many Students would you like to have in your Store?  ");
        int numberProducts = input.nextInt();
        shop = new Shop(numberProducts);
    }
///////////////////////////////////////////////////////

}