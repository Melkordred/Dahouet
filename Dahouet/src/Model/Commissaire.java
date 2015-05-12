package Model;

public class Commissaire extends Personne
{
	
	private String comite;
	
	public Commissaire(String nom, String mail, String prenom, String comite) 
	{
		super(nom, mail, prenom);
		this.comite = comite;
	}

	public String getComite() {
		return comite;
	}

	public void setComite(String comite) {
		this.comite = comite;
	}

	@Override
	public String toString() {
		return "Commissaire [comite=" + comite + ", nom=" + nom + ", mail="
				+ mail + ", prenom=" + prenom + "]";
	}

	public void affiche()
	{
		System.out.println("Commissaire : " + super.toString());	
	}
	
	
	
	
	

}
