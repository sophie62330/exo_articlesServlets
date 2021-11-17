package models;


public class User {
	String username;
	
	String email;
	
	boolean estAdmin;
	
	private int nbArticles;

	public User(String username, String email, boolean estAdmin) {
		super();
		this.username = username;
		this.email = email;
		this.estAdmin = estAdmin;
		this.nbArticles=0;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

	public int getNbArticles() {
		return nbArticles;
	}

	public void setNbArticles(int nbArticles) {
		this.nbArticles = nbArticles;
	}

	public void setEstAdmin(boolean estAdmin) {
		this.estAdmin = estAdmin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getEstAdmin() {
		return this.estAdmin;
	}

	public void setRole(boolean estAdmin) {
		this.estAdmin = estAdmin;
	}
	
	
}
