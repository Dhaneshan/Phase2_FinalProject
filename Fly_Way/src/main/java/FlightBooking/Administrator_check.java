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
@WebServlet("/Administrator_Check")
public class Administrator_check extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Administrator_check() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter cout=response.getWriter();
		String Admin_name=request.getParameter("adminname");
		String Admin_password=request.getParameter("adminpassword");
		String Original_password="Dhaneshan@2001";
		HttpSession session=request.getSession();
		session.setAttribute("Admin_name", Admin_name);
		session.setAttribute("Admin_password", Original_password);
		if(Admin_name.equalsIgnoreCase("Dhaneshan") && Admin_password.equals(session.getAttribute("Admin_password")))
		{
			
			 RequestDispatcher rd = request.getRequestDispatcher("Administrator_page.jsp");
			 rd.include(request, response);  
		}
	   else
		 {
			 cout.println("Invalid Username And Password");
		 }
	}


}
