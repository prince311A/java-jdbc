package mypack4;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

@WebServlet("/Login")
public class Login extends HttpServlet  {
	public void doPost(HttpServletRequest request ,HttpServletResponse response) throws IOException,ServletException {
		PrintWriter k = response.getWriter();
		response.setContentType("text/html");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
	//	k.print("<h3>Welcome to jdbc</h3>");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc";
			Connection connection = DriverManager.getConnection(url,"root","prince311@A");
			if(connection.isClosed()) {
				System.out.println("Not Connected");
			}
			else {
				System.out.println("Connected");
			}
			PreparedStatement ps = connection.prepareStatement("select * from login where email= ? and password = ?");
			
			ps.setString(1,id);
			ps.setString(2,password);
			
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String username = rs.getString("name");
				
				HttpSession session = request.getSession();
				session.setAttribute("name_key", username);
				session.setAttribute("city_key", rs.getString("city"));
				session.setAttribute("gender_key", rs.getString("gender"));
				session.setAttribute("sno_key",rs.getString("sno"));
				
				RequestDispatcher rd = request.getRequestDispatcher("/profile.jsp");
				rd.include(request, response);
				
				
				
			}
			else {
				k.print("<h3 style='color:red'>Soory!ID and Password didn't Matched</h3>");
				RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
				rd.include(request, response);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			k.print("<h3 style='color:red'>Error Occurred"+e.getMessage()+"</h3>");
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.include(request, response);
		}

	
		
	}
	

}
