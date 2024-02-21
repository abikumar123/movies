package controls;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/validateadminotp")

public class ValidateAdminOTP extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int uotp=Integer.valueOf(req.getParameter("adminotp"));
    	
    	HttpSession session=req.getSession();
    	
    	int otp=(int) session.getAttribute("myotp");
    	
    	if(uotp==otp) {
    		RequestDispatcher rs=req.getRequestDispatcher("AHome.jsp");
    		rs.include(req, resp);
    	}else {
    		req.setAttribute("message","wrong otp try again!");
    		RequestDispatcher rs=req.getRequestDispatcher("alogin.jsp");
    		rs.include(req, resp);
    	}
	}

}
