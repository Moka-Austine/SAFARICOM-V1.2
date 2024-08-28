import java.util.Scanner;

public class deposit {
    Scanner prompt_user = new Scanner(System.in);
    static getBalance ACCOUNT = new getBalance();
    double amount;

    public void DEPOSIT(String[] USER_INFO, String[] AGENT_INFO) {

        System.out.print("Enter mobile number: ");
        String mobile_number = prompt_user.nextLine();

        System.out.print("Enter id number: ");
        String id_number = prompt_user.nextLine();


        System.out.print("Enter amount to deposit: ");
        String deposit = prompt_user.nextLine();
        amount = Double.parseDouble(deposit);
        


        System.out.print("Enter pin: ");
        String agent_password = prompt_user.nextLine();

        
        if (amount > 0 && amount < 399_999 && agent_password.equals(AGENT_INFO[0]) && id_number.equals(USER_INFO[3]) && mobile_number.equals(USER_INFO[2])) {

            if(amount < 50) {
                System.out.print("Amount must be Sh.50 and above, please try higher amount.");
            }
            else {
                System.out.println("Please confirm deposit of Sh." + amount + " to " + USER_INFO[0] + ", type 1 to confirm or any other key to decline:");
                String agent_confirm_answer = prompt_user.nextLine();
                String yes_answer = "1";

                if (agent_confirm_answer.equals(yes_answer)) {
                    ACCOUNT.balance += amount;
                    System.out.println("Deposit of Sh." + amount + " successful. New M-pesa balance is Sh." + ACCOUNT.balance + ". The amount you can transact within the day is 499,999.00.");
                }
                else {
                    System.out.print("Dear customer, you have cancelled deposit of " + amount + " to " + USER_INFO[0] + ". Cancelling too many transactions will make you unable to confirm other users names for a while.");
                }
            }
            
        } 
        else if (amount > 399_999) {
            System.out.println("Amount is too high to deposit.Please try a lower amount.");

        }
        else if (agent_password != AGENT_INFO[0]) {
            System.out.println("Invalid password. You have 2 remaining trials to input correct password. Inputing more than three times you will be blocked.");
        }
        else {
            System.out.println("Invalid credentials, please input properly.");
        }
        
    }


}