/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotelproject.helper;

import com.hotelproject.dao.Connect;
import static com.hotelproject.helper.SpaServices.deleteSpaServices;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author abdul
 */
public class GymServices {
    private int bookingID;
    private double price;
    private String item;

    public GymServices() {
    }

    public GymServices(int bookingID, double price, String item) {
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
    
    public static boolean insertGymServices(int bookingID, double price, String item){
        
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("INSERT INTO GymServices(BookingID, Price, Item) VALUES(?,?,?);");
            ps.setInt(1, bookingID);
            ps.setDouble(2, price);
            ps.setString(3, item);
            ps.executeUpdate();
            return true;
        }catch(SQLException exception){
            System.out.println("GymServices : insertGymServices : Exception : "+exception.getMessage());
        }
        return false;
    }
    
    public static boolean deleteGymServices(int bookingID){
        
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("DELETE FROM GymServices WHERE BookingID=?;");
            ps.setInt(1, bookingID);
            ps.executeUpdate();
            return true;
        }catch(SQLException exception){
            System.out.println("GymServices : insertGymServices : Exception : "+exception.getMessage());
        }
        return false;
    }
    
    public static void deletingAllCurrentGuestData(ArrayList<Integer> bookingIDs){
        for(int i = 0; i < bookingIDs.size(); i++){
            deleteGymServices(bookingIDs.get(i));
        }
    }
    
    public static boolean updateGymServices(int bookingID, double price, String item){
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("UPDATE GymServices SET Price=?, Item=? WHERE BookingID=?;");
            ps.setInt(1, bookingID);
            ps.executeUpdate();
            return true;
        }catch(SQLException exception){
            System.out.println("GymServices : insertGymServices : Exception : "+exception.getMessage());
        }
        return false;
    }
}
