/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotelproject.helper;

import com.hotelproject.dao.Connect;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author abdul
 */
public class SpaServices {
    
    private int bookingID;
    private double price;
    private String item;

    public SpaServices() {
    }

    public SpaServices(int bookingID, double price, String item) {
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
    
    public static boolean insertSpaServices(int bookingID, double price, String item){
        
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("INSERT INTO SpaServices(BookingID, Price, Item) VALUES(?,?,?);");
            ps.setInt(1, bookingID);
            ps.setDouble(2, price);
            ps.setString(3, item);
            ps.executeUpdate();
            return true;
        }catch(SQLException exception){
            System.out.println("SpaServices : insertSpaServices : Exception : "+exception.getMessage());
        }
        return false;
    }
    
    public static boolean deleteSpaServices(int bookingID){
        
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("DELETE FROM SpaServices WHERE BookingID=?;");
            ps.setInt(1, bookingID);
            ps.executeUpdate();
            return true;
        }catch(SQLException exception){
            System.out.println("SpaServices : deleteSpaServices : Exception : "+exception.getMessage());
        }
        return false;
    }
    
    public static void deletingAllCurrentGuestData(ArrayList<Integer> bookingIDs){
        for(int i = 0; i < bookingIDs.size(); i++){
            deleteSpaServices(bookingIDs.get(i));
        }
    }
    
    public static boolean updateSpaServices(int bookingID, double price, String item){
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("UPDATE SpaServices SET Price=?, Item=? WHERE BookingID=?;");
            ps.setInt(1, bookingID);
            ps.executeUpdate();
            return true;
        }catch(SQLException exception){
            System.out.println("SpaServices : updateSpaServices : Exception : "+exception.getMessage());
        }
        return false;
    }
}
