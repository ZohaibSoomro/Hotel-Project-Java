/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotelproject.helper;

import com.hotelproject.dao.Connect;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author abdul
 */
public class RequestGandH {

    private String userID;
    private int bookingID;

    public RequestGandH() {
    }

    public RequestGandH(String userID, int bookingID) {
        this.userID = userID;
        this.bookingID = bookingID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public static boolean insertRequestGandH(String userID, int bookingID) {
        try {
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("INSERT INTO RequestGandH(UserID, BookingID) VALUES(?,?);");
            ps.setString(1, userID);
            ps.setInt(2, bookingID);
            ps.executeUpdate();
        } catch (SQLException exception) {
            System.out.println("RequestGandH : insertRequestGandH : Exception : " + exception);
        }
        return false;
    }
    
    public static boolean deleteRequestGandH(String userID){
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("DELETE FROM requestgandh WHERE UserID=?");
            ps.setString(1,userID);
            ps.executeUpdate();
            return true;
        }catch(SQLException exception){
             System.out.println("RequestGandH : deleteRequestGandH : Exception : "+exception);
        }
        return false;
    }

    public static boolean isAlreadyHaveBooking(String useID) {

        try {
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("SELECT * FROM RequestGandH WHERE UserID=?;");
            ps.setString(1, useID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException exception) {
            System.out.println("RequestGandH : isAlreadyHaveBooking : Exception : " + exception.getMessage());
        }
        return false;
    }

    public static boolean isHaveBooking(String userID) {

        try {
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("SELECT * FROM RequestGandH WHERE UserID=?;");
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException exception) {
            System.out.println("RequestGandH : isHaveBooking : Exception : " + exception.getMessage());
        }
        return false;
    }
    
    
    public static int getGusetBookingID(String userID) {

        try {
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("SELECT * FROM RequestGandH WHERE UserID=?;");
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("BookinID");
            }
        } catch (SQLException exception) {
            System.out.println("RequestGandH : isHaveBooking : Exception : " + exception.getMessage());
        }
        return -1;
    }
    
    public static String getGuestUserID(int bookingID) {

        try {
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("SELECT * FROM RequestGandH WHERE bookingID=?;");
            ps.setInt(1, bookingID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("UserID");
            }
        } catch (SQLException exception) {
            System.out.println("RequestGandH : isHaveBooking : Exception : " + exception.getMessage());
        }
        return null;
    }
    
    
    public static ArrayList<Integer> getBookingIDs(String userID){
        ArrayList<Integer> bookingIDs = new ArrayList<>();
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("SELECT hs.BookingID FROM hotelservices hs JOIN requestgandh gh WHERE hs.BookingID = gh.BookingID AND UserID=?;");
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                bookingIDs.add(rs.getInt("BookingID"));
            }
            
            return bookingIDs;
        }catch(SQLException exception){
            System.out.println("RequestRandS : getBookingIDs : Exception : "+exception);
        }
        return null;
    }
}
