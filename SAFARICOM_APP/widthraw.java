package SAFARICOM_APP;

import java.util.Scanner;

public class widthraw {

    Scanner prompt_user = new Scanner(System.in);
    getBalance ACCOUNT = new getBalance();


    public  void WIDTHRAW(String[] USER_INFO, String[] AGENT_INFO) {
        
        System.out.print("Enter agent number: ");
        String agent_number = prompt_user.nextLine();

        System.out.println(); 

        System.out.print("Enter store number: ");
        String store_number = prompt_user.nextLine();


        System.out.print("Enter amount to withdraw: ");
        String withdraw = prompt_user.nextLine();
        double AMOUNT = Double.parseDouble(withdraw);
        double amount = AMOUNT;

        System.out.print("Enter pin: ");
        String user_password = prompt_user.nextLine();


        if (amount > 50 && amount <= ACCOUNT.GET_BALANCE() && agent_number.equals(USER_INFO[2]) && store_number.equals(AGENT_INFO[1]) && user_password.equals(USER_INFO[1])) {

            ACCOUNT.balance -= amount;
            System.out.println("Withdrawal of Sh." + amount + " from " + USER_INFO[3] + " was successful, your remaining M-pesa balance is Sh." + ACCOUNT.GET_BALANCE() + ". The maximum amount you can transact during the day is 399,999.0.");
        } 
        else if (amount > ACCOUNT.GET_BALANCE()) {
            System.out.println("You have insufficient funds to withdraw Sh." + amount + ", your M-pesa balance is " + ACCOUNT.GET_BALANCE() + ".");
        }
        else if (amount < 50.0) {
            System.out.println("Minimum amount to withdraw is Sh.50.0. Please try a higher amount");
        }

        else if (user_password != USER_INFO[1]) {
            System.out.println("Invalid password. You have 2 remaining trials to input correct password. Inputing more than three times you will be blocked.");
        }
        else {
            System.out.println("Withdrawal amount must be positive.");
        }

        prompt_user.close();
    }
    
}
