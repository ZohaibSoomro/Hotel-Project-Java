/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotelproject.helper;

import com.hotelproject.dao.Connect;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author abdul
 */
public class Guest {

    private String name;
    private String userName;
    private String userID;
    private int userPhoneNo;
    private String userEmail;
    private String password;
    private Boolean checkIn;
    private Boolean checkOut;

    public Guest() {
    }

    public Guest(String name, String userName, String userID, int userPhoneNo, String userEmail, String password, Boolean checkIn, Boolean checkOut) {
        this.name = name;
        this.userName = userName;
        this.userID = userID;
        this.userPhoneNo = userPhoneNo;
        this.userEmail = userEmail;
        this.password = password;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Boolean checkIn) {
        this.checkIn = checkIn;
    }

    public Boolean getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Boolean checkOut) {
        this.checkOut = checkOut;
    }

    
    @Override
    public String toString() {
        return "Guest{" + "name=" + name + ", userName=" + userName + ", userID=" + userID + ", userPhoneNo=" + userPhoneNo + ", userEmail=" + userEmail + ", password=" + password +", checkIn="+checkIn+", checkOut="+checkOut+ '}';
    }

    public static boolean insertGuest(String name, String userName, String userID, int userPhoneNo, String userEmail, String password, Boolean checkIn, Boolean checkOut) {
        try {
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("INSERT INTO Guest(Name, UserName, UserID,UserPhoneNo, UserEmail, Password, CheckIn, CheckOut) VALUES(?,?,?,?,?,?,?,?);");
            ps.setString(1, name);
            ps.setString(2, userName);
            ps.setString(3, userID);
            ps.setInt(4, userPhoneNo);
            ps.setString(5, userEmail);
            ps.setString(6, password);
            ps.setBoolean(7, checkIn);
            ps.setBoolean(8, checkOut);
            ps.executeUpdate();
            return true;
        } catch (SQLException exception) {
            System.out.println("Guest : insertGuest : Exception : " + exception.getMessage());
        }
        return false;
    }

    public static boolean deleteGuest(String userID) {
        try {
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("DELETE FROM Guest WHERE UserID =?;");
            ps.setString(1, userID);
            ps.executeUpdate();
            return true;
        } catch (SQLException exception) {
            System.out.println("Employee : deleteUser : Exception : " + exception.getMessage());
        }
        return false;
    }

    public static boolean updateGuest(String name, String userName, String userID, int userPhoneNo, String userEmail, String password, Boolean checkIn, Boolean checkOut) {
        try {
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("UPDATE GUEST SET Name=?, UserName=?, UserPhoneNo=?, UserEmail=?, Password=?, CheckIn=?, CheckOut=? WHERE UserID=?;");
            ps.setString(1, name);
            ps.setString(2, userName);
            ps.setInt(3, userPhoneNo);
            ps.setString(4, userEmail);
            ps.setString(5,password);
            ps.setBoolean(6, checkIn);
            ps.setBoolean(7, checkOut);
            ps.setString(8, userID);
            ps.executeUpdate();
            return true;
        } catch (SQLException exception) {
            System.out.println("Guest : Upadate : Exception : " + exception.getMessage());
        }
        return false;
    }
    
    public static boolean guestCheckIn(Boolean checkIn, String userID) {
        try {
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("UPDATE GUEST SET CheckIn=? WHERE UserID=?;");
            ps.setBoolean(1, checkIn);
            ps.setString(2, userID);
           
            ps.executeUpdate();
            return true;
        } catch (SQLException exception) {
            System.out.println("Guest : insertGuest : Exception : " + exception.getMessage());
        }
        return false;
    }
    
    public static boolean guestCheckOut(Boolean checkOut, String userID) {
        try {
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("UPDATE GUEST SET CheckOut=? WHERE UserID=?;");
            ps.setBoolean(1, checkOut);
            ps.setString(2, userID);
           
            ps.executeUpdate();
            return true;
        } catch (SQLException exception) {
            System.out.println("Guest : insertGuest : Exception : " + exception.getMessage());
        }
        return false;
    }
    


    public static boolean isExist(String userName, String password) {

        try {
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("SELECT * FROM Guest WHERE UserName=? and Password=?");
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
    
    public static boolean isValidUser(String userID){
        try {
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("SELECT * FROM Guest WHERE UserID=?");
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException exception) {
            System.out.println("User : isValidUser : Exception : " + exception.getMessage());
        }
        return false;
    }
    
    public static Guest getGuest(String userID){
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("SELECT * FROM Guest WHERE UserID=?;");
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Guest(rs.getString("Name"), rs.getString("UserName"), rs.getString("UserID"), rs.getInt("UserPhoneNo"), rs.getString("UserEmail"), rs.getString("Password"), rs.getBoolean("CheckIn"), rs.getBoolean("CheckOut"));
            }
        }catch(SQLException exception){
            System.out.println("User : getUser : Exception : "+exception.getMessage());
        }
        
        return null;
    }
    
    public static Guest getGuest(String userName, String password){
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("SELECT * FROM Guest WHERE UserName=? and Password=?;");
            ps.setString(1, userName);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Guest(rs.getString("Name"), rs.getString("UserName"), rs.getString("UserID"), rs.getInt("UserPhoneNo"), rs.getString("UserEmail"), rs.getString("Password"), rs.getBoolean("CheckIn"), rs.getBoolean("CheckOut"));
            }
        }catch(SQLException exception){
            System.out.println("User : getUser : Exception : "+exception.getMessage());
        }
        
        return null;
    }
    
     public static ArrayList<Guest> getAllGuests(){
        try{
            ArrayList<Guest> guests = new ArrayList<>();
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("SELECT * FROM Guest;");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                guests.add(new Guest(rs.getString("Name"), rs.getString("UserName"), rs.getString("UserID"), rs.getInt("UserPhoneNo"), rs.getString("UserEmail"), rs.getString("Password"), rs.getBoolean("CheckIn"), rs.getBoolean("CheckOut")));
            }
            return guests;
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
