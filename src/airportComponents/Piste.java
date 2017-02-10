package airportComponents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import planesAndFlights.IAvion;

public class Piste extends PlaneReceiver {
	
	private int largeurMaximale;
	private int poidsMaximal;
	private boolean isDecollage;
	
	public Piste(String name){
		super(name);
		largeurMaximale = 30;
		poidsMaximal = 500;
		isDecollage = false;
	}
	
	@Override
	public Map<String, String> getAttributesList(){
		Map<String, String> myMap = new HashMap<String, String>();
		myMap.put("Nom", "String");
		myMap.put("Largeur maximale", "int");
		myMap.put("Poids maximal", "int");
		myMap.put("Decollage ?", "boolean");
		myMap.put("Types d'avion supportes", "List IAvion");
		return myMap;
	}
	
	@Override
	public void setAttributesList(ArrayList<Object> newList) throws Exception{
		if(newList.size() != 5){
			throw new Exception("Nombre incorrect d'arguments dans la liste de la piste");
		}
		if(newList.get(0) instanceof String){
			setName((String) newList.get(0));
		}else{
			throw new Exception("name in list isn't String");
		}
		
		if(newList.get(1) instanceof Integer){
			int nb = (Integer) newList.get(1);
			if(nb<10){
				throw new Exception("La largeur maximale ne peut etre inferieure a 10m");
			}
			setLargeurMaximale(nb);
		}else{
			throw new Exception("La largeur maximale donnee n'est pas de type entier");
		}
		
		if(newList.get(2) instanceof Integer){
			int nb = (Integer) newList.get(2);
			if(nb<50){
				throw new Exception("Le poids maximal ne peut etre inferieur a 50 tonnes");
			}
			setPoidsMaximal(nb);
		}else{
			throw new Exception("Le poids maximal donnee n'est pas de type entier");
		}
		
		if(newList.get(3) instanceof Boolean){
			setDecollage((Boolean) newList.get(3));
		}else{
			throw new Exception("La reponse pour le decollage n'est pas de type Booleen");
		}
		
		if(newList.get(4) instanceof ArrayList<?>){
			setPlaneTypes((ArrayList<IAvion>) newList.get(4));
		}else{
			throw new Exception("La reponse pour le decollage n'est pas de type Booleen");
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
