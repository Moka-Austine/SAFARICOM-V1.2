package SAFARICOM_APP;
public class getMobileNum {

    static personal_info PERSONAL_INFO = new personal_info();

    // getting user number
    String getNumber () {
        String num = PERSONAL_INFO.userInfor[2];
        return num;
    }  

}
