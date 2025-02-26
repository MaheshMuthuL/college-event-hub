package servlets;

import java.io.IOException;

import Dao.Userdao;
import database_classes.Login;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServ
 */
@WebServlet("/register")
public class RegisterServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);


		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("Welcome to servlet");
		System.out.println("Servlet running finely");
		String email=request.getParameter("userid");
		String pass=request.getParameter("pass").trim();
		String repass=request.getParameter("repass").trim();
		System.out.println("Datas recieved successfully");
		if(pass.equals(repass)) {
		Login user=new Login();
		System.out.println("login object created");
		user.setEmail(email);
		user.setPass(pass);
		Userdao u=new Userdao();
		System.out.println("dao implements");
		u.save(user);
		response.sendRedirect("index.html");
		return;
	}

}
}
