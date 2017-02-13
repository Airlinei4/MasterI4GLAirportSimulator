package planesAndFlights;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import SystemeGestion.Entite;

public class Avion extends Entite implements IAvion {
	private int capacitePassager = 500; 
	private int poids = 12;
	private int largeur = 15;
	private int hauteur = 30;
	private int longueur = 25;
	private boolean isOutConstructor = false;
	
	public Avion (String nom ){
		super(nom);
		isOutConstructor = true;
	}

	@Override
	public String getNom() {
		return super.getName();
	}

	public int getCapacitePassager(){
		return capacitePassager;
	}

	public int getPoids(){  
		return poids;
	}

	public int getLargeur(){
		return largeur;
	}

	public int getHauteur(){
		return hauteur;
	}

	public int getLongueur(){
		return longueur;
	}

	public void setNom(String pNom){
		super.setName(pNom);
	}

	public void setcapacitePassager(int pCapacitePassager) throws Exception{
		if(pCapacitePassager<IAvion.capaciteMinimale){
			throw new Exception("La capacite d'un avion ne peut etre inferieure a "+ IAvion.capaciteMinimale+" passagers");
		}
		capacitePassager=pCapacitePassager;
	}

	public void setPoids(int pPoids) throws Exception{ 
		if(pPoids < IAvion.poidsMinimal){
			throw new Exception("Le poids d'un avion ne peut etre inferieur a "+ IAvion.poidsMinimal+" tonnes");
		}
		poids=pPoids;
	}
	public void setLargeur(int pLargeur) throws Exception{
		if(pLargeur < IAvion.largeurMinimale){
			throw new Exception("La largeur d'un avion ne peut etre inferieure a "+IAvion.largeurMinimale+" metres");
		}
		largeur=pLargeur;
	}
	public void setHauteur(int pHauteur) throws Exception{
		if(pHauteur < IAvion.hauteurMinimale){
			throw new Exception("La hauteur d'un avion ne peut etre inferieure a "+IAvion.hauteurMinimale+" metres");
		}
		hauteur=pHauteur;
	}

	public void setLongueur(int pLongueur) throws Exception{
		if(pLongueur < IAvion.longueurMinimale){
			throw new Exception("La longeur d'un avion ne peut etre inferieure a "+IAvion.longueurMinimale+" metres");
		}
		longueur= pLongueur;
	}
	
	@Override
	public LinkedHashMap<String, String> getAttributesList() {
		// TODO Auto-generated method stub
		LinkedHashMap<String, String> mapAttr = super.getAttributesList();
		mapAttr.put("Capacite de passagers", "int");
		mapAttr.put("Poids (tonnes)", "int");
		mapAttr.put("Largeur (m)", "int");
		mapAttr.put("Hauteur (m)", "int");
		mapAttr.put("Longueur (m)", "int");
		return mapAttr;
	}
	
	@Override
	public void setAttributesList(ArrayList<Object> newList) throws Exception {
		super.setAttributesList(newList);
		if(newList.size()<5){
			throw new Exception("Nombre incorrect d'arguments dans la liste de l'avion");
		}
		if(newList.get(0) instanceof Integer){
			setcapacitePassager((int) newList.get(0));
		}else{
			throw new Exception("La capacite de passagers donnee n'est pas de type entier");
		}
		
		if(newList.get(1) instanceof Integer){
			setPoids((int) newList.get(1));
		}else{
			throw new Exception("Le poids donnee n'est pas de type entier");
		}
		
		if(newList.get(2) instanceof Integer){
			setLargeur((int) newList.get(2));
		}else{
			throw new Exception("La largeur donnee n'est pas de type entier");
		}
		
		if(newList.get(3) instanceof Integer){
			setHauteur((int) newList.get(3));
		}else{
			throw new Exception("La hauteur donnee n'est pas de type entier");
		}
		
		if(newList.get(4) instanceof Integer){
			setLongueur((int) newList.get(4));
		}else{
			throw new Exception("La longueur donnee n'est pas de type entier");
		}
	}
	
	@Override
	public ArrayList<Object> getAttributesValues() {
		ArrayList<Object> listValeurs = super.getAttributesValues();
		if(!isOutConstructor){
			capacitePassager = 500; 
			poids = 12;
			largeur = 15;
			hauteur = 30;
			longueur = 25;
		}
		listValeurs.add(capacitePassager);
		listValeurs.add(poids);
		listValeurs.add(largeur);
		listValeurs.add(hauteur);
		listValeurs.add(longueur);
		return listValeurs;
	}
}