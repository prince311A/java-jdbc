package mypack2;

import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;

public class FetchDataJdbc {

	public static void main(String[] args)  throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","prince311@A");
		
		// checking connection
		if(con.isClosed()) {
			System.out.println("Connection is closed");
		}
		else {
			System.out.println("Database Connected Successfully");
		}
		
		
		PreparedStatement ps =con.prepareStatement("select * from firstjdbc");
	    ResultSet rs = ps.executeQuery();
	    
	    // lets fetch the data
	    while(rs.next()) {
	    	String sno = rs.getString("sno");
	    	System.out.println("Id is "+sno);
	    	
	    	String name = rs.getString("name");
	    	System.out.println("Name is "+name);
	    	
	    	System.out.println("-------------------------------------");
	    	
	    }
	    	
	  
	}

}
