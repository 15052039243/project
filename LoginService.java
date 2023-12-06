import java.util.Scanner;
public class LoginService {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String password;
        do {
            System.out.println("Please enter your password");
            password = sc.nextLine();
        }
        while(!"000000".equals(password));
        System.out.println("Login successfully");
        sc.close();
    }
}
