package airportComponents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JButton;

import Forms.Formulaire;
import planesAndFlights.IAvion;

public class Piste extends PlaneReceiver {
	
	private int largeurMaximale;
	private int poidsMaximal;
	private boolean isDecollage;
	
	public Piste(String name){
		super(name);
		Formulaire formPiste = new Formulaire(getAttributesList());
		
		try {
			setAttributesList(formPiste.getData());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		formPiste.dispose();
		largeurMaximale = 30;
		poidsMaximal = 500;
		isDecollage = false;
	}
	
	@Override
	public LinkedHashMap<String, String> getAttributesList(){
		LinkedHashMap<String, String> myMap = super.getAttributesList();
		myMap.put("Largeur maximale", "int");
		myMap.put("Poids maximal", "int");
		myMap.put("Decollage ?", "boolean");
		myMap.put("Types d'avion supportes", "List IAvion");
		return myMap;
	}
	
	@Override
	public void setAttributesList(ArrayList<Object> newList) throws Exception{
		super.setAttributesList(newList);
		if(newList.size() != 4){
			throw new Exception("Nombre incorrect d'arguments dans la liste de la piste");
		}
		
		if(newList.get(0) instanceof Integer){
			int nb = (Integer) newList.get(0);
			if(nb<10){
				throw new Exception("La largeur maximale ne peut etre inferieure a 10m");
			}
			setLargeurMaximale(nb);
		}else{
			throw new Exception("La largeur maximale donnee n'est pas de type entier");
		}
		
		if(newList.get(1) instanceof Integer){
			int nb = (Integer) newList.get(1);
			if(nb<50){
				throw new Exception("Le poids maximal ne peut etre inferieur a 50 tonnes");
			}
			setPoidsMaximal(nb);
		}else{
			throw new Exception("Le poids maximal donnee n'est pas de type entier");
		}
		
		if(newList.get(2) instanceof Boolean){
			setDecollage((Boolean) newList.get(2));
		}else{
			throw new Exception("La reponse pour le decollage n'est pas de type Booleen");
		}
		
		if(newList.get(3) instanceof ArrayList<?>){
			setPlaneTypes((ArrayList<IAvion>) newList.get(3));
		}else{
			throw new Exception("La reponse pour le decollage n'est pas de type Booleen");
		}
		for(int i=0; i<4; i++){
			newList.remove(i);
		}
	}
	
	public int getLargeurMaximale(){
		return largeurMaximale;
	}
	
	public void setLargeurMaximale(int largeurMaximale) {
		this.largeurMaximale = largeurMaximale;
		ArrayList<IAvion> listPlanes = getPlaneTypes();
		for(IAvion planeType : listPlanes){
			if(planeType.getLargeur() > largeurMaximale){
				removePlaneType(planeType);
			}
		}
	}
	
	public int getPoidsMaximal() {
		return poidsMaximal;
	}
	
	public void setPoidsMaximal(int poidsMaximal) {
		this.poidsMaximal = poidsMaximal;
		ArrayList<IAvion> listPlanes = getPlaneTypes();
		for(IAvion planeType : listPlanes){
			if(planeType.getPoids() > poidsMaximal){
				removePlaneType(planeType);
			}
		}
	}
	
	public boolean getDecollage(){
		return isDecollage;
	}
	
	public void setDecollage(boolean isDecollage) {
		this.isDecollage = isDecollage;
	}
	
	@Override
	public boolean addPlaneType(IAvion planeType) throws Exception {
		if(planeType.getLargeur() > largeurMaximale){
			throw new Exception("Plane is too large for this piste");
		}
		if(planeType.getPoids() > poidsMaximal){
			throw new Exception("Plane is too heavy for this piste");
		}
		return super.addPlaneType(planeType);
	}
}
