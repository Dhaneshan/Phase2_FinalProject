package FlightBooking;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/User_details")
public class User_details extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public User_details() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	   PrintWriter cout=response.getWriter();
	   try
	   {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dhaneshan","root","Dhaneshan@2001");
			 String Airlines_Name=request.getParameter("Airlines_name");
			 String Flight_Name=request.getParameter("Flight_name");
			 String Demo ="select * from Flightdetails";
			 Statement stmt=con.createStatement();
			 ResultSet Rs=stmt.executeQuery(Demo);
			 HttpSession session=request.getSession();
			 session.setAttribute("Flight_Name", Flight_Name);
			 session.setAttribute("Airlines_Name", Airlines_Name);
			 int price;
			 boolean flag=true;
			 while(Rs.next())
			 {
				 if(Rs.getString("Airlines_Name").equalsIgnoreCase(Airlines_Name) && Rs.getString("Flight_Name").equalsIgnoreCase(Flight_Name))
				 {
					 cout.print("<b>"+" User Details "+"</b>");
					 cout.println("<br/><br/>");
					 cout.print("Date of Travel : "+session.getAttribute("Date"));
					 cout.println("<br/><br/>");
					 cout.print("Departure : "+ session.getAttribute("Departure"));
					 cout.println("<br/><br/>");
					 cout.print("Arrive : "+session.getAttribute("Arrive"));
					 cout.println("<br/><br/>");
					 cout.print("Airlines Name : "+session.getAttribute("Airlines_Name"));
					 cout.println("<br/><br/>");
					 cout.print("Flight Name : "+session.getAttribute("Flight_Name"));
					 cout.println("<br/><br/>");
					 price=Rs.getInt("price");
					 session.setAttribute("Price", price);
					 cout.print("Price for Per Passenger: "+session.getAttribute("Price"));
					 int Total_passenger = (Integer) session.getAttribute("No_of_person");
					 cout.println("<br/><br/>");
					 int Total=price*Total_passenger;
					 session.setAttribute("Total", Total);
					 cout.print("Total Price: "+session.getAttribute("Total"));
					 cout.println("<br/><br/>");
					 cout.println("<form action='Show_details' method='get'>");
					 cout.println("Enter UserName: <input type='text' name='name'>");
					 cout.println("<br/><br/>");
					 cout.println("Enter Password: <input type='text' name='password'>");
					 cout.println("<br/><br/>");
					 cout.println("Enter Confirm Password: <input type='text' name='cpassword'>");
					 cout.println("<br/><br/>");
					 cout.println("<input type='submit' value='Pay'>");
					 cout.println("</form>");
					 flag=false;
				 }

			   if(flag)
			    {
				  cout.print("Invalid Flight Details");
				  break;
			    }
			 
	   }
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   
	   
	}
	

}
