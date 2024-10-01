package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC_Conn {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		// lets take input in datatype by user
		String sno = "6";
		String name = "prince";
		
	    Class.forName("com.mysql.cj.jdbc.Driver"); //step1
//		System.out.print(" Driver Class loaded successfully");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","prince311@A");
		//	System.out.println("Success"); // step2
			
			
			PreparedStatement ps =conn.prepareStatement("insert into firstjdbc values(?,?)");// positional parameter
//			PreparedStatement ps = conn.prepareStatement("delete from firstjdbc where sno = '2'");
			//step3
			
			
			// setting positional parameter"s
			ps.setString(1, sno);
			ps.setString(2, name);
			
			int i =ps.executeUpdate();
			//step4
			if(i>0) {
				System.out.println("Data Inserted Sucessfully in the table");
			}
			else {
				System.out.println("Upps Data Couldn't Inserted");
			}

	}
}