package pk1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class Page2
 */
public class Page2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
		}
		
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
		 response.setContentType("text/html");
         PrintWriter out = response.getWriter();        
         String a=request.getParameter("id");
         
         HttpSession session = request.getSession();
         session.setAttribute("name", a);
        
 
         out.println("<h1  style='margin:0;padding:5px;background-color:#ffff99;color:#0040ff;'><center><b><u>BOOK DETAILS</u></b></center></h1>");
         out.println("<br><br><br>");
        
         try{  
        	 Class.forName("com.mysql.jdbc.Driver");  
        	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Mindscript_Project","root","root");  
        	 
        	  PreparedStatement pst=con.prepareStatement("select * from BookTable1 where book_id=?");
 			pst.setString(1, a);
 			 ResultSet rs=pst.executeQuery();
			
 			
           
 			
			 while(rs.next())
				 
			 {
				 out.println("<html>");
				 out.println("<body background='E:\\nikhil\\project images\\image1.jpg'>");
				 out.println("<h2 style='margin:0;padding:2px;width=80%;background-color: #00ff55;color:#ff0066'><b><marquee>These are the details of your book. Click confirm to place your order.Click cancel to rechoose the book.</marquee></b></h2><br><br><br>");
				 out.println("<table width='1000'>");
		         out.println("<table border='5' width='100%' height='200' cellspacing='5' cellpadding='5' bordercolor='red' bgcolor='#9999ff'>");
		         out.println("<tr><td><h3><b>BOOK GENRE</b></h3></td>");out.println("<td>"+rs.getString(1)+"</td>");out.println("</tr>");
		         out.println("<tr><td><h3><b>BOOK ID</b></h3></td>");out.println("<td>"+rs.getString(2)+"</td>");out.println("</tr>");
		         out.println("<tr><td><h3><b>BOOK SELECTED</b></h3></td>");out.println("<td>"+rs.getString(3)+"</td>");out.println("</tr>");
		         out.println("<tr><td><h3><b>BOOK AUTHOR</b></h3></td>");out.println("<td>"+rs.getString(4)+"</td>");out.println("</tr>");
		         out.println("<tr><td><h3><b>BOOK PRICE</b></h3></td>");out.println("<td>"+rs.getString(5)+"</td>");out.println("</tr>");
		         out.print("<form action='Page3'>");
		         out.println("<tr><td><h3><b>QUANTITY</b></h3></td>");out.println("<td><input type='text' name='qty'></td></tr>");
		        
		         out.println("</table>");
		         out.println("<br><br><br>");
		        
		      
		        
		         out.print("<input type='submit' name='confirm' value='Confirm' style='font-face:Comic Sans MS;font-size: larger; color: #00ff00; background-color: #b300b3; border: 3pt ridge;>");
		         out.print("</form>");
				 out.print("<form action='WelcomePage.jsp'><input type='submit' name='cancel' value='Cancel'></form>");
		         out.println("</body>");
		         out.println("</html>");
		         
		         int p=rs.getInt(5);
			     out.print(p);
			     session.setAttribute("price", p);
			 }
			  
			 int q=Integer.parseInt(request.getParameter("qty"));
	         System.out.println(q);
			 
		
         }
         
        
         
         catch (Exception e2) {e2.printStackTrace();}  
        	           
        	 finally{out.close();}  
        
			
		// session.setAttribute("quan", q);
       
			 
         } 
	}


