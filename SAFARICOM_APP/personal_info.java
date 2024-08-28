package SAFARICOM_APP;

public class personal_info {
   
    //? USER INFORMATION
    public static String userInfor[];
    
    //? AGENT INFORMATION
    public static String agentInfor[];
    
    public personal_info() {
        // 0 => USER_NAME, 1 => USER_PASSWORD, 2 => MOBILE_NUMBER, 3 => Id_NUMBER
        this.userInfor = new String[] { "Justine Muthuri", "1234", "0123456789", "12345678" };

        // 0 => AGENT_PASSWORD, 1 => STORE_NUMBER, 2 => AGENT_NUMBER, 3 => AGENT_NAME
        this.agentInfor = new String[] { "1111", "12345", "54321", "tuko pamoja" };

    }
    
}
