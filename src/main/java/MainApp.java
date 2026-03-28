import service.BankService;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankService service = new BankService();

        while (true) {
            System.out.println("\n--- BANK MENU ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.println("Enter : ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter account no: ");
                    int acc = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter pin no: ");
                    int pin = Integer.parseInt(sc.nextLine());
                    service.createAccount(acc, name, pin);
                    break;
                case 2:
                    System.out.print("Enter account no: ");
                    int acc2 = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter amount: ");
                    double amt = Double.parseDouble(sc.nextLine());
                    System.out.print("Enter pin no: ");
                    int pin2 = Integer.parseInt(sc.nextLine());
                    service.deposit(acc2, amt, pin2);
                    break;
                case 3:
                    System.out.print("Enter account no: ");
                    int acc3 = Integer.parseInt(sc.nextLine());
                    if (service.check(acc3)) {
                    	break;
                    }
                    System.out.print("Enter amount: ");
                    double amt2 = Double.parseDouble(sc.nextLine());
                    System.out.print("Enter pin no: ");
                    int pin3 = Integer.parseInt(sc.nextLine());
                    service.withdraw(acc3, amt2, pin3);
                    break;
                case 4:
                    System.out.print("Enter account no: ");
                    int acc4 = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter pin no: ");
                    int pin4 = Integer.parseInt(sc.nextLine());
                    service.checkBalance(acc4, pin4);
                    break;
                case 5:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}