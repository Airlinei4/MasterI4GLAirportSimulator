package planesAndFlights;

public interface IAvion {
	int largeurMinimale = 25;
	int hauteurMinimale = 10;
	int longueurMinimale = 30;
	int poidsMinimal = 50;
	int capaciteMinimale = 50;
	/// Getter
		public String getNom();
		public int getCapacitePassager();
		public int getPoids();
		public int getLargeur();
		public int getHauteur();
		public int getLongueur();
	 
	// Setter
		public void setNom(String pNom);
		public void setcapacitePassager(int pCapacitePassager) throws Exception;
		public void setPoids(int pPoids) throws Exception;
		public void setLargeur(int pLargeur)throws Exception;
		public void setHauteur(int pHauteur)throws Exception;
		public void setLongueur(int pLongueur)throws Exception;

	}


