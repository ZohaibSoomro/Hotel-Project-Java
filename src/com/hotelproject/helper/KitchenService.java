/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotelproject.helper;

import com.hotelproject.dao.Connect;
import static com.hotelproject.helper.SpaServices.deleteSpaServices;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author abdul
 */
public class KitchenService {
    private int bookingID;
    private double price;
    private String item;

    public KitchenService() {
    }

    public KitchenService(int bookingID, double price, String item) {
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
    
      public static boolean insertKitchenService(int bookingID, double price, String item){
        
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("INSERT INTO KitchenService(BookingID, Price, Item) VALUES(?,?,?);");
            ps.setInt(1, bookingID);
            ps.setDouble(2, price);
            ps.setString(3, item);
            ps.executeUpdate();
            return true;
        }catch(SQLException exception){
            System.out.println("KitchenService : insertKitchenService : Exception : "+exception.getMessage());
        }
        return false;
    }
    
    public static boolean deleteKitchenService(int bookingID){
        
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("DELETE FROM KitchenService WHERE BookingID=?;");
            ps.setInt(1, bookingID);
            ps.executeUpdate();
            return true;
        }catch(SQLException exception){
            System.out.println("KitchenService : deleteKitchenService : Exception : "+exception.getMessage());
        }
        return false;
    }
    
    public static void deletingAllCurrentGuestData(ArrayList<Integer> bookingIDs){
        for(int i = 0; i < bookingIDs.size(); i++){
            deleteKitchenService(bookingIDs.get(i));
        }
    }
    
    public static boolean updateKitchenService(int bookingID, double price, String item){
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("UPDATE KitchenService SET Price=?, Item=? WHERE BookingID=?;");
            ps.setInt(1, bookingID);
            ps.executeUpdate();
            return true;
        }catch(SQLException exception){
            System.out.println("KitchenService : updateKitchenService : Exception : "+exception.getMessage());
        }
        return false;
    }
}
