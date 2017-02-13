package airportComponents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

import SystemeGestion.BoutonAjout;


public class Terminal extends Structure {

	private int nombreMaxPassagers;
	private ArrayList<Porte> myporte;
	
	public Terminal(String name){
		super(name);
		this.myporte = new ArrayList<Porte>();
	}
	
	public void setNombresPassagers(int passagers){
		this.nombreMaxPassagers = passagers;
	}
	
	public void ajouterPorte(Porte p){
		this.myporte.add(p);//return boolean or launch exception if it's false
	}
	
	public boolean removePorte(Porte p){
		return myporte.remove(p);
	}
	
	public boolean isCapacityOver(){
		int nombrePassagers=0;
		for(Porte p:myporte){
			if(p.getVol() != null){
				nombrePassagers+=p.getNombrePassagers();
				if (nombrePassagers >= nombreMaxPassagers){
					return true;
				}		
			}
		}
		return false; 
	}
	
	private void setMyporte(ArrayList<Porte> myporte) {
		for(Porte porte : myporte){
			ajouterPorte(porte);
		}
	}

	@Override
	public LinkedHashMap<String, String> getAttributesList() {
		LinkedHashMap<String, String> myMap = super.getAttributesList();
		myMap.put("Nom", "String");
		myMap.put("Nombre max de passagers", "int");
		myMap.put("Portes d'embarquement", "List Porte");
		return myMap;
	}

	@Override
	public void setAttributesList(ArrayList<Object> newList) throws Exception {
		if(newList.size() != 3){
			throw new Exception("Nombre incorrect d'arguments dans la liste du terminal");
		}
		if(newList.get(0) instanceof String){
			setName((String) newList.get(0));
		}else{
			throw new Exception("name in list isn't String");
		}
		
		if(newList.get(1) instanceof Integer){
			int nb = (Integer) newList.get(1);
			if(nb<50){
				throw new Exception("La capacité maximale d'un terminal ne peut etre inferieure a 50 personnes");
			}
			setNombresPassagers(nb);
		}else{
			throw new Exception("La capacité maximale du terminal donnee n'est pas de type entier");
		}
		
		if(newList.get(2) instanceof ArrayList<?>){
			setMyporte((ArrayList<Porte>) newList.get(2));
		}else{
			throw new Exception("La liste donnée ne contient pas de liste de portes");
		}
	}
	
	@Override
	public JPanel getDisplay(){
		displayComponent = new JPanel();
		JButton button = new JButton(this.getName());
		button.addMouseListener(this);
		displayComponent.add(button);
		displayComponent.add(new BoutonAjout("Porte","Ajouter une porte d'embarquement",myporte,displayComponent));
		return displayComponent;
	}
}
