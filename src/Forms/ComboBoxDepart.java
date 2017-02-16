package Forms;

import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

import planesAndFlights.IAvion;

public class ComboBoxDepart extends JComboBox<String> {
	private String depart = "Depart";
	private String arrivee = "Arrivee";
	

	public ComboBoxDepart(boolean value) {
		addItem(depart);
		addItem(arrivee);
		if(value){
			setSelectedItem(depart);
		}else{
			setSelectedItem(arrivee);
		}
	}
	
	public Boolean getChoice() {
		String nomSelect = super.getSelectedItem().toString();
		if(nomSelect.equals(depart)){
			return true;
		}else{
			return false;
		}
	}

}
