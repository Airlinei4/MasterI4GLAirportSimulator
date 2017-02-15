package airportComponents;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import planesAndFlights.IAvion;
import planesAndFlights.Vol;

public class Piste extends PlaneReceiver {
	
	private int largeurMaximale = IAvion.largeurMinimale;
	private int poidsMaximal = IAvion.poidsMinimal;
	private boolean isDecollage = false;
	private boolean isOutConstructor = false;
	
	public Piste(String name){
		super(name);
		isOutConstructor = true;
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
	public ArrayList<Object> getAttributesValues() {
		if(!isOutConstructor){
			largeurMaximale = IAvion.largeurMinimale;
			poidsMaximal = IAvion.poidsMinimal;
			isDecollage = false;
		}
		ArrayList<Object> listValeurs = super.getAttributesValues();
		listValeurs.add(largeurMaximale);
		listValeurs.add(poidsMaximal);
		listValeurs.add(isDecollage);
		listValeurs.add(getPlaneTypes());
		return listValeurs;
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
	}
	
	public int getLargeurMaximale(){
		return largeurMaximale;
	}
	
	public void setLargeurMaximale(int largeurMaximale) throws Exception {
		if(largeurMaximale < IAvion.largeurMinimale){
			throw new Exception("La largeur de la piste ne peut etre inferieure a "+IAvion.largeurMinimale+" metres");
		}
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
	
	public void setPoidsMaximal(int poidsMaximal) throws Exception {
		if(poidsMaximal < IAvion.poidsMinimal){
			throw new Exception("Le poids supporte par la piste ne peut etre inferieur a "+IAvion.poidsMinimal+" tonnes");
		}
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
	
	@Override
	public boolean isCompatible(Vol vol) {
		// TODO Auto-generated method stub
		return super.isCompatible(vol) && vol.getDepart()==isDecollage;
	}
}
