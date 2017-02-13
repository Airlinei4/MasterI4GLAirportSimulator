package Forms;

import javax.swing.JTextField;
import javax.swing.text.Document;

public class ChampEntier extends JTextField {

	public ChampEntier() {
	}

	public ChampEntier(Integer nb) {
		super(nb.toString());
	}
	
	public Integer getNumber() {
		return new Integer(super.getText());
	}

}
