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
import dto.User;

@WebServlet("/ulogin")

public class UserLogin extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String mail=req.getParameter("mail");
		String password=req.getParameter("password");
		
		Dao dao=new Dao();
		
		try {
			User user=dao.findByEmailUser(mail);
			if(user!=null) {
				if(password.equals(user.getUserpassword())){
					
					HttpSession session=req.getSession();
					session.setAttribute("user", user);
					
					session.setAttribute("movies", dao.getallmovies());
					
					RequestDispatcher rd=req.getRequestDispatcher("UHome.jsp");
					rd.include(req, resp);
				}else {
					
					
					req.setAttribute("message","password mismatch try again!");
					RequestDispatcher rd=req.getRequestDispatcher("ulogin.jsp");
					rd.include(req, resp);
				}
			}else {
				req.setAttribute("message","e-mail id is mismatch try again!");
				RequestDispatcher rd=req.getRequestDispatcher("ulogin.jsp");
				rd.include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
