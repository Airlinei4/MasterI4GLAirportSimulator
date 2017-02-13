package planesAndFlights;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import airportComponents.Piste;
import airportComponents.Porte;
import airportComponents.Structure;


public class Vol extends Structure implements Comparable<Vol>{
	private Date date;
	private boolean isDepart; 
	private int nombrePassagers;
	private IAvion planeType;
	private Piste piste;
	private Porte porte;
	
	public Vol(String nom){
		super(nom);
		this.date = Calendar.getInstance().getTime();
		this.isDepart = true;
		this.planeType = EnumAvion.A200;
		this.nombrePassagers = planeType.getCapacitePassager();
	}
	
	public Date getDate(){
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public boolean getDepart(){
		return isDepart;
	}
	
	public void setDepart(boolean isDepart) {
		this.isDepart = isDepart;
	}
	
	public int getNombrePassagers(){
		return nombrePassagers;
	}
	
	public void setNombrePassagers(int nombrePassagers) throws Exception {
		if(nombrePassagers>planeType.getCapacitePassager()){
			throw new Exception("Le nombre de passagers ne peut pas etre superieur a la capacite de l'avion : "+planeType.getCapacitePassager());
		}
		this.nombrePassagers = nombrePassagers;
	}
	
	public IAvion getPlaneType(){
		return planeType;
	}
	
	public void setPlaneType(IAvion planeType) {
		this.planeType = planeType;
		if(nombrePassagers > planeType.getCapacitePassager()){
			nombrePassagers = planeType.getCapacitePassager();
		}
	}
	
	public void affect(Piste piste, Porte porte){
		this.piste = piste;
		this.porte = porte;
	}
	
	public Piste getPiste() {
		return piste;
	}
	
	public void setPiste(Piste piste) {
		this.piste = piste;
	}
	
	public Porte getPorte() {
		return porte;
	}
	
	public void setPorte(Porte porte) {
		this.porte = porte;
	}

	@Override
	public int compareTo(Vol o) {
		return date.compareTo(o.getDate());
	}

	@Override
	public LinkedHashMap<String, String> getAttributesList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAttributesList(ArrayList<Object> newList) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
