package airportComponents;

import java.util.ArrayList;
import planesAndFlights.EnumVille;
import planesAndFlights.IVille;
import planesAndFlights.Ville;

public class Aeroport extends Structure {
	private ArrayList<Piste> pistes;
	private ArrayList<Terminal> terminaux;
	private ArrayList<IVille> villes;

	public Aeroport(String name) {
		super(name);
		pistes = new ArrayList<Piste>();
		terminaux = new ArrayList<Terminal>();
		villes = new ArrayList<IVille>();
		for(EnumVille ville : EnumVille.values()){
			villes.add(ville);
		}
	}
	
	public ArrayList<Piste> getPistes() {
		return pistes;
	}
	
	public ArrayList<Terminal> getTerminaux() {
		return terminaux;
	}
	
	public ArrayList<IVille> getVilles() {
		return villes;
	}
	
	public void ajouterPiste() throws Exception {
		Piste piste = new Piste("Piste"+pistes.size());
		 if(!pistes.add(piste)){
			 throw new Exception("Erreur lors de l'ajout de la piste "+piste.getName());
		 }
	}
	
	public void retirerPiste(Piste piste) throws Exception {
		 if(!pistes.remove(piste)){
			 throw new Exception("Erreur lors de la suppression de la piste "+piste.getName());
		 }
	}
	
	public void ajouterVille() throws Exception{
		Ville ville = new Ville("Ville"+villes.size());
		if(!villes.add(ville)){
			 throw new Exception("Erreur lors de l'ajout de la ville "+ville.getName());
		 }
	}
	
	public void retirerVille(IVille ville) throws Exception{
		if(!villes.remove(ville)){
			throw new Exception("Erreur lors de la suppression de la ville "+ville.getNom());
		}
	}
	
	public void ajouterTerminal() throws Exception {
		Terminal terminal = new Terminal("terminal"+terminaux.size());
		 if(!terminaux.add(terminal)){
			 throw new Exception("Erreur lors de l'ajout du terminal "+terminal.getName());
		 }
	}
	
	public void retirerTerminal(Terminal terminal) throws Exception {
		 if(!terminaux.remove(terminal)){
			 throw new Exception("Erreur lors de la suppression du terminal "+terminal.getName());
		 }
	}

}
