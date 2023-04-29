/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotelproject.helper;

import com.hotelproject.dao.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author abdul
 */
public class RequestRandK {
    
     private int roomNo;
    private int bookingID;

    public RequestRandK() {
    }

    public RequestRandK(int roomNo, int bookingID) {
        this.roomNo = roomNo;
        this.bookingID = bookingID;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

   
    public static boolean insertRequestRandK(int roomNo, int bookingID){
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("INSERT INTO RequestRandK(RoomNo, BookingID) VALUES(?,?);");
            ps.setInt(1, roomNo);
            ps.setInt(2, bookingID);
            ps.executeUpdate();
        }catch(SQLException exception){
            System.out.println("RequestRandK : insertRequestRandK : Exception : "+exception);
        }
        return false;
    }
    
    public static boolean deleteRequestRandK(int roomNo){
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("DELETE FROM requestrandk WHERE RoomNo=?");
            ps.setInt(1,roomNo);
            ps.executeUpdate();
            return true;
        }catch(SQLException exception){
             System.out.println("RequestRandK : deleteRequestRandK : Exception : "+exception);
        }
        return false;
    }
    
    public static int getRoomNumber(String userID){
//         SELECT k.RoomNo  FROM requestrandk k JOIN requestgandh r WHERE r.BookingID = k.BookingID AND r.UserID='c0EhR7P5o';
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("SELECT k.roomNo FROM requestgandk k JOIN requestgandh r WHERE r.BookingID = h.BookingID AND r.UserID=?;");
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
//                amount += rs.getDouble("Price");
            }
        }catch(SQLException exception){
            System.out.println("RequestRandK : getRoomNumber : Exception : "+exception);
        }
        return -1;
    }
    
    public static ArrayList<Integer> getBookingIDs(String userID){
        ArrayList<Integer> bookingIDs = new ArrayList<>();
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("SELECT rk.BookingID FROM requestrandk rk JOIN requestgandh gh WHERE rk.BookingID = gh.BookingID AND UserID=?;");
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
