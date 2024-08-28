package SAFARICOM_APP;

import java.util.Scanner;

public class App {

    //String userInfor[] = { "Justine Muthuri", "1234", "0123456789", "12345678" };
    static Scanner prompt_user = new Scanner(System.in);
    static infinite_while_loop INFINITE_WHILE_LOOP = new infinite_while_loop();
    static personal_info PERSONAL_INFO = new personal_info();


    
    public static void main(String[] args) {

        //?===determining if user has account=======
        System.out.print("Do you have a Safaricom account? (Yes/No) OR (y/n)");
        String userAnswer = prompt_user.nextLine().toLowerCase();

        //if user has an account
         if (userAnswer.equals("yes") || userAnswer.equals("y")) {
             System.out.println("\nEnter your username: ");
             String userLoginUserName = prompt_user.nextLine();

             System.out.print("Enter your password: ");
             String userLoginPassword = prompt_user.nextLine();

             if (userLoginPassword.equals(PERSONAL_INFO.userInfor[1])) {
                 System.out.println("\nWelcome back " + userLoginUserName + ". Thank you for choosing Safaricom again.");
                 INFINITE_WHILE_LOOP.INFINITE_WHILE_LOOP(PERSONAL_INFO.userInfor, PERSONAL_INFO.agentInfor);

              }
         }


        //? if user don't have an account=========================================================
        else if (userAnswer.equals("no") || userAnswer.equals("n")){
          
            System.out.print("Do you want to open a Safaricom account? (Yes/No) OR (y/n)");
            String user_answer = prompt_user.nextLine().toLowerCase();

            if (user_answer.equals("yes") || user_answer.equals("y")) {

                String user_answer_after_choosing = shuffling.shuffling_mobile_numbers(shuffling.shuffling_numbers(), shuffling.shuffling_numbers(), shuffling.shuffling_numbers());
                  
                String zero_seven = "07";
                String zero_one = "01";
                if(user_answer_after_choosing.equals("1")) {
                    shuffling.shuffled_option_num(zero_seven, shuffling.shuffled_mobile_num1);
                }

                else if(user_answer_after_choosing.equals("2")) {
                    shuffling.shuffled_option_num(zero_one, shuffling.shuffled_mobile_num2);
                }

                else if(user_answer_after_choosing.equals("3")) {
                    shuffling.shuffled_option_num(zero_seven, shuffling.shuffled_mobile_num3);
                }

                else  {
                    // keep on shuffling untill satisfied
                    // also have a cancel option if not satisfied
                }

                
            }
            else if (user_answer.equals("no") || user_answer.equals("n")) {
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
