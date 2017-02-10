package planesAndFlights;

public enum EnumAvion implements IAvion {
	A330("A330",440,60,64,17,185), 
	A318("A318",107,34,31,13,57),
	A200("A200",246,44,47,16,122), 
	Boeing727("Boeing727",189,33,41,10,70) ,
	Boeing307("Boeing307",50,29,36,11,56);

	  private int capacitePassager ;
	  private String nom;
	  private int poids;
	  private int largeur;
	  private int hauteur;
	  private int longueur; 
	   
	  //Constructeur
	    private EnumAvion(String nom, int capacitePassager,int largeur, int longueur, int hauteur,int poids)
	    {
	    	this.nom = nom;
	    	this.capacitePassager = capacitePassager;
	    	this.poids= poids;
	    	this.largeur=largeur ;
	    	this.hauteur= hauteur;
	    	this.longueur= longueur;
	    }
	    
	    public String getNom(){
	    	return this.nom;
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

		public void setNom(String pNom) {
			// TODO Auto-generated method stub
			
		}

		public void setcapacitePassager(int pCapacitePassager) {
			// TODO Auto-generated method stub
			
		}

		public void setPoids(int pPoids) {
			// TODO Auto-generated method stub
			
		}

		public void setLargeur(int pLargeur) {
			// TODO Auto-generated method stub
			
		}

		public void setHauteur(int pHauteur) {
			// TODO Auto-generated method stub
			
		}

		public void setLongueur(int pLongueur) {
			// TODO Auto-generated method stub
			
		}
	   
    }

