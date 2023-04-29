/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotelproject.helper;

import com.hotelproject.dao.Connect;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author abdul
 */
public class BookingRoom {
    private int roomNo;
    private String roomType;
    private Date checkInDate;
    private Date checkOutDate;
    private String userID;

    public BookingRoom() {
    }

    public BookingRoom(int roomNo, String roomType, Date checkInDate, Date checkOutDate, String userID) {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.userID = userID;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "BookingRoom{" + "roomNo=" + roomNo + ", roomType=" + roomType + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate +", userID="+userID +'}';
    }
    
    public static boolean insertBookingRoom(int roomNo, String roomType, Date checkInDate, Date checkOutDate, String userID){
        
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("INSERT INTO BookingRoom(RoomNo, RoomType, CheckInDate, CheckOutDate, UserID) VALUES(?,?,?,?,?);");
            ps.setInt(1, roomNo);
            ps.setString(2, roomType);
            ps.setDate(3, checkInDate);
            ps.setDate(4, checkOutDate);
            ps.setString(5, userID);
            ps.executeUpdate();
            return true;
        }catch(SQLException exception){
            System.out.println("BookingRoom : insertBookingRoom : Exception : "+exception.getMessage());
            exception.printStackTrace();
        }
        return false;
    }
    
    public static boolean deleteBookingRoom(int roomNo){
        
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("DELETE FROM BookingRoom WHERE RoomNo =?;");
            ps.setInt(1, roomNo);
            ps.executeUpdate();
            return true;
        }catch(SQLException exception){
            System.out.println("BookingRoom : deleteBookingRoom : Exception : "+exception.getMessage());
        }
        return false;
    }
    
    public static boolean updateBookingRoom(int roomNo, String roomType, Date checkInDate, Date checkOutDate){
        
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("UPDATE BookingRoom SET RoomNo, RoomType=?, CheckInDate=?, CheckOutDate=? WHERE RoomNo=?;");
            ps.setInt(1, roomNo);
            ps.setString(2, roomType);
            ps.setDate(3, checkInDate);
            ps.setDate(4, checkOutDate);
            ps.executeUpdate();
            return true;
        }catch(SQLException exception){
            System.out.println("BookingRoom : updateBookingRoom : Exception : "+exception.getMessage());
        }
        return false;
    }
    
    public static boolean isRoomBooked(int roomNo){
        
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("SELECT * FROM BookingRoom WHERE RoomNo=?");
            ps.setInt(1, roomNo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(SQLException exception){
            System.out.println("BookingRoom : isRoomBooked : Exception : "+exception.getMessage());
        }
        return false;
    }
    
    public static boolean isAlreadyHaveBooking(String userID){
        
        if(RequestGandH.isAlreadyHaveBooking(userID)){
            return true;
        }
        
        return false;
    }
    
    public static boolean isHaveBooking(String userID){
//        RequestGandH.isHaveBooking(userID)
        
         try {
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("SELECT * FROM BookingRoom WHERE UserID=?;");
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException exception) {
            System.out.println("BookingRoom : isHaveBooking : Exception : " + exception.getMessage());
        }
        return false;
    }
    
    public static int getGuestRoomNo(String userID){
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("SELECT * FROM BookingRoom WHERE UserID=?");
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt("RoomNo");
            }
        }catch(SQLException exception){
            System.out.println("BookingRoom : getRoomNo : Exception : "+exception.getMessage());
        }
        return 1;
    }
    
    
    public static BookingRoom getGuestBookingRoom(String userID){
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("SELECT * FROM BookingRoom WHERE UserID=?");
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new BookingRoom(rs.getInt("RoomNo"), rs.getString("RoomType"), rs.getDate("CheckInDate"), rs.getDate("CheckOutDate"), rs.getString("UserID"));
            }
        }catch(SQLException exception){
            System.out.println("BookingRoom : getRoomNo : Exception : "+exception.getMessage());
        }
        return null;
    }
    
    
    public static String getGuestRoomType(String userID){
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("SELECT * FROM BookingRoom WHERE UserID=?");
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getString("RoomType");
            }
            
        }catch(SQLException exception){
            System.out.println("BookingRoom : getGuestRoomType : Exception : "+exception.getMessage());
        }
        return null;
    }
    
    public static String getGuestRoomNumber(int roomNo){
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("SELECT * FROM BookingRoom WHERE roomNo=?");
            ps.setInt(1, roomNo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getString("RoomType");
            }
            
        }catch(SQLException exception){
            System.out.println("BookingRoom : getGuestRoomType : Exception : "+exception.getMessage());
        }
        return null;
    }
    
    
}
