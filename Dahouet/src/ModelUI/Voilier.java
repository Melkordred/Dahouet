package ModelUI;

public class Voilier 
{
	protected int Num_voile, Num_proprietaire;
	protected String Nom_classe, Nom_voilier;
	
	
	public Voilier(int num_voile, int num_proprietaire, String nom_classe,
			String nom_voilier) 
	{
		super();
		Num_voile = num_voile;
		Num_proprietaire = num_proprietaire;
		Nom_classe = nom_classe;
		Nom_voilier = nom_voilier;
	}


	public int getNum_voile() {
		return Num_voile;
	}

	public void setNum_voile(int num_voile) {
		Num_voile = num_voile;
	}

	public int getNum_proprietaire() {
		return Num_proprietaire;
	}

	public void setNum_proprietaire(int num_proprietaire) {
		Num_proprietaire = num_proprietaire;
	}

	public String getNom_classe() {
		return Nom_classe;
	}

	public void setNom_classe(String nom_classe) {
		Nom_classe = nom_classe;
	}

	public String getNom_voilier() {
		return Nom_voilier;
	}

	public void setNom_voilier(String nom_voilier) {
		Nom_voilier = nom_voilier;
	}
	
	
	
	

}
