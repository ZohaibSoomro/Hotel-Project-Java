/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotelproject.helper;

import com.hotelproject.dao.Connect;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author abdul
 */
public class User {

    private String userName;
    private String userID;
    private int userPhoneNo;
    private String userEmail;
    private String password;

    public User() {
    }
    
    
    public User(String userName, String userID, int userPhoneNo, String userEmail, String password) {
        this.userName = userName;
        this.userID = userID;
        this.userPhoneNo = userPhoneNo;
        this.userEmail = userEmail;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getUserPhoneNo() {
        return userPhoneNo;
    }

    public void setUserPhoneNo(int userPhoneNo) {
        this.userPhoneNo = userPhoneNo;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static boolean insertUser(String userName, String userID, int userPhoneNo, String userEmail, String password) {

        try {
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("INSERT INTO Users(UserName, UserID, UserPhoneNo, UserEmail, Password) VALUES(?,?,?,?,?);");
            ps.setString(1, userName);
            ps.setString(2, userID);
            ps.setInt(3, userPhoneNo);
            ps.setString(4, userEmail);
            ps.setString(5, password);
            ps.executeUpdate();
            return true;
        } catch (SQLException exception) {
            System.out.println("User : insertUser : Exception : " + exception.getMessage());
        }
        return false;
    }

    public static boolean deleteUser(String userID) {

        try {
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("DELETE FROM Users WHERE UserID =?;");
            ps.setString(1, userID);
            ps.executeUpdate();
            return true;
        } catch (SQLException exception) {
            System.out.println("User : deleteUser : Exception : " + exception.getMessage());
            exception.printStackTrace();
        }
        return false;
    }

    public static boolean updateUser(String userName, String userID, int userPhoneNo, String userEmail, String password) {

        try {
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("UPDATE USERs SET UserName=?, UserPhoneNo=?, UserEmail=?, Password=? WHERE UserID=?");
            ps.setString(1, userName);
            ps.setInt(2, userPhoneNo);
            ps.setString(3, userEmail);
            ps.setString(4, password);
            ps.setString(5, userID);
            ps.executeUpdate();
            return true;
        } catch (SQLException exception) {
            System.out.println("User : updateUser : Exception : " + exception.getMessage());
        }
        return false;
    }

    public static boolean isExist(String userName, String password) {

        try {
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("SELECT * FROM Users WHERE UserName=? and Password=?");
            ps.setString(1, userName);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException exception) {
            System.out.println("User : isExist : Exception : " + exception.getMessage());
        }
        return false;
    }
    
    public static User getUser(String userID){
        
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("SELECT * FROM Users WHERE UserID=?;");
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new User(rs.getString("UserName"), rs.getString("UserID"), rs.getInt("UserPhoneNo"), rs.getString("UserEmail"), rs.getString("Password"));
            }
        }catch(SQLException exception){
            System.out.println("User : getUser : Exception : "+exception.getMessage());
        }
        
        return null;
    }
    
    public static ArrayList<User> getAllUsers(){
        
        try{
            ArrayList<User> users = new ArrayList<>();
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("SELECT * FROM Users;");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                users.add(new User(rs.getString("UserName"), rs.getString("UserID"), rs.getInt("UserPhoneNo"), rs.getString("UserEmail"), rs.getString("Password")));
            }
            return users;
        }catch(SQLException exception){
            System.out.println("User : getUser : Exception : "+exception.getMessage());
        }
        
        return null;
    }

    public static int generateBookingID() {

        Random random = new Random();
        int number1 = random.nextInt(9);
        int number2 = random.nextInt(9);
        int number3 = random.nextInt(9);

        int number4 = random.nextInt(9);
        int number5 = random.nextInt(9);
        int number6 = random.nextInt(9);

        int number7 = random.nextInt(9);
        int number8 = random.nextInt(9);
        int number9 = random.nextInt(9);

        String number = "" + number1 + number2 + number3 + number4 + number5 + number6 + number7 + number8 + number9;

        return Integer.parseInt(number);

    }

    public static String generateUserID() {
        System.out.println("calling");
        String[] small = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",};
        String[] capital = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",};

        Random random = new Random();
        int number1 = random.nextInt(9);
        int number2 = random.nextInt(9);
        int number3 = random.nextInt(9);

        int small1 = random.nextInt(25);
        int small2 = random.nextInt(25);
        int small3 = random.nextInt(25);

        int capital1 = random.nextInt(25);
        int capital2 = random.nextInt(25);
        int capital3 = random.nextInt(25);

        String userID = small[small1] + number1 + capital[capital3] + small[small2] + capital[capital1] + number3 + capital[capital2] + number2 + small[small3];

        return userID;
    }
}
