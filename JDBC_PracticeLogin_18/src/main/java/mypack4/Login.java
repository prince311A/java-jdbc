package mypack4;

import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.*;
import jakarta.servlet.http.*;


@WebServlet("/Login")
public class Login extends HttpServlet {
	public void doPost(HttpServletRequest Request,HttpServletResponse Response)throws ServletException,
	IOException{
		PrintWriter k = Response.getWriter();
		Response.setContentType("text/html");
		
		String username = Request.getParameter("username");
		String password = Request.getParameter("password");
		
		k.print("Your UserName is "+username);
		k.print("<br>");
		k.print("Your Password is "+password);
		
		// connecting database
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc";
			Connection conn = DriverManager.getConnection(url,"root","prince311@A");
			if(conn.isClosed()) {
				System.out.println("Database Couldn't Successfully");
			}
			else {
				System.out.println("Database Connected Successfully");
			}
			PreparedStatement ps=conn.prepareStatement("insert into loginpass values(?,?)");
			
			ps.setString(1, username);
			ps.setString(2, password);
			int i =ps.executeUpdate();
			k.print("<br>");
			//step4
			if(i>0) {
				k.println("Data Inserted Sucessfully in the table");
			}
			else {
				k.println("Upps Data Couldn't Inserted");
		}
		}
		catch(Exception e) {
			e.printStackTrace();		}
		}
		

}
