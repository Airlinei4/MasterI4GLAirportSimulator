package planesAndFlights;

public enum EnumCompagnie implements ICompagnie {
	Emirates("Dubai"),
	AIRFRANCE("Paris"),
	BRITISHAIRWAYS("Londre"),
	TUNISAIR("Tunis"), 
	AIRALGERIE("Alger"), 
	IBERIA("Espagne");
	
	
	private String nom;
	
	  private EnumCompagnie(String nom) {
		  this.nom = nom;
	  }

	public String getNom() {
		// TODO Auto-generated method stub
		return this.nom;
	}

	@Override
	public void setNom(String nom) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setnombreDeVol(int pNombreDeVol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getNombreDeVol() {
		// TODO Auto-generated method stub
		return 0;
	}

}
