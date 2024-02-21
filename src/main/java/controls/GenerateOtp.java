package controls;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
@WebServlet("/otp")

public class GenerateOtp extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int l=6;
		
		StringBuffer sb = new StringBuffer();
		while (l > 0) {
			int x = (int) Math.floor(Math.random() * 10);
			sb.append(x);
			l--;
		}
		int otp = Integer.valueOf(sb.toString());
		req.setAttribute("otp", otp);
		
		HttpSession session=req.getSession();
		session.setAttribute("myotp", otp);
		
		
		RequestDispatcher rs=req.getRequestDispatcher("validateOTP.jsp");
		rs.include(req, resp);
	}

}
