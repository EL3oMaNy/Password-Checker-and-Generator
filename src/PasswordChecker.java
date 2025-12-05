import java.util.Scanner;

public class PasswordChecker {

  

    public static int countUppercase(String password) {
        return password.length() - password.replaceAll("[A-Z]", "").length();
    }

    public static int countLowercase(String password) {
        return password.length() - password.replaceAll("[a-z]", "").length();
    }

    public static int countNumbers(String password) {
        return password.length() - password.replaceAll("[0-9]", "").length();
    }

    public static int countSymbols(String password) {
        return password.length() - password.replaceAll("[A-Za-z0-9]", "").length();
    }

    public static int checkPasswordStrength(String password) {
        int score = 0;

        if (password.length() >= 8) score+= 2;
        if (countUppercase(password) > 0) score+= 2;
        if (countLowercase(password) > 0) score+= 2;
        if (countNumbers(password) > 0) score+= 2;
        if (countSymbols(password) > 0) score+= 2;

        return score; 
    }

  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        
        System.out.print("Enter password: ");
        String password = in.nextLine();
        System.out.println("PasswordStrength: " + checkPasswordStrength(password));

        in.close();
    }
}
