package airportComponents;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

import Forms.Formulaire;
import SystemeGestion.Entite;

public abstract class Structure extends Entite implements MouseListener{
	private String name;
	//Affichage
	JPanel displayComponent;
	
	public Structure(String name){
		super(name);
	}
	
	public JPanel getDisplay(){
		displayComponent = new JPanel();
		JButton button = new JButton(this.getName());
		button.addMouseListener(this);
		displayComponent.add(button);
		return displayComponent;
	}
	

	public void mouseClicked(MouseEvent arg0) {
		System.out.print("Ouvrir formulaire de "+this.getName()+"\n");
		Formulaire form = new Formulaire(getAttributesList());
		try {
			setAttributesList(form.getData());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
