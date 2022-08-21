package FlightBooking;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Show_details")
public class Show_details extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Show_details() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter cout = response.getWriter();
		String Password=request.getParameter("password");
		String Confirm_Password=request.getParameter("cpassword");
		if(Password.equals(Confirm_Password))
		{
			 RequestDispatcher rd = request.getRequestDispatcher("cash.jsp");
			 rd.include(request, response);
		}
		else
		{
		 cout.println("Invalid Username or Password");
		}
	}


}
