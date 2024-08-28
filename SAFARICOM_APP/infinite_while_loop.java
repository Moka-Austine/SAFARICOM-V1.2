package SAFARICOM_APP;

import java.util.Scanner;


public class infinite_while_loop {

    static deposit DEPOSIT = new deposit();
    static widthraw WIDTHRAW = new widthraw();
    static getBalance GET_BALANCE= new getBalance();

    static Scanner prompt_user = new Scanner(System.in);

    

    public static void INFINITE_WHILE_LOOP (String[] USER_INFO, String[] AGENT_INFO) {

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = prompt_user.nextInt();
            
            switch (choice) {
               case 1:
               DEPOSIT.DEPOSIT(USER_INFO, AGENT_INFO);
                  break;
               case 2:
               WIDTHRAW.WIDTHRAW(USER_INFO, AGENT_INFO);
                  break;
               case 3:
                  System.out.println("Your M-pesa account balance is Sh." + GET_BALANCE.balance + ".");
                  break;
               case 4:
                  System.out.println("Thank you for using M-pesa services.");
                  prompt_user.close();
                  System.exit(0);
               default:
                  System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }
        } 
    }

   
}
