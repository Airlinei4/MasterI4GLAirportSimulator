package planesAndFlights;

import SystemeGestion.Entite;

public class Ville extends Entite implements IVille {

	public Ville(String name) {
		super(name);
	}

	@Override
	public String getNom() {
		return super.getName();
	}

	@Override
	public void setNom(String nom) {
		super.setName(nom);	
	}

}
