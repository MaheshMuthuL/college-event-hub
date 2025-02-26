package servlets;

import java.io.IOException;

import Dao.Userdao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("userid");
		String pass=request.getParameter("pass");
		Userdao dao=new Userdao();
		boolean result=dao.logincheck(email, pass);
		if(!result) {
			response.sendRedirect("Login.jsp");
		    return;
		}
		HttpSession session=request.getSession();
		session.setAttribute("user",email);
		request.getRequestDispatcher("Home.html").forward(request, response);		
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
}