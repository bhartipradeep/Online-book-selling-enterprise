package pk1;

import java.sql.*;

public class Connection1 extends Page2 {

	public static void main(String[] args) throws Exception {
		{
			 Connection con;
			 Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Mindscript_Project","root","root");
			 String s="select * from BookTable1 where id='a'";
			 Statement st=con.createStatement();
			 ResultSet bn=st.executeQuery(s);
			 while(bn.next()){
			 System.out.println(bn.getString(1) +" "+bn.getString(2)+" "+ bn.getString(3)+ " "+bn.getString(4)+ " "+bn.getInt(5));
			
			 }
		 }
	}

	

}
