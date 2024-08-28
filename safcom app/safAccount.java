import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class safAccount {

    public static double balance;

    //? USER INFORMATION
    public static String userInfor[];
    
    //? AGENT INFORMATION
    public static String agentInfor[];
    
    static Scanner prompt_user = new Scanner(System.in);
    
    public safAccount() {
        this.balance = 0.0;

        // 0 => USER_NAME, 1 => USER_PASSWORD, 2 => MOBILE_NUMBER, 3 => Id_NUMBER
        this.userInfor = new String[] { "Justine Muthuri", "1234", "0123456789", "12345678" };

        // 0 => AGENT_PASSWORD, 1 => STORE_NUMBER, 2 => AGENT_NUMBER, 3 => AGENT_NAME
        this.agentInfor = new String[] { "1111", "12345", "54321", "tuko pamoja" };

    }
    
    // METHOD FOR BALANCE ENQUIRIES==============================================================================================
    public static double getBalance() {
        return balance;
    }

     //? CHECKING IF AMOUNT INPUT IS A NUMBER ====================================================
   
     public static boolean isNotNumber(String input) {
        try {
            Double.parseDouble(input); // Try parsing the input as a double
            return true; // Input is a valid number
        } catch (NumberFormatException e) {
            return false; // Input is not a number
        }
       }
     //? CHECKING IF PASSWORD LENGTH IS EQUAL TO FOUR AND VALID NUM ====================================================
    String password_length(String input){

        boolean num = isNotNumber(input);

        if (num == true) {
          if(input.length() == 4) {
            String value = "valid 4 digits";
            return value;
          } 
          else if(input.length() < 4) {
            String value = "less than 4 digits";
            return value;
          } 
          else {
            String value = "more than 4 digits";
            return value;
          }
        }
        else{
          String not_num = "not a valid number";
          return not_num;
        }
    }


    // if user chooses option 1, 2, 3 of shuffled numbers
    static void shuffled_option_num(String zero_seven_or_one, String option) {

        safAccount updateUserInfo = new safAccount();
        //System.out.println();

        System.out.print("Are you sure to choose " + zero_seven_or_one + option + " ? (Yes / No) OR (y/n)" );

        String shuffled_mobile_num1_ans = prompt_user.nextLine().toLowerCase();

        String zero_seven = zero_seven_or_one + option;

        if (shuffled_mobile_num1_ans.equals("yes") || shuffled_mobile_num1_ans.equals("y")) {

         System.out.print("Please enter your username: " );
         String user_account_name = prompt_user.nextLine();

         System.out.print("Please enter your ID number: " );
         String user_id_num = prompt_user.nextLine();

         System.out.print("Please enter a 4 digit pin account pin to use the mobile number: " );
         String user_mobile_num_pin = prompt_user.nextLine();
         

         System.out.print("Please re-enter your pin again to confirm sighning up to your Safaricom account: ");
         String user_mobile_num_pin_confirm = prompt_user.nextLine();

         if (user_mobile_num_pin_confirm.equals(user_mobile_num_pin)) {
             
             //updating user info
             updateUserInfo.updateUserInfo(user_account_name, user_mobile_num_pin, zero_seven, user_id_num);
             
             // safaricom services
             infinite_while_loop();
             
         }  
         else {
             System.out.print("Wrong pin, 2 times remaining. Please reenter again: ");
             String ans = prompt_user.nextLine();
             if (ans.equals(user_mobile_num_pin)) {
                infinite_while_loop();
             }
            else{
                System.out.print("Wrong pin, 1 times remaining. Please reenter again: ");
                String ans2 = prompt_user.nextLine();
                if (ans2.equals(user_mobile_num_pin)) {
                    infinite_while_loop();
                 }
                 else{
                    System.out.print("You have reentered wrong pin 3 times, your account has been blocked from any access. Please carry your ID card and visit our Safaricom headquaters near you to assist you unlock your account.");
                    
                }
            }
         }

        }
        else if (shuffled_mobile_num1_ans.equals("no") || shuffled_mobile_num1_ans.equals("n")) {
         //no answer an ask if to shuffle or choose option 2 & 3 or cancel
         //also add options for y/n just not only yes/no  
        }
        else{
         System.out.println("Invalid choice, please try again: ");
        }

    }//======================================================================

    //to be used in shuffling_mobile_numbers method ============================ 
    static String user_answer, shuffled_mobile_num1, shuffled_mobile_num2, shuffled_mobile_num3;
    //static int shuffled_mobile_num1, shuffled_mobile_num2, shuffled_mobile_num3;
    // method for shuffling mobile numbers ====================================
    private static String shuffling_mobile_numbers (String shuffledNum1, String shuffledNum2, String shuffledNum3 ) {
        
        shuffled_mobile_num1 = shuffledNum1;
        shuffled_mobile_num2 = shuffledNum2;
        shuffled_mobile_num3 = shuffledNum3;

        System.out.println("Please choose the mobile Number you prefer;\n 1." + "07" + shuffled_mobile_num1 + "\n 2." + "01" + shuffled_mobile_num2 + "\n 3." + "07" + shuffled_mobile_num3);
        System.out.print("Enter your option (1, 2, 3) to choose number or enter anything else to shuffle the numbers: ");

        user_answer = prompt_user.nextLine();
        return user_answer;
        
    }//===============================================================================

    // method for shuffling numbers(num variable) for mobile numbers ======================================================
    public static String shuffling_numbers() {
        // Original number
        int num = 12345678;

        // Convert number to a string
        String numStr = Integer.toString(num);

        // Convert string to a list of characters
        List<Character> digits = new ArrayList<>();
        for (char c : numStr.toCharArray()) {
            digits.add(c);
        }

        // Shuffle the list of characters
        Collections.shuffle(digits);

        // Convert list back to string
        StringBuilder shuffledStr = new StringBuilder();
        for (char c : digits) {
            shuffledStr.append(c);
        }

        // Convert shuffled string back to integer
        int shuffledNum = Integer.parseInt(shuffledStr.toString());
        String shuffledNum_str = String.valueOf(shuffledNum);
        return shuffledNum_str;

    }//=====================================================================

    // =======infinite while loop for asking user to enter option for saf service=============================
    private static void infinite_while_loop () {

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
                  deposit();
                  break;
               case 2:
                  withdraw();
                  break;
               case 3:
                  System.out.println("Your M-pesa account balance is Sh." + getBalance() + ".");
                  break;
               case 4:
                  System.out.println("Thank you for using M-pesa services.");
                  prompt_user.close();
                  System.exit(0);
               default:
                  System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }
        } 
    }//=============================================================================

    // Method for updating user information
    public String[] updateUserInfo(String userName, String userPin, String mobileNumber, String idNumber) {
        userInfor[0] = userName;
        userInfor[1] = userPin;
        userInfor[2] = mobileNumber;
        userInfor[3] = idNumber;

        return userInfor;
    }
    // check if user data is updated
    public String[] check_if_new_user(String userName, String userPin, String mobileNumber, String idNumber) {

        String updated_data[] = updateUserInfo(userName, userPin, mobileNumber, idNumber);
        return updated_data;
        
    
    };

    // METHOD FOR DIPOSITING TO ACCOUNT========================================================================================
    public static void deposit() {

        System.out.print("Enter mobile number: ");
        String mobile_number = prompt_user.nextLine();
        
        System.out.println(); 

        System.out.print("\nEnter id number: ");
        String id_number = prompt_user.nextLine();


        System.out.print("Enter amount to deposit: ");
        String deposit = prompt_user.nextLine();
        double AMOUNT = Double.parseDouble(deposit);
        double amount = AMOUNT;


        System.out.print("Enter pin: ");
        String agent_password = prompt_user.nextLine();

        
        if (amount > 0 && amount < 399_999 && agent_password.equals(safAccount.agentInfor[0]) && id_number.equals(userInfor[3]) && mobile_number.equals(safAccount.userInfor[2])) {

            if(amount < 50) {
                System.out.print("Amount must be Sh.50 and above, please try higher amount.");
            }
            else {
                System.out.println("Please confirm deposit of Sh." + amount + " to " + userInfor[0] + ", type 1 to confirm or any other key to decline:");
                String agent_confirm_answer = prompt_user.nextLine();
                String yes_answer = "1";

                if (agent_confirm_answer.equals(yes_answer)) {
                    balance += amount;
                    System.out.println("Deposit of Sh." + amount + " successful. New M-pesa balance is Sh." + balance + ". The amount you can transact within the day is 499,999.00.");
                }
                else {
                    System.out.print("Dear customer, you have cancelled deposit of " + amount + " to " + safAccount.userInfor[0] + ". Cancelling too many transactions will make you unable to confirm other users names for a while.");
                }
            }
            
        } 
        else if (amount > 399_999) {
            System.out.println("Amount is too high to deposit.Please try a lower amount.");

        }
        else if (agent_password != safAccount.agentInfor[0]) {
            System.out.println("Invalid password. You have 2 remaining trials to input correct password. Inputing more than three times you will be blocked.");
        }
        else {
            System.out.println("Invalid credentials, please input properly.");
        }
        
    }

    // METHOD FOR WITHDRAWING FROM ACCOUNT====================================================================================
    public static void withdraw() {
        
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


        if (amount > 50 && amount <= balance && agent_number.equals(safAccount.agentInfor[2]) && store_number.equals(safAccount.agentInfor[1]) && user_password.equals(safAccount.userInfor[1])) {

            balance -= amount;
            System.out.println("Withdrawal of Sh." + amount + " from " + safAccount.agentInfor[3] + " was successful, your remaining M-pesa balance is Sh." + balance + ". The maximum amount you can transact during the day is 399,999.0.");
        } 
        else if (amount > balance) {
            System.out.println("You have insufficient funds to withdraw Sh." + amount + ", your M-pesa balance is " + balance + ".");
        }
        else if (amount < 50.0) {
            System.out.println("Minimum amount to withdraw is Sh.50.0. Please try a higher amount");
        }

        else if (user_password != safAccount.userInfor[1]) {
            System.out.println("Invalid password. You have 2 remaining trials to input correct password. Inputing more than three times you will be blocked.");
        }
        else {
            System.out.println("Withdrawal amount must be positive.");
        }
        
    }

    // MAIN METHOD OF PROGRAM====================================================================================================
    public static void main(String[] args) {

        safAccount account = new safAccount();

        //String userInfor[] = { "Justine Muthuri", "1234", "0123456789", "12345678" };
        String[] user_info = safAccount.userInfor;

        
        Scanner prompt_user = new Scanner(System.in);
        
        //?===determining if user has account=======
        System.out.print("Do you have a Safaricom account? (Yes/No) OR (y/n)");
        String userAnswer = prompt_user.nextLine().toLowerCase();

        //if user has an account
         if (userAnswer.equals("yes") || userAnswer.equals("y")) {
             System.out.println("\nEnter your username: ");
             String userLoginUserName = prompt_user.nextLine();

             System.out.print("Enter your password: ");
             String userLoginPassword = prompt_user.nextLine();

             if (userLoginPassword.equals(user_info[1])) {
                 System.out.println("\nWelcome back " + userLoginUserName + ". Thank you for choosing Safaricom again.");
                 infinite_while_loop();

              }
         }


        //? if user don't have an account=========================================================
        else if (userAnswer.equals("no") || userAnswer.equals("n")){
          
            System.out.print("Do you want to open a Safaricom account? (Yes/No) OR (y/n)");
            String user_answer = prompt_user.nextLine().toLowerCase();

            if (user_answer.equals("yes") || user_answer.equals("y")) {

                String user_answer_after_choosing = shuffling_mobile_numbers(shuffling_numbers(), shuffling_numbers(), shuffling_numbers());
                  
                String zero_seven = "07";
                String zero_one = "01";
                if(user_answer_after_choosing.equals("1")) {
                    shuffled_option_num(zero_seven, shuffled_mobile_num1);
                }

                else if(user_answer_after_choosing.equals("2")) {
                    shuffled_option_num(zero_one, shuffled_mobile_num2);
                }

                else if(user_answer_after_choosing.equals("3")) {
                    shuffled_option_num(zero_seven, shuffled_mobile_num3);
                }

                else  {
                    // keep on shuffling untill satisfied
                    // also have a cancel option if not satisfied
                }

                
            }
            else if (user_answer.equals("no")) {
                System.out.println("We hope to serve you in the future.");
                
                
            }

        }
        else {
            System.out.println("Do you want to cancell subsciption? (Yes/No) OR (y/n)");
            String subscription_confirm_answer = prompt_user.nextLine().toLowerCase();

            if (subscription_confirm_answer.equals("yes") || subscription_confirm_answer.equals("y")) {
                System.out.println("Thank you for interacting with our application, we hope to serve you in the future 😎.");
            }

            else {

            }
        }
        prompt_user.close();
        
    }
}
