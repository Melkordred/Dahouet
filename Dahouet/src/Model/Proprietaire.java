package Model;

public class Proprietaire extends Personne 
{
	private String telephone, adresse;

	public Proprietaire(String nom, String mail, String prenom, String telephone,String adresse) 
	{
		super(nom, mail, prenom);
		this.telephone = telephone;
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Proprietaire [telephone=" + telephone + ", adresse=" + adresse
				+ ", nom=" + nom + ", mail=" + mail + ", prenom=" + prenom
				+ "]";
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public void affiche()
	{
		System.out.println("Proprietaire : " + super.toString());	
	}
	
}
