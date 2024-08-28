package SAFARICOM_APP;

public class validNumber {
    
     //? CHECKING IF AMOUNT INPUT IS A NUMBER ====================================================
   
     public boolean isNotNumber(String input) {
        try {
            Double.parseDouble(input); // Try parsing the input as a double
            return true; // Input is a valid number
        } catch (NumberFormatException e) {
            return false; // Input is not a number
        }
       }
     //? CHECKING IF PASSWORD LENGTH IS EQUAL TO FOUR AND VALID NUM ====================================================
      public String password_length(String input){

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

}
