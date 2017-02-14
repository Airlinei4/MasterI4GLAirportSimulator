package airportComponents;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import SystemeGestion.BoutonAjout;
import SystemeGestion.WrapLayout;
import planesAndFlights.IAvion;


public class Terminal extends Structure {

	private int nombreMaxPassagers = IAvion.capaciteMinimale;
	private ArrayList<Porte> myporte = new ArrayList<Porte>();
	private boolean isOutConstructor = false;
	
	public Terminal(String name){
		super(name);
		isOutConstructor = true;
	}
	
	public void setNombresPassagers(int passagers) throws Exception{
		if(passagers < IAvion.capaciteMinimale){
			throw new Exception("La capacité maximale d'un terminal ne peut etre inferieure a "+IAvion.capaciteMinimale+" personnes");
		}
		this.nombreMaxPassagers = passagers;
	}
	
	public ArrayList<Porte> getPortes(){
		return myporte;
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

	@Override
	public LinkedHashMap<String, String> getAttributesList() {
		LinkedHashMap<String, String> myMap = super.getAttributesList();
		if(!isOutConstructor){
			nombreMaxPassagers = IAvion.capaciteMinimale;
		}
		myMap.put("Nombre max de passagers", "int");
		return myMap;
	}
	
	@Override
	public ArrayList<Object> getAttributesValues() {
		// TODO Auto-generated method stub
		ArrayList<Object> listValeur = super.getAttributesValues();
		listValeur.add(nombreMaxPassagers);
		return listValeur;
	}

	@Override
	public void setAttributesList(ArrayList<Object> newList) throws Exception {
		super.setAttributesList(newList);
		if(newList.size() < 1){
			throw new Exception("Nombre incorrect d'arguments dans la liste du terminal");
		}
		if(newList.get(0) instanceof Integer){
			setNombresPassagers((Integer) newList.get(0));
		}else{
			throw new Exception("La capacité maximale du terminal donnee n'est pas de type entier");
		}
	}
	
	@Override
	public JPanel getDisplay(){
		displayComponent = new JPanel(new WrapLayout());
		displayComponent.setBorder(BorderFactory.createLineBorder(Color.black));
		JButton button = new JButton(this.getName());
		button.addMouseListener(this);
		displayComponent.add(button);
		displayComponent.add(new BoutonAjout("Porte","Ajouter une porte d'embarquement",myporte,displayComponent));
		displayComponent.revalidate();
		displayComponent.setSize(269, 75);
		return displayComponent;
	}
}
