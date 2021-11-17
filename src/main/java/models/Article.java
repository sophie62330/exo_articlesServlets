package models;

public class Article {
	String titre;
	
	String contenu;
	
	User user;

	public Article(String titre, String contenu, User user) {
		super();
		this.titre = titre;
		this.contenu = contenu;
		this.user = user;
		this.user.setNbArticles(this.user.getNbArticles()+1);
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
