/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotelproject.helper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.hotelproject.dao.Connect;
import java.util.Random;

/**
 *
 * @author abdul
 */
public class Employee {
    private String name;
    private String userName;
    private String userID;
    private int userPhoneNo;
    private String userEmail;
    private String password;
    private int age;
    private double salary;
    private double workingHours;

    public Employee() {
    }

    public Employee(String name, String userName, String userID, int userPhoneNo, String userEmail, String password, int age, double salary, double workingHours) {
        this.name = name;
        this.userName = userName;
        this.userID = userID;
        this.userPhoneNo = userPhoneNo;
        this.userEmail = userEmail;
        this.password = password;
        this.age = age;
        this.salary = salary;
        this.workingHours = workingHours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", userName=" + userName + ", userID=" + userID + ", userPhoneNo=" + userPhoneNo + ", userEmail=" + userEmail + ", password=" + password + ", age=" + age + ", salary=" + salary + ", workingHours=" + workingHours + '}';
    }
    
    public static boolean insertEmployee(String name, String userName, String userID, int userPhoneNo, 
            String userEmail, String password, int age, double salary, double workingHours){
        
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("INSERT INTO Employee(Name, UserName, UserID, UserPhoneNo, UserEmail, Password, Age, Salary, WorkingHours) VALUES(?,?,?,?,?,?,?,?,?);");
            ps.setString(1, name);
            ps.setString(2, userName);
            ps.setString(3, userID);
            ps.setInt(4, userPhoneNo);
            ps.setString(5, userEmail);
            ps.setString(6, password);
            ps.setInt(7, age);
            ps.setDouble(8, salary);
            ps.setDouble(9, workingHours);
            ps.executeUpdate();
            return true;
        }catch(SQLException exception){
            System.out.println("Employee : insertEmployee : Exception : "+exception.getMessage());
        }
        return false;
    }
    
    public static boolean deleteUser(String userID){
        
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("DELETE FROM Employee WHERE UserID =?;");
            ps.setString(1, userID);
            ps.executeUpdate();
            return true;
        }catch(SQLException exception){
//            System.out.println("Employee : deleteUser : Exception : "+exception.getMessage());
        }
        return false;
    }
    
public static boolean updateEmployee(String name, String userName, String userID, int userPhoneNo, 
            String userEmail, String password, int age, double salary, double workingHours){
        
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("UPDATE Employee SET Name=?, UserName=?, UserPhoneNo=?, UserEmail=?, Password=?, Age=?, Salary=?, WorkingHours=? WHERE UserID=?");
            ps.setString(1, name);
            ps.setString(2, userName);
            ps.setInt(3, userPhoneNo);
            ps.setString(4, userEmail);
            ps.setString(5, password);
            ps.setInt(6, age);
            ps.setDouble(7, salary);
            ps.setDouble(8, workingHours);
            ps.setString(9, userID);
            ps.executeUpdate();
            return true;
        }catch(SQLException exception){
            System.out.println("Employee : updateEmployee : Exception : "+exception.getMessage());
        }
        return false;
    }

        public static boolean isExist(String userName, String password) {

        try {
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("SELECT * FROM Employee WHERE UserName=? and Password=?");
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
        
    public static Employee getEmployee(String userName, String password){
        
        try{
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("SELECT * FROM Employee WHERE UserName=? and Password=?;");
            ps.setString(1, userName);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Employee(rs.getString("Name"), rs.getString("UserName"), rs.getString("UserID"), rs.getInt("UserPhoneNo"), rs.getString("UserEmail"), rs.getString("Password"), rs.getInt("Age"), rs.getDouble("Salary"), rs.getDouble("WorkingHours"));
            }
        }catch(SQLException exception){
            System.out.println("User : getUser : Exception : "+exception.getMessage());
        }
        
        return null;
        
    }
    
    public static ArrayList<Employee> getAllEmployees(){
        
        try{
            ArrayList<Employee> employees = new ArrayList<>();
            PreparedStatement ps = Connect.getInstance().getPreparedStatement("SELECT * FROM Employee;");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                employees.add(new Employee(rs.getString("Name"), rs.getString("UserName"), rs.getString("UserID"), rs.getInt("UserPhoneNo"), rs.getString("UserEmail"), rs.getString("Password"), rs.getInt("Age"), rs.getDouble("Salary"), rs.getDouble("WorkingHours")));
            }
            return employees;
        }catch(SQLException exception){
            System.out.println("User : getUser : Exception : "+exception.getMessage());
        }
        
        return null;
        
    }
    
    public static boolean isRegistered(String userName, String password) {

        try {
            String query = "Select * From Employee Where UserName=? and Password=?";
            PreparedStatement ps = Connect.getInstance().getPreparedStatement(query);
            ps.setString(1, userName);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
              return true;
            }
        } catch (SQLException exception) {
            System.out.println("Exception : " + exception.getMessage());
        }
        return false;
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
