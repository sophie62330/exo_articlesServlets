package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
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

@WebServlet(urlPatterns={"/Accueil"})
public class Accueil extends HttpServlet{

	public Accueil() {}
	
	@Override
	protected void doGet(HttpServletRequest requete, HttpServletResponse reponse) 
			throws ServletException,IOException{
		ServletOutputStream out=reponse.getOutputStream();
		
		User toto=new User("toto","toto@gmail.com",false);
		Article article1=new Article("article1","contenu article 1",toto);
		Article article2=new Article("article2","contenu article 2",toto);
		List<Article> listeArticles=new ArrayList<Article>();
		listeArticles.add(article1);
		listeArticles.add(article2);
		
		HttpSession session = requete.getSession();
		session.setAttribute("articles", listeArticles);
		session.setAttribute("USER", toto);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<p> <a href='infosUser'>Vers mes infos de profil :</a></p>");
		out.println("<p> <a href='articles'>Vers les articles :</a></p>");
		
		//if (toto.getEstAdmin()) {
			out.println("<p><a href='admin'>Compte admin</p>");
		//}
		out.println("</body>");
		out.println("</html>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest requete, HttpServletResponse reponse) 
			throws ServletException,IOException{
		
	}
}
