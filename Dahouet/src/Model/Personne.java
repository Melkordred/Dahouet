package Model;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

// import java.io.Serializable;

public class Personne 
{
	
	 protected String nom, mail, prenom;
		
	public Personne(String nom, String mail, String prenom) 
	{
		super();
		this.nom = nom;
		this.mail = mail;
		this.prenom = prenom;
	}

	public String getNom() 
	{
		return nom;
	}

	public void setNom(String nom) 
	{
		this.nom = nom;
	}

	public String getMail() 
	{
		return mail;
	}

	public void setMail(String mail) 
	{
		this.mail = mail;
	}

	public String getPrenom() 
	{
		return prenom;
	}

	public void setPrenom(String prenom) 
	{
		this.prenom = prenom;
	}

	@Override
	public  String toString() 
	{
		return "Personne [nom=" + nom + ", mail=" + mail + ", prenom=" + prenom
				+ "]";
	}

	
	
	 static final String Email = "^[a-zA-Z0-9._-]{2,}+@[a-zA-Z0-9._-]{2,}\\.[a-z]{2,4}$";
	 static Pattern PatternEmail = Pattern.compile(Email);
	 

	 public static boolean ctlMail(String email) 
	 {
	   Matcher matcher = PatternEmail.matcher(email);
	   return matcher.find();
	  }
	
	public static void affiche(Personne p)
	{
		System.out.println("Personne : "+ p.toString());	
	}
	

}
