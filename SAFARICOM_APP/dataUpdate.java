package SAFARICOM_APP;

public class dataUpdate {
    
    static personal_info PERSONAL_INFO = new personal_info();
    // Method for updating user information
     public String[] updateUserInfo(String userName, String userPin, String mobileNumber, String idNumber) {
        PERSONAL_INFO.userInfor[0] = userName;
        PERSONAL_INFO.userInfor[1] = userPin;
        PERSONAL_INFO.userInfor[2] = mobileNumber;
        PERSONAL_INFO.userInfor[3] = idNumber;

        return PERSONAL_INFO.userInfor;
    }
    // check if user data is updated
    public String[] check_if_new_user(String userName, String userPin, String mobileNumber, String idNumber) {

        String updated_data[] = updateUserInfo(userName, userPin, mobileNumber, idNumber);
        return updated_data;
        
    
    };
}
