package Forms;

import java.awt.List;
import java.util.ArrayList;

import javax.swing.JComboBox;

import SystemeGestion.Fenetre;
import planesAndFlights.IAvion;

public class ComboBoxAvion extends JComboBox<String> {
	private ArrayList<IAvion> listAvion;
	
	public ComboBoxAvion(){
		listAvion = Fenetre.getAvions();
		for(IAvion avion : listAvion){
			addItem(avion.getNom());
		}
	}
	
	@Override
	public IAvion getSelectedItem() {
		// TODO Auto-generated method stub
		String nomSelect = super.getSelectedItem().toString();
		for(IAvion avion : listAvion){
			if(nomSelect.equals(avion.getNom())){
				return avion;
			}
		}
		return null;
	}

}
