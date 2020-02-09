package dbconnector;

import dbconnector.models.Account;
import dbconnector.utils.DBUtil;

public class App {
    public static void main(String[] args) {
        Account account = new Account();
        account.setId(1001);
        account.setFirs_name("Tor");
        account.setLast_name("Odinson");
        account.setCity("Kyiv");
        account.setGender("Male");
        account.setUsername("dave45");
        DBUtil dbUtil = new DBUtil();
        dbUtil.create("dev_profiles_db.public.accounts", account);
    }
}