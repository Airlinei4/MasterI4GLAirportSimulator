package SystemeGestion;

import java.awt.Container;
import java.awt.Cursor;
import javax.swing.JPanel;

import airportComponents.Piste;
import airportComponents.Porte;
import airportComponents.Terminal;
import planesAndFlights.Vol;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import java.lang.reflect.*;

public class BoutonAjout extends JButton implements MouseListener{
	
	ArrayList liste;
	String class_name;
	JPanel ZoneAffichage;
	int compteur = 0;
	
	public BoutonAjout(String classe, String name, ArrayList liste_a_completer, JPanel Zone){
		this.class_name = classe;
		this.liste = liste_a_completer;
		this.ZoneAffichage = Zone;
		setText(name);
		addMouseListener(this);
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		compteur++;
		if(this.class_name == "Piste"){	
			Piste elmt = new Piste("Piste "+compteur);
			liste.add(elmt);
			ZoneAffichage.add(elmt.getDisplay());
			elmt.setListe(liste);
		}else if(this.class_name == "Vol"){	
			Vol elmt = new Vol("Vol "+compteur);
			liste.add(elmt);
			ZoneAffichage.add(elmt.getDisplay());
			elmt.setListe(liste);
		}else if(this.class_name == "Terminal"){	
			Terminal elmt = new Terminal("Terminal "+compteur);
			liste.add(elmt);
			ZoneAffichage.add(elmt.getDisplay());
			elmt.setListe(liste);
		}else if(this.class_name == "Porte"){	
			Porte elmt = new Porte("Porte "+compteur);
			liste.add(elmt);
			ZoneAffichage.add(elmt.getDisplay());
			elmt.setListe(liste);
		}
		ZoneAffichage.revalidate();
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}