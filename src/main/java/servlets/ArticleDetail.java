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

@WebServlet(urlPatterns="/articleDetail")
public class ArticleDetail extends HttpServlet{
	public ArticleDetail() {}
	
	@Override
	protected void doGet(HttpServletRequest requete, HttpServletResponse reponse) 
			throws ServletException,IOException{
		

		ServletOutputStream out=reponse.getOutputStream();

		HttpSession session = requete.getSession();
		
		List<Article> articles=(List<Article>) session.getAttribute("articles");
		int indexArticle=Integer.parseInt(requete.getParameter("index"));
		Article article=articles.get(indexArticle);
		
		out.println("<html>");
		out.println("<body>");
		out.println("titre : "+article.getTitre()+"<br>");
		out.println("contenu : "+article.getContenu()+"<br>");
		out.println("utilisateur : "+article.getUser().getUsername()+"<br>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest requete, HttpServletResponse reponse) 
			throws ServletException,IOException{
		
	}
}
