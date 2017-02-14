package Forms;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import SystemeGestion.Entite;
import airportComponents.Porte;
import planesAndFlights.IAvion;

public class Formulaire extends JFrame implements ActionListener{

	private ArrayList <JLabel> lbl = new ArrayList<JLabel>();


	//private ArrayList<JLabel> 
	private ArrayList <JTextField> txtF = new ArrayList<JTextField>() ;
	private ArrayList<Object> data;
	private ArrayList<Component> listFields;
	private ComboBoxAvion comboBoxAv;
	private ArrayList<IAvion> listAvions;
	private ArrayList<Porte> listPortes;
	private ComboBoxDepart comboBoxPiste;
	private int position = 30;

	private JFrame frame ;
	private Entry<String, String> fieldName;

	public Formulaire(Map<String, String> listChamps, ArrayList<Object> listeValeur, Entite objet){
		JButton btnFinish = new JButton("Enregistrer");
		listFields = new ArrayList<Component>();
		

		frame= new JFrame("Formulaire");
		getContentPane().setLayout(null);
		this.setSize(500, 400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		Set<Entry<String, String>> setList = listChamps.entrySet();
		Iterator<Entry<String, String>> it = setList.iterator();
		int indexValeurs = 0;

		while (it.hasNext()){			

			fieldName = it.next();
			//comboBox type de piste
			if(fieldName.getValue() == "boolean"){
				comboBoxPiste = new ComboBoxDepart();
				comboBoxPiste.addActionListener(this);
				comboBoxPiste.setBounds(189, position, 86, 20);
				getContentPane().add(comboBoxPiste);
				listFields.add(comboBoxPiste);

				lbl.add(new JLabel(fieldName.getKey()));
				lbl.get(lbl.size()-1).setBounds(10, position , 152, 30);
				System.out.println(fieldName.getKey()+": "+position);
				getContentPane().add(lbl.get(lbl.size()-1));
			}

			//ComboBox type iAvion
			else if (fieldName.getValue()== "IAvion"){

				lbl.add(new JLabel(fieldName.getKey()));
				lbl.get(lbl.size()-1).setBounds(10, position , 152, 20);
				getContentPane().add(lbl.get(lbl.size()-1));

				comboBoxAv = new ComboBoxAvion();
				comboBoxAv.addActionListener(this);
				comboBoxAv.setBounds(189, position, 86, 20);
				getContentPane().add(comboBoxAv);
				listFields.add(comboBoxAv);			
			}
			
			else if (fieldName.getValue()== "List IAvion"){
				listAvions = new ArrayList<IAvion>();
				lbl.add(new JLabel(fieldName.getKey()));
				lbl.get(lbl.size()-1).setBounds(10, position , 152, 20);
				getContentPane().add(lbl.get(lbl.size()-1));

				comboBoxAv = new ComboBoxAvion();
				comboBoxAv.addActionListener(this);
				comboBoxAv.setBounds(189, position, 86, 20);
				getContentPane().add(comboBoxAv);
				listFields.add(comboBoxAv);
				position+=30;
			
				JButton btnAdd = new JButton("+");
				btnAdd.setBounds(300, position, 45, 20);
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						
						IAvion tFAvion1 = comboBoxAv.getSelectedItem();
						if(!listAvions.contains(tFAvion1)){
							listAvions.add(tFAvion1);
							lbl.add(new JLabel(tFAvion1.getNom()));
							lbl.get(lbl.size()-1).setBounds(10, position+50 , 152, 20);
							getContentPane().add(lbl.get(lbl.size()-1));
							
//							JLabel lblTerminalsDeLaroport = new JLabel("Terminals de l'a\u00E9roport");
//							lblTerminalsDeLaroport.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 17));
//							lblTerminalsDeLaroport.setBounds(10, position , 152, 20);
//							getContentPane().add(lblTerminalsDeLaroport);
							
							position+=30;
						}
					}
				});
				getContentPane().add(btnAdd);
			}
			else if(fieldName.getValue()== "int"){
				lbl.add(new JLabel(fieldName.getKey()));
				lbl.get(lbl.size()-1).setBounds(10, position , 152, 30);
				getContentPane().add(lbl.get(lbl.size()-1));

				ChampEntier champEntier = new ChampEntier((Integer) listeValeur.get(indexValeurs));
				champEntier.setBounds(189, position, 86, 20);
				champEntier.setColumns(10);
				getContentPane().add(champEntier);
				listFields.add(champEntier);
			}
			
			else if(fieldName.getValue() == "List Porte"){
				listPortes = new ArrayList<Porte>();
				
				lbl.add(new JLabel(fieldName.getKey()));
				lbl.get(lbl.size()-1).setBounds(10, position , 152, 20);
				getContentPane().add(lbl.get(lbl.size()-1));
				
				JButton btnAdd = new JButton("+");
				btnAdd.setBounds(300, position, 45, 20);
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Porte porte = new Porte("Porte"+listPortes.size());
						listPortes.add(porte);
						//ajout au conteneur dans la fenêtre du terminal
						position+=30;
					}
				});
				getContentPane().add(btnAdd);
				listFields.add(btnAdd);
			}
			
			else if (fieldName.getValue() == "Date") {
				lbl.add(new JLabel(fieldName.getKey()));
				lbl.get(lbl.size()-1).setBounds(10, position , 152, 20);
				getContentPane().add(lbl.get(lbl.size()-1));
				
				ChampDate champDate = new ChampDate();
				champDate.setLocation(189, position);
//				champDate.setBounds(189, position, 86, 20);
				getContentPane().add(champDate);
				listFields.add(champDate);
			}

			// normale jTextField
			else {
				lbl.add(new JLabel(fieldName.getKey()));
				lbl.get(lbl.size()-1).setBounds(10, position , 152, 30);
				System.out.println(fieldName.getKey()+": "+position);
				getContentPane().add(lbl.get(lbl.size()-1));

				txtF.add(new JTextField((String) listeValeur.get(indexValeurs)));
				txtF.get(txtF.size()-1).setBounds(189, position, 86, 20);
				txtF.get(txtF.size()-1).setColumns(10);
				getContentPane().add(txtF.get(txtF.size()-1));
				listFields.add(txtF.get(txtF.size()-1));
			}
			position+=listFields.get(listFields.size()-1).getHeight()*1.5;
			indexValeurs++;
		
		}
		 

		

		
		
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().setVisible(false);
				data = new ArrayList<Object>();
				
				for(Component comp : listFields){
					if(comp instanceof ComboBoxDepart){
						data.add(((ComboBoxDepart) comp).getSelectedItem());
					}else if (comp instanceof ComboBoxAvion){
						if(listAvions != null){
							data.add(listAvions);
						}else{
							data.add(((ComboBoxAvion) comp).getSelectedItem());
						}
					}else if(comp instanceof ChampEntier){
						data.add(((ChampEntier) comp).getNumber());
					}else if (comp instanceof ChampDate) {
						data.add(((ChampDate) comp).getDate());
					}else if(comp instanceof JButton && listPortes != null){
						data.add(listPortes);
					}
					else{
						data.add(((JTextField) comp).getText());
					}
				}
				
				try {
					objet.setAttributesList(data);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
				

//				//Enregistrement iAvion selectionne
//				String tFAvion = comboBoxAv.getSelectedItem().toString();
//				System.out.println("avion selectionné "+tFAvion);
//
//				//Enregistrement type d'avion boolPiste dans : true -> Depart ...
//				Boolean boolPiste;
//				String tFPiste = comboBoxPiste.getSelectedItem().toString();
//				System.out.println("Type de piste selectionné "+tFPiste);
//				if(tFPiste == "Depart")
//					boolPiste = true;
//				else
//					boolPiste = false;
//
//				//Enregistrement texte ecris
//				String [] txt = new String [txtF.size()];
//				for (int jj=0; jj< txtF.size(); jj++ ){
//					txt[jj] = txtF.get(jj).getText();
//					System.out.println("txt écrit "+ txt[jj]);
//				}
//				
//				JLabel lblTerminalsDeLaroport = new JLabel("Terminals de l'a\u00E9roport");
//				lblTerminalsDeLaroport.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 17));
//				lblTerminalsDeLaroport.setBounds(10, position , 152, 20);
//				getContentPane().add(lblTerminalsDeLaroport);
			}
		});
		btnFinish.setBounds(350, 300, 120, 50);
		getContentPane().add(btnFinish);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
	}
}