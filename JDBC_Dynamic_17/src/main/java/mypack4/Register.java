package mypack4;

	import jakarta.servlet.*;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.*;
	import java.io.*;
	import java.sql.*; 

	@WebServlet("/Register")

	public class Register extends HttpServlet{
		
		public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
			
			response.setContentType("text/html");
			PrintWriter k = response.getWriter();
			
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String city = request.getParameter("city");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			if(name.trim().isEmpty() || email.trim().isEmpty() || city.trim().isEmpty() || gender.trim().isEmpty() || password.trim().isEmpty()) {
				k.print("<h3 style = 'color:red'>Please Fill All The Entities </h3>");
				
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.include(request, response);
				
			}else {
			
//			if(request.getParameter("register").equals("Register")) {
//			k.println("Name : "+name);
//			k.println("<br><br>");
//			k.println("Email : "+email);
//			k.println("<br><br>");
//			k.println("City : "+city);
//			k.println("<br><br>");
//			k.println("Gender : "+gender);
//			k.println("<br><br>");
//			k.println("Password : "+password);
//			k.println("<br>");
//			}
			
			
			// NOw insert this data to database through JDBC
			//k.println("<h3>Welcome to JDBC</h3>");
//			k.println("<br>");
			String url = "jdbc:mysql://localhost:3306/jdbc";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,"root","prince311@A");
//				if(con.isClosed()){
//					k.print("Databases not connected");
//					}
//					else {
//					k.println("Database Connected Succesfully");
//					}
				PreparedStatement ps = con.prepareStatement("insert into login(name,password,city,gender,email) values(?,?,?,?,?)");
				
				ps.setString(1, name);
				ps.setString(2, password);
				ps.setString(3, city);
				ps.setString(4, gender);
				ps.setString(5, email);
				
				int count = ps.executeUpdate();
				if(count>0) {
					k.print("<h3 style = 'color:green'>User Registered Successfully</h3>");
					
					RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
					rd.include(request, response);
				
					}
				else {
					k.print("<h3 style = 'color:red'>User Not Registered </h3>");
					
					RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
					rd.include(request, response);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
				k.print("<h3 style = 'color:red'>Exception Occured :"+e.getMessage()+"</h3>");
				
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.include(request, response);
			}	
		}
		}
	}
