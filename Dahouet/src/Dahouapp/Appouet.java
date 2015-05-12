package Dahouapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Model.Commissaire;
import Model.Licencie;
import Model.Lire;
import Model.Personne;
import Model.Proprietaire;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Appouet 
{

	public static void main(String[] args) 
	{	
		//ce main m'a uniquement servi à tester les fonctions demandées
		
			//	Licencie.ageLicencie(1988,9,01);
				
			boolean bool;
			String naissance;
		
			do
			{
	        	System.out.println("Entrez la date de naissance");
	     		naissance = Lire.S();
				
	     		bool = isValidDate(naissance);
		
			}while(bool==true);
			
				Licencie.pointsFFV = 2;
				Licencie.anneeLicence = 1985;
				
				double points = Licencie.pointsFFV;
				
				try 
				{
					points = Licencie.calculPoints(5,"1985/09/01");
				} 
				catch(java.lang.Exception e) 
				{
					System.out.println("L'année entrée doit être égale à l'année de licence pour mettre à jour les points");
				}
				
				System.out.println("points:" + points);
				
				Personne p = new Personne ("Glouglou","dindouet@gmail.com","l'Dindon") ;
				Personne.affiche(p);
				
				Proprietaire prop = new Proprietaire("ouzou","dindouet@gmail.com","l'Dindon","353543543","14 rue des glouglous");
				Personne.affiche(prop);
				
				Commissaire comm = new Commissaire("Suprême","jury.dinde@labassecour.fr","GlouGlou","BasseCours");
				Personne.affiche(comm);
				
				Proprietaire.affiche(prop);
				
			//	naissance = "^(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$";
				 
				
				
				 
				SimpleDateFormat naiss = new SimpleDateFormat("yyyy/MM/dd");
				
				try 
				{
					Date d = naiss.parse(naissance);
					isValidDate(naissance);
					int age = getYears(d);
					System.out.println(age);
				} 
				catch (ParseException e) 
				{
				    // TODO Auto-generated catch block
				//	e.printStackTrace();
					System.out.println("Format de date incorrect yyyy/mm/jj svp");
				}

	}
	
	public static int getYears(Date d)
	{
	  Calendar curr = Calendar.getInstance();
	  Calendar birth = Calendar.getInstance();
	  birth.setTime(d);
	  int yeardiff = curr.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
	  curr.add(Calendar.YEAR,-yeardiff);
	  if(birth.after(curr))
	  {
	    yeardiff = yeardiff - 1;
	  }
	  return yeardiff;
	} 
	
	 static final String dateNaiss= "^(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$";
	 static Pattern patternDate = Pattern.compile(dateNaiss);
	 
	 static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	 
	 
	 public static boolean isValidDate(String date)
	 {	 
		 Matcher matcher = patternDate.matcher(dateNaiss);
		 return matcher.find();
	 }
	
	 
	 
	

}
