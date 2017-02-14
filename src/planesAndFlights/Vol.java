package planesAndFlights;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;

import SystemeGestion.Entite;
import airportComponents.Piste;
import airportComponents.Porte;
import airportComponents.Terminal;


public class Vol extends Entite implements Comparable<Vol>{
	private Date dateDebut;
	private Date dateFin;
	private boolean isDepart; 
	private int nombrePassagers;
	private IAvion planeType;
	private Terminal terminal;
	private Piste piste;
	private Porte porte;
	private boolean isOutConstructor = false;
	private boolean isAffected;
	private boolean isEnCours;
	
	public Vol(String nom){
		super(nom);
		setAffected(false);
		setEnCours(false);
		isOutConstructor = true;
	}
	
	public Date getDateDebut() {
		return dateDebut;
	}
	
	public Date getDateFin() {
		return dateFin;
	}
	
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	
	public void setDateFin(Date dateFin) throws Exception {
		if(dateFin.before(dateDebut)){
			throw new Exception("La date de fin ne peut être anterieure a la date de debut du vol");
		}
		this.dateFin = dateFin;
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
		setEnCours(false);
		setAffected(true);
		this.piste = piste;
		this.porte = porte;
	}
	
	public void release(){
		setEnCours(false);
		setAffected(false);
		piste = null;
		porte = null;
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
		return dateDebut.compareTo(o.getDateDebut());
	}
	
	public boolean compatible(Date _date){
		if(_date.before(dateDebut)){
			return false;
		}else if (_date.after(dateFin)) {
			return false;
		}else{
			setEnCours(true);
			return true;
		}
	}
	
	

	@Override
	public LinkedHashMap<String, String> getAttributesList() {
		LinkedHashMap<String, String> mapAttributes = super.getAttributesList();
		mapAttributes.put("Date de debut", "Date");
		mapAttributes.put("Date de fin", "Date");
		mapAttributes.put("Depart", "boolean");
		mapAttributes.put("Modele d'avion", "IAvion");
		mapAttributes.put("Nombre de passagers", "int");
		return mapAttributes;
	}

	@Override
	public void setAttributesList(ArrayList<Object> newList) throws Exception {
		super.setAttributesList(newList);
		if(newList.size() < 5){
			throw new Exception("Nombre incorrect d'arguments dans la liste du vol");
		}
		
		if(newList.get(0) instanceof Date){
			setDateDebut((Date) newList.get(0));
		}else{
			throw new Exception("La date donnee n'est pas de type Date");
		}
		
		if(newList.get(1) instanceof Date){
			setDateFin((Date) newList.get(1));
		}else{
			throw new Exception("La date donnee n'est pas de type Date");
		}
		
		if(newList.get(2) instanceof Boolean){
			setDepart((boolean) newList.get(2));
		}else{
			throw new Exception("Le depart donne n'est pas de type booleen");
		}
		
		if(newList.get(3) instanceof IAvion){
			setPlaneType((IAvion) newList.get(3));
		}else{
			throw new Exception("Le modele d'avion donne n'est pas de type Avion");
		}
		
		if(newList.get(4) instanceof Integer){
			setNombrePassagers((int) newList.get(4));
		}else{
			throw new Exception("Le nombre de passagers donne n'est pas de type entier");
		}
	}
	
	@Override
	public ArrayList<Object> getAttributesValues() {
		if(!isOutConstructor){
			dateDebut = Calendar.getInstance().getTime();
			dateFin = Calendar.getInstance().getTime();
			dateFin.setMinutes(dateDebut.getMinutes()+10);
			isDepart = true;
			planeType = EnumAvion.A200;
			nombrePassagers = planeType.getCapacitePassager();
		}
		ArrayList<Object> listValeurs = super.getAttributesValues();
		listValeurs.add(dateDebut);
		listValeurs.add(dateFin);
		listValeurs.add(isDepart);
		listValeurs.add(planeType);
		listValeurs.add(nombrePassagers);
		return listValeurs;
	}

	public boolean isAffected() {
		return isAffected;
	}

	private void setAffected(boolean isAffected) {
		this.isAffected = isAffected;
	}

	public boolean isEnCours() {
		return isEnCours;
	}

	private void setEnCours(boolean isEnCours) {
		this.isEnCours = isEnCours;
	}
	
	public String getStringType(){
		if(isDepart){
			return "aterrissage";
		}else{
			return "decollage";
		}
	}
}
