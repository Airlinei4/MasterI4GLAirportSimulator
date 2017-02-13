package planesAndFlights;


public class CompagnieAerienne {
	String nom;
	int nombreDeVol;
	 	   
	//Constructeur
	public CompagnieAerienne(String nom){
		this.nom = nom;
		this.nombreDeVol = 6;

	}

	public String getNom(){
		return this.nom;
	}

	public int getNombreDeVol(){
		return nombreDeVol;
	}


	// Setter
	public void setNom(String pNom){
		nom = pNom;
	}

	public void setnombreDeVol(int pNombreDeVol){
		nombreDeVol=pNombreDeVol;
	}

}
