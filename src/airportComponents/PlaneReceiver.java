package airportComponents;

import java.util.ArrayList;

import planesAndFlights.IAvion;
import planesAndFlights.Vol;

public abstract class PlaneReceiver extends Structure {

	private ArrayList<IAvion> planeTypes;
	
	private Vol vol;
	
	public PlaneReceiver(String name) {
		super(name);
		planeTypes = new ArrayList<IAvion>();
		vol = null;
	}
	
	public Vol getVol() {
		return vol;
	}
	
	protected void setVol(Vol newVol) throws Exception{
		if(newVol != null && vol!= null){
			throw new Exception("vol is already busy");
		}
		vol = newVol;
	}
	
	protected ArrayList<IAvion> getPlaneTypes() {
		return planeTypes;
	}
	
	protected void setPlaneTypes(ArrayList<IAvion> planeTypes) throws Exception {
		for(IAvion avion : planeTypes){
			addPlaneType(avion);
		}
	}

	public boolean addPlaneType(IAvion planeType) throws Exception{
		return planeTypes.add(planeType);
	}
	
	public boolean removePlaneType(IAvion planeType){
		return planeTypes.remove(planeType);
	}
	
	boolean isPlaneTypeSupported(IAvion iAvion){
		return planeTypes.contains(iAvion);
	}
	
	public boolean isCompatible(Vol vol){
		//check plane type and if structure isn't busy
		return isPlaneTypeSupported(vol.getPlaneType()) && (vol == null);
	}
	
	public void take(Vol vol) throws Exception{
		if(!isPlaneTypeSupported(vol.getPlaneType())){
			throw new Exception("This Plane Type isn't supported");
		}
		setVol(vol);
	}
	
	public void release(Vol vol) throws Exception{
		setVol(vol);
	}

}
