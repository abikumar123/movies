package controls;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import dto.Admin;
import dto.Movie;
@WebServlet("/alogin")
public class AdminLogin extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mail=req.getParameter("mail");
		String password=req.getParameter("password");
		
		Dao dao=new Dao();
		try {
			Admin admin=dao.findByEmailAdmin(mail);
			
			
			if(admin!=null) {
				if(password.equals(admin.getAdminpassword())) {
					HttpSession session=req.getSession();
					session.setAttribute("adminname", admin.getAdminname());
					
					List<Movie> movies=dao.getallmovies();
					session.setAttribute("movies", movies);
					RequestDispatcher rd=req.getRequestDispatcher("generateadminOTP");
					rd.include(req, resp);
					
					
				}else {
					
					
					req.setAttribute("message","password mismatch try again!");
					RequestDispatcher rd=req.getRequestDispatcher("alogin.jsp");
					rd.include(req, resp);
				}
			}else {
				req.setAttribute("message","e-mail id is mismatch try again!");
				RequestDispatcher rd=req.getRequestDispatcher("alogin.jsp");
				rd.include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException  e) {
			
			e.printStackTrace();
			
		}
		
	}

}
