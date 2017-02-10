package airportComponents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import planesAndFlights.IAvion;

public class Porte extends PlaneReceiver {
	private int largeurMax;
	
	public Porte(String name){
		super(name);
		largeurMax = 30;
	}
	
	public int getLargeurMax() {
		return largeurMax;
	}
	
	public void setLargeurMax(int largeurMax) {
		this.largeurMax = largeurMax;
		ArrayList<IAvion> listPlanes = getPlaneTypes();
		for(IAvion planeType : listPlanes){
			if(planeType.getLargeur() > largeurMax){
				removePlaneType(planeType);
			}
		}
	}
	
	public int getNombrePassagers(){
		return getVol().getPlaneType().getCapacitePassager();
	}

	@Override
	public boolean addPlaneType(IAvion planeType) throws Exception {
		if(planeType.getLargeur() > largeurMax){
			throw new Exception("L'avion est trop large pour la porte");
		}
		return super.addPlaneType(planeType);
	}
	
	@Override
	public Map<String, String> getAttributesList() {
		Map<String, String> myMap = new HashMap<String, String>();
		myMap.put("Nom", "String");
		myMap.put("Largeur maximale", "int");
		myMap.put("Types d'avion supportes", "List IAvion");
		return myMap;
	}

	@Override
	public void setAttributesList(ArrayList<Object> newList) throws Exception {
		if(newList.size() != 3){
			throw new Exception("Nombre incorrect d'arguments dans la liste de la porte");
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
			setLargeurMax(nb);
		}else{
			throw new Exception("La largeur maximale donnee n'est pas de type entier");
		}
		
		if(newList.get(2) instanceof ArrayList<?>){
			setPlaneTypes((ArrayList<IAvion>) newList.get(2));
		}else{
			throw new Exception("La liste donnee ne contient pas de liste d'avion supportes");
		}
		
	}

}
