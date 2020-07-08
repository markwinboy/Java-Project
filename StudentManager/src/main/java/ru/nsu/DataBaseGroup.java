package ru.nsu;
import java.sql.*;

public class DataBaseGroup {
    private String url ;
    private String login ;
    private String password ;

    public DataBaseGroup(String url, String login, String password) {
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public void unloading(String group){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,login,password);
            try{
                Statement stmt = con.createStatement();

                String request =  "INSERT INTO `Group`(`groupName`) VALUES ('"
                        + group + "')";
                stmt.execute(request);
                stmt.close();
            } finally {
                con.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean groupCheck(String group) {
        boolean result = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                ResultSet request = stmt.executeQuery("SELECT * FROM `Group` WHERE `groupName` = '" + group + "'");;
                result = request.first();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
