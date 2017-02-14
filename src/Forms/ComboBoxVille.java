package Forms;

import java.util.ArrayList;

import javax.swing.JComboBox;

import SystemeGestion.Fenetre;
import planesAndFlights.IVille;

public class ComboBoxVille extends JComboBox<String>  {
	private ArrayList<IVille> listVille;

	public ComboBoxVille(){
		listVille = Fenetre.getVille();
		for(IVille ville : listVille){
			addItem(ville.getNom());
		}
	}

	@Override
	public IVille getSelectedItem() {
		// TODO Auto-generated method stub
		String nomSelect = super.getSelectedItem().toString();
		for(IVille ville : listVille){
			if(nomSelect.equals(ville.getNom())){
				return ville;
			}
		}
		return null;
	}
}
