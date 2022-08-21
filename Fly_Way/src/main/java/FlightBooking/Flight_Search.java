package FlightBooking;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Flight_Search")
public class Flight_Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Flight_Search() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter cout=response.getWriter();
		try 
		{
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dhaneshan","root","Dhaneshan@2001");
			 String Date=request.getParameter("Date");
			 String Departure=request.getParameter("Dep");
			 String Arrive=request.getParameter("Arr");
			 int No_of_person=Integer.parseInt(request.getParameter("No"));
			 String Demo ="select * from Flightdetails";
			 Statement stmt=con.createStatement();
			 ResultSet Rs=stmt.executeQuery(Demo);
			 HttpSession session=request.getSession();
			 session.setAttribute("Date", Date);
			 session.setAttribute("Departure", Departure);
			 session.setAttribute("Arrive", Arrive);
			 session.setAttribute("No_of_person", No_of_person);
			 cout.println("<table border=1>");
			 cout.println("<tr><th>Airlines Name</th><th>Flight Name</th><th>Departure</th><th>Arrive</th><th>Price Per Person</th></tr>");
			 boolean flag=false;
			 while(Rs.next())
			 {
				 if(Rs.getDate("date").toString().equals(session.getAttribute("Date")) && Rs.getString("Departure").equalsIgnoreCase(Departure) && Rs.getString("Arrive").equalsIgnoreCase(Arrive) && Rs.getInt("No_of_person")>No_of_person)
				 {
					 cout.print("<tr>");
					 cout.print("<td>"+Rs.getString("Airlines_Name")+"</td>");
					 cout.print("<td>"+Rs.getString("Flight_Name")+"</td>");
					 cout.print("<td>"+Rs.getString("Departure")+"</td>");
					 cout.print("<td>"+Rs.getString("Arrive")+"</td>");
					 cout.print("<td>"+Rs.getInt("price")+"</td>");
					 cout.print("</tr>");
					 flag=true;
				 }
			 }
			 cout.println("</table>");
			 if(flag)
			 {
				 RequestDispatcher rd = request.getRequestDispatcher("Choose_flight.jsp");
				 rd.include(request, response);  
			 }
			 else
			 {
				 cout.println("No Flights Available");
			 }
		}  
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
}
