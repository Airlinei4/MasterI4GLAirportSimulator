package SystemeGestion;

import java.awt.Color; 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

import airportComponents.Aeroport;
import airportComponents.Piste;
import airportComponents.Porte;
import airportComponents.Terminal;
import planesAndFlights.EnumAvion;
import planesAndFlights.EnumVille;
import planesAndFlights.IAvion;
import planesAndFlights.IVille;
import planesAndFlights.Vol;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;

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
	private static ArrayList<IVille> listVille;


	public Fenetre(){
		aeroport = new Aeroport("Mon Aeroport");
		listAvion = new ArrayList<IAvion>();
		listVille = new ArrayList<IVille>();

		for(IAvion avion : EnumAvion.values()){
			listAvion.add(avion);
		}
		
		for(IVille ville : EnumVille.values()){
			listVille.add(ville);
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
		//Zone.setBackground(Color.blue);
		getContentPane().add(Zone);

//		//Zone Pistes
//		JPanel ZonePistes = new JPanel(new FlowLayout());
//		//ZonePistes.setBackground(Color.red);
//		Zone.add(new JLabel("Pistes"));
//		Zone.add(ZonePistes);
//		//Zone Terminaux
//		JPanel ZoneTerminaux = new JPanel(new FlowLayout());
//		//ZoneTerminaux.setBackground(Color.green);
//		Zone.add(new JLabel("Terminaux"));
//		Zone.add(ZoneTerminaux);
//		//Zone Vols
//		JPanel ZoneVols = new JPanel(new FlowLayout());
//		//ZoneVols.setBackground(Color.yellow);
//		Zone.add(new JLabel("Vols"));
//		Zone.add(ZoneVols);
//
//		//On ajoute les boutons d'ajouts
//		JPanel buttonsPanel = new JPanel();
//		//buttonsPanel.setBackground(Color.ORANGE); 
//		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.PAGE_AXIS));
//		buttonsPanel.add(new BoutonAjout("Piste","Ajouter une piste",aeroport.getPistes(),ZonePistes));
//		buttonsPanel.add(new BoutonAjout("Terminal","Ajouter un terminal",aeroport.getTerminaux(),ZoneTerminaux));
//		buttonsPanel.add(new BoutonAjout("Vol","Ajouter un vol",Vols,ZoneVols));
		//Zone Pistes;
		JPanel ZonePistes = makeZone("Pistes", Zone);
		
		//Zone Terminaux
		JPanel ZoneTerminaux = makeZone("Terminaux", Zone);
		
		//Zone Vols
		JPanel ZoneVols = makeZone("Vols", Zone);
		
		//On ajoute les boutons d'ajouts
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.PAGE_AXIS));
		buttonsPanel.add(new BoutonAjout("Piste","Ajouter une piste",aeroport.getPistes(),ZonePistes));
 		buttonsPanel.add(new BoutonAjout("Terminal","Ajouter un terminal",aeroport.getTerminaux(),ZoneTerminaux));
 		buttonsPanel.add(new BoutonAjout("Vol","Ajouter un vol",Vols,ZoneVols));

		//On ajoute le bouton SIMULER	
		Simuler = new JButton(" SIMULER", new ImageIcon("images/process_icon.png"));
		Simuler.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		Simuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					simuler();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erreur de simulation",
                            JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		Simuler.setBounds((int) (getSize().getWidth()-300), (int) getSize().getHeight()-110, 270, 60);
		buttonsPanel.add(Simuler);

		getContentPane().add(buttonsPanel, BorderLayout.EAST);

		this.setVisible(true);	
	}

	public static ArrayList<IAvion> getAvions() {
		return listAvion;
	}
	
	public static ArrayList<IVille> getVille() {
		return listVille;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Nombre de pistes: "+aeroport.getPistes().size());
		System.out.println("Nombre de terminaux: "+aeroport.getTerminaux().size());
		System.out.println("Nombre de vols: "+Vols.size()+"\n");
	}
	
	public void simuler() throws Exception{
		if(aeroport.getTerminaux().isEmpty()){
			throw new Exception("Aucun terminal n'a ete defini");
		}else{
			ArrayList<Terminal> listTerminaux = aeroport.getTerminaux();
			int index = 0;
			while (index < listTerminaux.size() && listTerminaux.get(index).getPortes().isEmpty()) {
				index++;
				
			}
			if(index == listTerminaux.size()){
				throw new Exception("Aucune porte n'a ete definie");
			}
		}
		if(aeroport.getPistes().isEmpty()){
			throw new Exception("Aucune piste n'a été definie");
		}
		if(Vols.isEmpty()){
			throw new Exception("Aucune vol n'a été defini");
		}
		Collections.sort(Vols);
		ArrayList<Date> dates = getEchellesDates();
		int indexMin = 0;
		try{
			for(Date date : dates){
				int index = indexMin;
				while((index<Vols.size())&&(Vols.get(index).isAffected() || Vols.get(index).compatible(date)||Vols.get(index).isEnCours())){
					Vol temp = Vols.get(index);
					if(temp.isAffected()){
						indexMin = index;
					}else if (temp.isEnCours()) {
						if(!temp.compatible(date)){
							Porte porte = releasePorte(temp);
							temp.affect(releasePiste(temp), porte, getTerminal(porte));
						}else{
							takePiste(temp);
							takePorte(temp);
						}
					}
					index++;
					verifierCapaciteTerminaux();
				}
			}
		}catch (Exception e) {
			releaseAllResources();
			throw e;
		}
	}
	
	private void takePiste(Vol vol) throws Exception{
		ArrayList<Piste> listPistes = aeroport.getPistes();
		int index = 0;
		while(index<listPistes.size() && !listPistes.get(index).isCompatible(vol)){
			index++;
		}
		if(index == listPistes.size()){
			throw new Exception("Aucune piste ne peut accueillir le vol "+vol.getName()
			+"\nVerifiez que l'aeroport contient assez de pistes contenant les criteres suivants : "
			+"\n-piste pour "+vol.getStringType()
			+"\n-piste qui supporte le modele "+vol.getPlaneType().getNom());
		}else{
			listPistes.get(index).take(vol);
		}
	}
	
	private Piste releasePiste(Vol vol) throws Exception{
		Iterator<Piste> it = aeroport.getPistes().iterator();
		while(it.hasNext()){
			Piste piste = it.next();
			if(piste.getVol() == vol){
				piste.release(vol);
				return piste;
			}
		}
		return null;
	}
	
	private void takePorte(Vol vol) throws Exception{
		ArrayList<Terminal> listTerminaux = aeroport.getTerminaux();
		int indexTerminal = 0;
		while(indexTerminal<listTerminaux.size()){
			ArrayList<Porte> listPortes = listTerminaux.get(indexTerminal).getPortes();
			int indexPortes = 0;
			while (indexPortes < listPortes.size() && !listPortes.get(indexPortes).isCompatible(vol)) {
				indexPortes++;	
			}
			if(indexPortes < listPortes.size()){
				listPortes.get(indexPortes).take(vol);
				indexTerminal = 2*listTerminaux.size();
			}else{
				indexTerminal++;
			}
		}
		if(indexTerminal == listTerminaux.size()){
			throw new Exception("Aucune porte ne peut accueillir le vol "+vol.getName()
			+"\nVerifiez que l'aeroport contient assez de portes pouvant accueillir le modele "
			+ ""+vol.getPlaneType().getNom());
		}
	}
	
	private Porte releasePorte(Vol vol) throws Exception{
		for(Terminal term : aeroport.getTerminaux()){
			for(Porte porte : term.getPortes()){
				if(porte.getVol() == vol){
					porte.release(vol);
					return porte;
				}
			}
		}
		return null;
	}
	
	private Terminal getTerminal(Porte porte){
		for(Terminal term : aeroport.getTerminaux()){
			if(term.getPortes().contains(porte)){
				return term;
			}
		}
		return null;
	}
	
	private ArrayList<Date> getEchellesDates(){
		ArrayList<Date> dates = new ArrayList<Date>();
		for(Vol vol : Vols){
			if(!dates.contains(vol.getDateDebut())){
				dates.add(vol.getDateDebut());
			}
		}
		return dates;
	}
	
	private void verifierCapaciteTerminaux() throws Exception{
		for(Terminal terminal : aeroport.getTerminaux()){
			if(terminal.isCapacityOver()){
				throw new Exception("La capacite du terminal "+terminal.getName()+" est depassee");
			}
		}
	}
	
	private void releaseAllResources() throws Exception{
		for(Vol vol : Vols){
			vol.release();
		}
		for(Terminal terminal : aeroport.getTerminaux()){
			for(Porte porte : terminal.getPortes()){
				porte.cancelSimulation();
			}
		}
		for(Piste piste : aeroport.getPistes()){
			piste.cancelSimulation();
		}
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