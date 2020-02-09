package dbconnector;

import dbconnector.models.Account;
import dbconnector.models.Model;
import dbconnector.models.Profile;
import dbconnector.utils.DBUtil;

public class AppRunner {
    private static final String ACCOUNTS = "dev_profiles_db.public.accounts";
    private static final String PROFILES = "dev_profiles_db.public.profiles";

    private static DBUtil dbUtil = new DBUtil();

    public void showResults() {
        Model tor = new Account(1001, "Tor", "Odinson", "Kyiv",
                "Male", "dave45");
        Model torProfile = new Profile(1001, "thunder15", "Thunder Thrower",
                "Forces of Nature", " Ásgarðr", "God");


        dbUtil.create(ACCOUNTS, tor);
        dbUtil.create(PROFILES, torProfile);

        dbUtil.update(ACCOUNTS, "username", "dave45", "thunder", 1001);
        dbUtil.update(PROFILES, "username", "thunder15", "thunder", 1001);

//        dbUtil.delete(ACCOUNTS, 1001);
//        dbUtil.delete(PROFILES, 1001);

//        print(ACCOUNTS);
        print(PROFILES);
    }

    private void print(String table) {
        for (Model model : dbUtil.read(table)) {
            System.out.println(model);
        }
    }
}