/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotelproject.helper;

import com.hotelproject.dao.Connect;
import static com.hotelproject.helper.SpaServices.deleteSpaServices;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author abdul
 */
public class HotelServices {

    private int bookingID;
    private double price;
    private String item;

    public HotelServices() {
    }

    public HotelServices(int bookingID, double price, String item) {
        this.bookingID = bookingID;
        this.price = price;
        this.item = item;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public static boolean insertHotelServices(int bookingID, double price, String item) {

        try {
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("INSERT INTO HotelServices(BookingID, Price, Item) VALUES(?,?,?);");
            ps.setInt(1, bookingID);
            ps.setDouble(2, price);
            ps.setString(3, item);
            ps.executeUpdate();
            return true;
        } catch (SQLException exception) {
            System.out.println("GymServices : insertGymServices : Exception : " + exception.getMessage());
        }
        return false;
    }

    public static boolean deleteHotelServices(int bookingID) {

        try {
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("DELETE FROM HotelServices WHERE BookingID=?;");
            ps.setInt(1, bookingID);
            ps.executeUpdate();
            return true;
        } catch (SQLException exception) {
            System.out.println("HotelServices : deleteHotelServices : Exception : " + exception.getMessage());
        }
        return false;
    }
    
    public static void deletingAllCurrentGuestData(ArrayList<Integer> bookingIDs){
        for(int i = 0; i < bookingIDs.size(); i++){
            deleteHotelServices(bookingIDs.get(i));
        }
    }

    public static boolean updateHotelServices(int bookingID, double price, String item) {
        try {
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("UPDATE HotelServices SET Price=?, Item=? WHERE BookingID=?;");
            ps.setInt(1, bookingID);
            ps.executeUpdate();
            return true;
        } catch (SQLException exception) {
            System.out.println("GymServices : insertGymServices : Exception : " + exception.getMessage());
        }
        return false;
    }

//    public static int getGusetBookingID(String userID) {
//        int bookingID = RequestGandH.getGusetBookingID(userID);
//        if (bookingID != -1) {
//            return bookingID;
//        }
//        return -1;
//    }
    
    public static int getGuestBookingID(String userID){
        
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("SELECT h.BookingID, h.Price, h.Item FROM hotelservices h JOIN requestgandh r WHERE h.BookingID = r.BookingID AND h.Item IN ('Suite','Single','Double')  AND UserID=?;");
            ps.setString(1, userID);;
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt("BookingID");
            }
        }catch(SQLException exception){
             System.out.println("HotelServices : getGuestBookingID : Exception : " + exception.getMessage());
        }
        
        return -1;
    }
    
    public static double getGuestServicesSubTotalAmount(String userID) {
        double amount = 0;

        try {
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("SELECT h.bookingid, h.price, h.item FROM hotelservices h JOIN requestgandh r WHERE r.BookingID = h.BookingID AND r.UserID=?;");
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                amount += rs.getDouble("Price");
            }
            return amount;
        } catch (SQLException exception) {
            System.out.println("HotelServices : getUserServicesSubTotalAmount : Exception : " + exception.getMessage());
        }
        return -1;
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
