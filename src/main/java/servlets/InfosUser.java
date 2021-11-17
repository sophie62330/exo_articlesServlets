package servlets;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Article;
import models.User;

@WebServlet(urlPatterns="/infosUser")
public class InfosUser extends HttpServlet{
	public InfosUser() {
	}
	
	@Override
	protected void doGet(HttpServletRequest requete, HttpServletResponse reponse) 
			throws ServletException,IOException{
		ServletOutputStream out=reponse.getOutputStream();

		HttpSession session = requete.getSession();
		
		User user=(User) session.getAttribute("USER");
		
		out.println("<html>");
		out.println("<body>");
		out.println("username : "+user.getUsername()+"<br>");
		out.println("mail : "+user.getEmail()+"<br>");
		out.println("nb articles  : "+user.getNbArticles()+"<br>");
		out.println("est Administrateur : "+user.getEstAdmin()+"<br>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest requete, HttpServletResponse reponse) 
			throws ServletException,IOException{
		
	}
}
