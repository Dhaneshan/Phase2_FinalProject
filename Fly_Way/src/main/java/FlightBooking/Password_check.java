package FlightBooking;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Password_check")
public class Password_check extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Password_check() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String Current_password=request.getParameter("current_password");
	HttpSession session=request.getSession();
	PrintWriter cout=response.getWriter();
	if(Current_password.equals(session.getAttribute("Admin_password")))
	{
		String New_password=request.getParameter("new_password");
		String Confirm_New_password=request.getParameter("confirm_new_password");
		if(New_password.equals(Confirm_New_password))
		{
			 session.setAttribute("Admin_password", "Confirm_New_password");
			 RequestDispatcher rd = request.getRequestDispatcher("Administrator.jsp");
			 rd.include(request, response);
		}
		else
		{
			cout.print("New passord enter in Confirm Password Field is Wrong");
		}
		
	}
	else
	{
		cout.print("Invalid Admin Password");
	}
	}

	

}
