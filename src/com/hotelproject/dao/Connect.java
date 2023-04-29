
package com.hotelproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Connect {
    private Connection connection;
	private Statement statement;
	
//	private final String URL = "jdbc:mysql://localhost:3306/hotel_db";
        private final String URL = "jdbc:mysql://localhost:3306/hotel_db?characterEncoding=latin1&useConfigs=maxPerformance";
	private final String USERNAME = "root";
	private final String PASSWORD = "4244";
	private static Connect connect;
	
	private Connect()
	{
		try
		{
                    Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Got Connection!");
			statement = connection.createStatement();
		}catch(SQLException e)
		{
                    System.out.println(e.getMessage());
			e.printStackTrace();
		}catch(ClassNotFoundException e){
                    System.out.println("Class Not found : In Connect class");
                }
	}
	
	public ResultSet getAll(String table)
	{
		ResultSet rs = null;
		try {
			rs = statement.executeQuery("SELECT * FROM " + table);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public PreparedStatement getPreparedStatement(String query)
	{
		PreparedStatement pStatement = null;
		try {
			pStatement = connection.prepareStatement(query);
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pStatement;
	}
	public static Connect getInstance()
	{
		return (connect == null) ? connect = new Connect() : connect;
	}
}
