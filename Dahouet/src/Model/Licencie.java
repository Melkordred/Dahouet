package Model;

import java.util.Date;

public class Licencie extends Personne
{
	private int numeroLicence;
	public static double pointsFFV;
	private Date dateNaissance;
	public static int anneeLicence;

	public Licencie(String nom, String mail, String prenom, int numeroLicence, double pointsFFV, Date dateNaissance, int anneeLicence) 
	{
		super(nom, mail, prenom);
		this.numeroLicence = numeroLicence;
		Licencie.pointsFFV = pointsFFV;
		this.dateNaissance = dateNaissance;
		Licencie.anneeLicence = anneeLicence;
	}

	public int getNumeroLicence() {
		return numeroLicence;
	}

	public void setNumeroLicence(int numeroLicence) {
		this.numeroLicence = numeroLicence;
	}

	public static double getPointsFFV() {
		return pointsFFV;
	}

	public void setPointsFFV(double pointsFFV) {
		Licencie.pointsFFV = pointsFFV;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	public static int getAnneeLicence(){
		return anneeLicence;
	}
	
	public void setAnneeLicence(int anneeLicence) {
		Licencie.anneeLicence = anneeLicence;
	}

	@Override
	public String toString() {
		return "Licencie [numeroLicence=" + numeroLicence + ", pointsFFV="
				+ pointsFFV + ", dateNaissance=" + dateNaissance + ", nom="
				+ nom + ", mail=" + mail + ", prenom=" + prenom + "]";
	}
	
	 
	 public static double calculPoints(int point, String dat) throws Exception
	 {
		String annee = dat.substring(0,4);
		int i;
		
		i = Integer.parseInt(annee);	 
		
			if(i == anneeLicence)		pointsFFV = point + getPointsFFV();
			
			else throw new Exception();
	 
		return pointsFFV;
	 }
	
	 public void affiche()
		{
			System.out.println("Licencie : " + super.toString());	
		}
		
	
	
	
}
