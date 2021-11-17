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


@WebServlet(urlPatterns="/articles")
public class Articles extends HttpServlet{
	public Articles() {}
	
	@Override
	protected void doGet(HttpServletRequest requete, HttpServletResponse reponse) 
			throws ServletException,IOException{
		

		ServletOutputStream out=reponse.getOutputStream();

		HttpSession session = requete.getSession();
		
		List<Article> articles=(List<Article>) session.getAttribute("articles");
		
		out.println("<html>");
		out.println("<body>");
		out.println("<ul>");
		for (int i=0;i<=articles.size()-1;i++) {
			out.println("<li>"+articles.get(i).getTitre()+
					"<a href='articleDetail?index="+i+"'>voir détail</a></li>");
			
		}
		out.println("</ul>");
		
		out.println("</body>");
		out.println("</html>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest requete, HttpServletResponse reponse) 
			throws ServletException,IOException{
		
	}
}
