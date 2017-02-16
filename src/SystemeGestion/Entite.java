package SystemeGestion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import Forms.Formulaire;

public abstract class Entite  implements MouseListener, ActionListener{
	private String name;
	protected JPanel displayComponent;
	private JButton button;
	JPopupMenu menu;

	public Entite(String name) {
		this.name = name;
		menu = new JPopupMenu();
    	JMenuItem boutonSupprimer = new JMenuItem("Supprimer");
		boutonSupprimer.addActionListener(this);
    	menu.add(boutonSupprimer);
		ouvrirFormulaire();
	}
	
	public void supprimer(){
		displayComponent.setVisible(false);
		colection.remove(this);
	}
	
	private ArrayList colection;
	
	public void setListe(ArrayList liste){
		colection = liste; 
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void ouvrirFormulaire(){
		Formulaire form = new Formulaire(getAttributesList(), getAttributesValues(), this);
	}

	public LinkedHashMap<String, String> getAttributesList(){
		LinkedHashMap<String, String> myMap = new LinkedHashMap<String, String>();
		myMap.put("Nom", "String");
		return myMap;
	}
	
	public ArrayList<Object> getAttributesValues(){
		ArrayList<Object> listValeurs = new ArrayList<Object>();
		listValeurs.add(name);
		return listValeurs;
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
		if(button != null){
			button.setName(name);
		}
	}
	
	public JPanel getDisplay(){
		displayComponent = new JPanel();
		button = new JButton(this.getName());
		button.addMouseListener(this);
		displayComponent.add(button);
		return displayComponent;
	}
	
	public void mousePressed(MouseEvent evt) {
	    if (evt.isPopupTrigger()) {
          menu.show(evt.getComponent(), evt.getX(), evt.getY());
        }else{
        	ouvrirFormulaire();
		}
	}

	public void mouseReleased(MouseEvent evt) {
		if (evt.isPopupTrigger()) {
          menu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
	}
	
	
    public void actionPerformed(ActionEvent e) {
           this.supprimer();
    }

	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
