package planesAndFlights;


public class Avion implements IAvion {
	String nom;
	int capacitePassager; 
	int poids;
	int largeur;
	int hauteur;
	int longueur; 
	
	public Avion (String nom )
	{
	this.nom= nom;
	this.capacitePassager= 500;
	this.poids= 12;
	this.largeur= 15;
	this.hauteur= 30;
	this.longueur= 25;
	}
	
/// Getter
	public String getNom()  {  
		    return nom;
		  }

	public int getCapacitePassager()
		  {
		    return capacitePassager;
		  }
	public int getPoids()  {  
	    return poids;
	  }
	public int getLargeur()
	  {
	    return largeur;
	  }
	public int getHauteur()
	  {
	    return hauteur;
	  }
	public int getLongueur()
	  {
	    return longueur;
	  }
		 
// Setter
	public void setNom(String pNom)
		  {
		    nom = pNom;
		  }
	
	public void setcapacitePassager(int pCapacitePassager)
	  {
	    capacitePassager=pCapacitePassager;
	  }
	public void setPoids(int pPoids)
	{  
		poids=pPoids;
	}
	public void setLargeur(int pLargeur)
	{
		largeur=pLargeur;
	}
	public void setHauteur(int pHauteur)
	{
		hauteur=pHauteur;
	}
	public void setLongueur(int pLongueur)
	{
		longueur= pLongueur;
	}

}