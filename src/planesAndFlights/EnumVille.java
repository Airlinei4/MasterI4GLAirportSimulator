package planesAndFlights;

public enum EnumVille implements IVille {
	PARIS("Paris"),
	BERLIN("Berlin"),
	LONDRES("Londres"),
	MADRID("Madrid"),
	ROME("Rome"),
	NEWYORK("New York"),
	LOSANGELES("Los Angeles");
	

	  private String nom;
	   
	  //Constructeur
	  private EnumVille(String nom) {
		  this.nom = nom;
	  }

	  public String getNom(){
		  return this.nom;
	  }

	@Override
	public void setNom(String nom) {
		
	}

}
