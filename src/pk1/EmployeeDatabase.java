package pk1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmployeeDatabase
 */
public class EmployeeDatabase extends HttpServlet {
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
         
         HttpSession session1 = request.getSession();
 		 String a2=  (String) session1.getAttribute("name1");
 		 int r2=(int) session1.getAttribute("random");
 		 String  date= (String) session1.getAttribute("date");
 		 int n=(int) session1.getAttribute("price");
 		 int quan=(int) session1.getAttribute("quan");
 		
 		 
	 
        
         String nam=request.getParameter("name");
         String ph=request.getParameter("phoneno");
         String add=request.getParameter("address");
         
        
         out.print(a2+" "+date+" "+nam+" "+ph+" "+add+" "+r2+" "+quan);
         try{
             
            
             Class.forName("com.mysql.jdbc.Driver");

     	
               Connection  con=DriverManager.getConnection
                          ("jdbc:mysql://localhost:3306/Mindscript_Project","root","root");

             PreparedStatement pst=con.prepareStatement("insert into customer1 values(?,?,?,?,?,?,?,?)");
             pst.setInt(1, r2);
             pst.setString(2, a2);
             pst.setString(6, date);
             pst.setString(3, nam);
             pst.setString(5, ph);
             pst.setString(4,add);
             pst.setInt(7,quan);
             pst.setInt(8, n*quan);
             pst.executeUpdate();
            System.out.println("updated");
            
            
           
         }
         catch (Exception e2) {e2.printStackTrace();} 
	}
}
	


