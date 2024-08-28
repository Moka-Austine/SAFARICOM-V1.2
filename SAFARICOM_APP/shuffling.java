package SAFARICOM_APP;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class shuffling {
     
     static personal_info PERSONAL_INFO = new personal_info(); 

     static Scanner prompt_user = new Scanner(System.in);

     static infinite_while_loop INFINITE_WHILE_LOOP = new infinite_while_loop();

     static dataUpdate DATA_UPDATE = new dataUpdate();

     static String user_answer, shuffled_mobile_num1, shuffled_mobile_num2, shuffled_mobile_num3;

     // if user chooses option 1, 2, 3 of shuffled numbers
     static void shuffled_option_num(String zero_seven_or_one, String option) {

        //safAccount updateUserInfo = new safAccount();
        //System.out.println();

        System.out.print("Are you sure to choose " + zero_seven_or_one + option + " ? (Yes / No) OR (y/n)" );

        String shuffled_mobile_num1_ans = prompt_user.nextLine().toLowerCase();

        String zero_seven_1 = zero_seven_or_one + option;

        if (shuffled_mobile_num1_ans.equals("yes") || shuffled_mobile_num1_ans.equals("y")) {

         System.out.print("Please enter your username: " );
         String user_account_name = prompt_user.nextLine();

         System.out.print("Please enter your ID number: " );
         String user_id_num = prompt_user.nextLine();

         System.out.print("Please enter a 4 digit pin account pin to use the mobile number: " );
         String user_mobile_num_pin = prompt_user.nextLine();
         

         System.out.print("Please re-enter your pin again to confirm sighning up to your Safaricom account: ");
         String user_mobile_num_pin_confirm = prompt_user.nextLine();
         
         //updating user info
         String[] data_updates = DATA_UPDATE.updateUserInfo(user_account_name, user_mobile_num_pin, zero_seven_1, user_id_num);

         if (user_mobile_num_pin_confirm.equals(user_mobile_num_pin)) {
             
             // safaricom services
             INFINITE_WHILE_LOOP.INFINITE_WHILE_LOOP(data_updates, PERSONAL_INFO.agentInfor);
             
         }  
         else {
             System.out.print("Wrong pin, 2 times remaining. Please reenter again: ");
             String ans = prompt_user.nextLine();
             if (ans.equals(user_mobile_num_pin)) {
                INFINITE_WHILE_LOOP.INFINITE_WHILE_LOOP(data_updates, PERSONAL_INFO.agentInfor);
             }
            else{
                System.out.print("Wrong pin, 1 times remaining. Please reenter again: ");
                String ans2 = prompt_user.nextLine();
                if (ans2.equals(user_mobile_num_pin)) {
                    INFINITE_WHILE_LOOP.INFINITE_WHILE_LOOP(data_updates, PERSONAL_INFO.agentInfor);
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
         
         System.out.print("Do you want to choose option 2, 3 or cancel account? ( 2, 3 ) or c to cancel: ");
         String ans = prompt_user.nextLine();

         if (ans.equals("2")) {
            //implement second option
            System.out.print("Are you sure to choose " + zero_seven_or_one + option + " ? (Yes / No) OR (y/n)" );
         }
         else if (ans.equals("3")) {
            //implement third option
         }
         else {
            //implement cancel account option
         }
        }

        else{
         System.out.println("Invalid choice, please try again: ");
        }

    }
     
     static String shuffling_mobile_numbers (String shuffledNum1, String shuffledNum2, String shuffledNum3 ) {
         
         shuffled_mobile_num1 = shuffledNum1;
         shuffled_mobile_num2 = shuffledNum2;
         shuffled_mobile_num3 = shuffledNum3;
 
         System.out.println("Please choose the mobile Number you prefer;\n 1." + "07" + shuffled_mobile_num1 + "\n 2." + "01" + shuffled_mobile_num2 + "\n 3." + "07" + shuffled_mobile_num3);
         System.out.print("Enter your option (1, 2, 3) to choose number or enter anything else to shuffle the numbers: ");
 
         user_answer = prompt_user.nextLine();
         return user_answer;
         
     }
 
    
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
 
     }


     
}

    