/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotelproject.helper;

import com.hotelproject.dao.Connect;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author abdul
 */
public class Bill {
    
    private int bookingID;
    private double grandTotal;
    private double vat;
    private double subTotal;
    private double cash;
    private String cardHolderName;
    private int cvv;
    private int cardNo;

    public Bill() {
    }

    public Bill(int bookingID, double grandTotal, double vat, double subTotal, double cash, String cardHolderName, int cvv, int cardNo) {
        this.bookingID = bookingID;
        this.grandTotal = grandTotal;
        this.vat = vat;
        this.subTotal = subTotal;
        this.cash = cash;
        this.cardHolderName = cardHolderName;
        this.cvv = cvv;
        this.cardNo = cardNo;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }
    
    public static boolean insertBillCash(int bookingID, double grandTotal, double vat, double subTotal, double cash){
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("INSERT INTO Bill(bookingID, grandTotal, vat,subtotal,cash) VALUES (?,?,?,?,?)");
            ps.setInt(1, bookingID);
            ps.setDouble(2, grandTotal);
            ps.setDouble(3, vat);
            ps.setDouble(4, subTotal);
            ps.setDouble(5, cash);
            ps.executeUpdate();
            return true;
        }catch(SQLException exception){
            System.out.println("Bill : insertBill : Exception : "+exception.getMessage());
        }
        return false;
    }
    public static boolean insertBillByCreditCard(int bookingID, double grandTotal, double vat, double subTotal, String cardHolderName, double cvv, double cardNo){
        
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("INSERT INTO Bill(bookingID, grandTotal, vat, subTotal, cardHolderName, cvv, cardNo) VALUES(?,?,?,?,?,?,?);");
            ps.setInt(1,bookingID);
            ps.setDouble(2, grandTotal);
            ps.setDouble(3, vat);
            ps.setDouble(4, subTotal);
            ps.setString(5, cardHolderName);
            ps.setDouble(6, cvv);
            ps.setDouble(7, cardNo);
            ps.executeUpdate();
            return true;
        }catch(SQLException exception){
            System.out.println("Bill : insertBill : Exception : "+exception.getMessage());
        }
        return false;
    }
    
    public static boolean deleteBill(int bookingID){
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("DELETE FROM Bill WHERE BookingID=?");
            ps.setInt(1,bookingID);
            ps.executeUpdate();
            return true;
        }catch(SQLException exception){
             System.out.println("Bill : deleteBill : Exception : "+exception);
        }
        return false;
    }
    
    public static boolean isBillPaidForGuest(int bookingID){
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("SELECT * FROM Bill WHERE BookingID=?");
            ps.setInt(1,bookingID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }            
        }catch(SQLException exception){
             System.out.println("Bill : isBillPaidForGuest : Exception : "+exception);
        }
        if(bookingID == -1){
            return true;
        }else{
            return false;
        }
        
    }
}
