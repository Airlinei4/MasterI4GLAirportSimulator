package airportComponents;

import java.util.ArrayList;
import java.util.Map;

public abstract class Structure {
	private String name;
	
	public Structure(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public abstract Map<String, String> getAttributesList();
	public abstract void setAttributesList(ArrayList<Object> newList) throws Exception;
}
