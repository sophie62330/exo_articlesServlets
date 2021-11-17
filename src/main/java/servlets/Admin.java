package servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.User;

@WebServlet(urlPatterns="/admin")
public class Admin extends HttpServlet{
	public Admin() {
	}
	
	@Override
	protected void doGet(HttpServletRequest requete, HttpServletResponse reponse) 
			throws ServletException,IOException{
		ServletOutputStream out=reponse.getOutputStream();

		HttpSession session = requete.getSession();
		
		User user=(User) session.getAttribute("USER");
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Bonjour "+user.getUsername()+", bienvenue sur votre compte admin</h1>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest requete, HttpServletResponse reponse) 
			throws ServletException,IOException{
		
	}
}
