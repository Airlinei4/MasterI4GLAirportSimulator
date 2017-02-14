package SystemeGestion;

import java.awt.Color; 
import javax.swing.JFrame;
import javax.swing.JPanel;

import airportComponents.Aeroport;
import airportComponents.Piste;
import airportComponents.Terminal;
import planesAndFlights.EnumAvion;
import planesAndFlights.EnumVille;
import planesAndFlights.IAvion;
import planesAndFlights.IVille;
import planesAndFlights.Vol;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.util.ArrayList;
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

		//Zone Pistes
		JPanel ZonePistes = new JPanel(new FlowLayout());
		//ZonePistes.setBackground(Color.red);
		Zone.add(new JLabel("Pistes"));
		Zone.add(ZonePistes);
		//Zone Terminaux
		JPanel ZoneTerminaux = new JPanel(new FlowLayout());
		//ZoneTerminaux.setBackground(Color.green);
		Zone.add(new JLabel("Terminaux"));
		Zone.add(ZoneTerminaux);
		//Zone Vols
		JPanel ZoneVols = new JPanel(new FlowLayout());
		//ZoneVols.setBackground(Color.yellow);
		Zone.add(new JLabel("Vols"));
		Zone.add(ZoneVols);

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
	
	public static ArrayList<IVille> getVille() {
		return listVille;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Nombre de pistes: "+aeroport.getPistes().size());
		System.out.println("Nombre de terminaux: "+aeroport.getTerminaux().size());
		System.out.println("Nombre de vols: "+Vols.size()+"\n");
	}  
}