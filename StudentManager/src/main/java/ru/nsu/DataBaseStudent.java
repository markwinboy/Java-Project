package ru.nsu;

import java.sql.*;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

public class DataBaseStudent {

    private String url = "jdbc:mysql://remotemysql.com:3306/8ljJofQNya";
    private String login = "8ljJofQNya";
    private String password = "uUuS8PpNfM";

    public void unloading(StudentArguments[] studentList, String group) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT `id` FROM `Group` WHERE `groupName` = '" + group + "'");
                int id;
                rs.next();
                id = rs.getInt(1);
                for (StudentArguments student : studentList) {
                    if(!studentCheck(student.getFirstName(),student.getSecondName())){
                        String request = "INSERT INTO `Student`( `groupId`, `firstName`, `secondName`, `lastName`, `birthdayDate`) VALUES("
                                + id
                                + ",'" + student.getFirstName()
                                + "','" + student.getSecondName()
                                + "','" + student.getLastName()
                                + "','" + student.getBirhdayDate() + "')";
                        stmt.execute(request);
                    }
                }


                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void downloading() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                ResultSet request = stmt.executeQuery("SELECT * FROM `Group`");
                while (request.next()) {
                    Statement stmt1 = con.createStatement();
                    System.out.println(request.getString("groupName"));
                    ResultSet rs = stmt1.executeQuery("SELECT * FROM `Student` WHERE `groupId`="+request.getInt(1));
                    while (rs.next()) {
                        StudentArguments student = new StudentArguments(rs.getString("firstName"), rs.getString("secondName"),
                                rs.getString("lastName"), rs.getString("birthdayDate"));
                        System.out.println(student.getFirstName()+" "+student.getSecondName()+" "
                                +student.getLastName()+" "+student.getBirhdayDate()+" ");
                    }
                    rs.close();
                }
                request.close();
                stmt.close();
            }  finally{
                con.close();
                }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean studentCheck(String firstName,String secondName) {
        boolean result = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                ResultSet request = stmt.executeQuery("SELECT * FROM `Student` WHERE `firstName` = '" + firstName + "' AND `secondName`='"+secondName+"'");;
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