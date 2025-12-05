import java.util.*;;
public class App {
    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        Scanner in = new Scanner(System.in);
        PasswordGenerator generator = new PasswordGenerator();

        while (true) {
            System.out.println("\n=== Password Tool Menu ===");
            System.out.println("1. Check Password Strength");
            System.out.println("2. Generate Strong Password");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            int choice = in.nextInt();
            in.nextLine(); // clear buffer

            if (choice == 1) {
                System.out.print("Enter password: ");
                String password = in.nextLine();
                int score = PasswordChecker.checkPasswordStrength(password);
                System.out.println("Password Strength Score: " + score);

            } else if (choice == 2) {
                System.out.print("Enter password length (>=8): ");
                int length = in.nextInt();

                try {
                    String newPass = generator.generate(length);
                    System.out.println("Generated Password: " + newPass);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }

            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;

            } else {
                System.out.println("Invalid choice!");
            }
        }
        in.close();

    }
}
