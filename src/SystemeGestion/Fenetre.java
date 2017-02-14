package SystemeGestion;

import java.awt.Color; 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

import airportComponents.Aeroport;
import airportComponents.Piste;
import airportComponents.Terminal;
import planesAndFlights.EnumAvion;
import planesAndFlights.IAvion;
import planesAndFlights.Vol;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
 
public class Fenetre extends JFrame implements ActionListener{


  JButton Simuler;
  JPanel Zone;

  private Aeroport aeroport;
  ArrayList<Vol> Vols =  new ArrayList<Vol>();
  private static ArrayList<IAvion> listAvion;
	
  public Fenetre(){
	  aeroport = new Aeroport("Mon Aeroport");
	  listAvion = new ArrayList<IAvion>();
	  for(IAvion avion : EnumAvion.values()){
		  listAvion.add(avion);
	  }
  	//Ouverture de la fenetre
    	this.setTitle("Aerport Infrastructure Management System");  
	    this.setSize(1200,900);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setResizable(false);
		
		//JPanel mainframe=new JPanel();
		//setContentPane(mainframe);

	  //On ajoute le bouton SIMULER
 		Zone = new JPanel();
 		Zone.setLayout(new BoxLayout(Zone, BoxLayout.PAGE_AXIS));
		getContentPane().add(Zone);
		
		//Zone Pistes
		JPanel ZonePistes = makeZone("Pistes", Zone);
		
		//Zone Terminaux
		JPanel ZoneTerminaux = makeZone("Terminaux", Zone);
		
		//Zone Vols
		JPanel ZoneVols = makeZone("Vols", Zone);
		
		
		//On ajoute les boutons d'ajouts
		JPanel buttonsPanel = new JPanel();
			//buttonsPanel.setBackground(Color.ORANGE); 
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.PAGE_AXIS));
		buttonsPanel.add(new BoutonAjout("Piste","Ajouter une piste",aeroport.getPistes(),ZonePistes));
 		buttonsPanel.add(new BoutonAjout("Terminal","Ajouter un terminal",aeroport.getTerminaux(),ZoneTerminaux));
 		buttonsPanel.add(new BoutonAjout("Vol","Ajouter un vol",Vols,ZoneVols));
 		
 		//On ajoute le bouton SIMULER	
		Simuler = new JButton(" SIMULER", new ImageIcon("images/process_icon.png"));
		Simuler.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		Simuler.addActionListener(this);
		Simuler.setBounds((int) (getSize().getWidth()-300), (int) getSize().getHeight()-110, 270, 60);
		buttonsPanel.add(Simuler);
		
		getContentPane().add(buttonsPanel, BorderLayout.EAST);
   	    
   	    this.setVisible(true);	
  }
  
  public static ArrayList<IAvion> getAvions() {
	return listAvion;
}
  
  	@Override
	public void actionPerformed(ActionEvent e) {
  		System.out.println("Nombre de pistes: "+aeroport.getPistes().size());
  		System.out.println("Nombre de terminaux: "+aeroport.getTerminaux().size());
		System.out.println("Nombre de vols: "+Vols.size()+"\n");
	}
  
  	private JPanel makeZone(String name, JPanel Zone){
		JPanel ZoneElmt = new JPanel(new WrapLayout());
		JPanel ZoneElmtBorder = new JPanel(new GridLayout(1,1));
		TitledBorder title;
		title = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), name);
		title.setTitleJustification(TitledBorder.CENTER);
		ZoneElmtBorder.setBorder(title);
		JScrollPane scroll = new JScrollPane(ZoneElmt,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setViewportBorder( BorderFactory.createEmptyBorder( 0, 0, 0, 0 ) );
		scroll.setBorder( BorderFactory.createEmptyBorder( 0, 0, 0, 0 ) );
		ZoneElmtBorder.add(scroll);
		Zone.add(ZoneElmtBorder);
		return ZoneElmt;
	}

  
}