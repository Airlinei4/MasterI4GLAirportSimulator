package planesAndFlights;

import SystemeGestion.Entite;


public class CompagnieAerienne extends Entite implements ICompagnie {
	int nombreDeVol;
	 	   
	//Constructeur
	public CompagnieAerienne(String name){
		super(name);
		//this.nom = nom;
		this.nombreDeVol = 6;

	}
	@Override
	public String getNom(){
		return super.getName();
	}

	public int getNombreDeVol(){
		return nombreDeVol;
	}


	// Setter
	@Override
	public void setNom(String pNom){
		super.setName(pNom);
	}

	public void setnombreDeVol(int pNombreDeVol){
		nombreDeVol=pNombreDeVol;
	}

}
