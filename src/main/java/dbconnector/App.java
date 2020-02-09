package dbconnector;


import dbconnector.models.Account;
import dbconnector.models.Model;

public class App {
    public static void main(String[] args) {
        Model model = new Account();
        Account account = new Account();
        String table = "table";
        int id = 0;
        String sql = String.format("delete from %s where id = %d;", table,id);
        System.out.println(sql);

    }
}