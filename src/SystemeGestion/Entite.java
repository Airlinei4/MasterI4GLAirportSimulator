package SystemeGestion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Entite {
	private String name;

	public Entite(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public LinkedHashMap<String, String> getAttributesList(){
		LinkedHashMap<String, String> myMap = new LinkedHashMap<String, String>();
		myMap.put("Nom", "String");
		return myMap;
	}
	
	public void setAttributesList(ArrayList<Object> newList) throws Exception{
		if(newList.size() < 1){
			throw new Exception("Nombre incorrect d'arguments dans la liste");
		}
		if(newList.get(0) instanceof String){
			setName((String) newList.get(0));
			newList.remove(0);
		}else{
			throw new Exception("name in list isn't String");
		}
	}
}
