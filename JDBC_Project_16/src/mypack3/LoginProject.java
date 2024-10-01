package mypack3;

import java.io.FileInputStream;
import java.sql.*;

public class LoginProject {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		System.out.print("yes");
		
		String url = "jdbc:mysql://localhost:3306/jdbc";
		Connection con = DriverManager.getConnection(url,"root","prince311@A");
		
		if(con.isClosed()) {
			System.out.print("Connection is cloesd");
		}
		else {
			System.out.println("Database Connected Successfully");
			
		}
		String q = "insert into jdbcpic(pic) values (?)";
		PreparedStatement ps = con.prepareStatement(q);
		
	    FileInputStream fis = new FileInputStream("\'D:\\mypic.jpg\'");
		
		ps.setBinaryStream(1, fis,fis.available());
		
		int i =ps.executeUpdate();
		
		if(i>0) {
			System.out.println("Data Uploaded Successfully");
		}
		else {
			System.out.println("Failed to upload");
		}
		
	}

}
