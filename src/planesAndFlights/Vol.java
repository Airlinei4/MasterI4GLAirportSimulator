package planesAndFlights;

import java.util.Date;

import airportComponents.Piste;
import airportComponents.Porte;


public class Vol implements Comparable<Vol>{
	private Date date;
	private boolean isDepart; 
	private int nombrePassagers;
	private IAvion planeType;
	private Piste piste;
	private Porte porte;
	
	public Vol(Date date, boolean isDepart, int nombrePassagers, IAvion planeType){
		this.date = date;
		this.isDepart = isDepart;
		this.nombrePassagers = nombrePassagers;
		this.planeType = planeType;
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
	
	public void setNombrePassagers(int nombrePassagers) {
		this.nombrePassagers = nombrePassagers;
	}
	
	public IAvion getPlaneType(){
		return planeType;
	}
	
	public void setPlaneType(IAvion planeType) {
		this.planeType = planeType;
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
}
