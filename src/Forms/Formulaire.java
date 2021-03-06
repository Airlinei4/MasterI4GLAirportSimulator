package Forms;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import SystemeGestion.Entite;
import planesAndFlights.IAvion;

public class Formulaire extends JFrame implements ActionListener{

	private ArrayList <JLabel> lbl = new ArrayList<JLabel>();

	private ArrayList <JTextField> txtF = new ArrayList<JTextField>() ;
	private ArrayList<Component> listFields;
	private int position = 30;

	public Formulaire(Map<String, String> listChamps, ArrayList<Object> listeValeur, Entite objet){
		super("Formulaire");
		JButton btnFinish = new JButton("Enregistrer");
		listFields = new ArrayList<Component>();
		
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		

		Set<Entry<String, String>> setList = listChamps.entrySet();
		Iterator<Entry<String, String>> it = setList.iterator();
		int indexValeurs = 0;

		while (it.hasNext()){			

			Entry<String, String> fieldName = it.next();
			//comboBox type de piste
			if(fieldName.getValue() == "boolean"){
				ComboBoxDepart comboBoxPiste = new ComboBoxDepart((boolean) listeValeur.get(indexValeurs));
				comboBoxPiste.addActionListener(this);
				comboBoxPiste.setBounds(189, position, 86, 20);
				getContentPane().add(comboBoxPiste);
				listFields.add(comboBoxPiste);

				lbl.add(new JLabel(fieldName.getKey()));
				lbl.get(lbl.size()-1).setBounds(10, position , 152, 30);
				getContentPane().add(lbl.get(lbl.size()-1));
			}

			//ComboBox type iAvion
			else if (fieldName.getValue()== "IAvion"){

				lbl.add(new JLabel(fieldName.getKey()));
				lbl.get(lbl.size()-1).setBounds(10, position , 152, 20);
				getContentPane().add(lbl.get(lbl.size()-1));

				ComboBoxAvion comboBoxAv = new ComboBoxAvion((IAvion) listeValeur.get(indexValeurs));
				comboBoxAv.addActionListener(this);
				comboBoxAv.setBounds(189, position, 86, 20);
				getContentPane().add(comboBoxAv);
				listFields.add(comboBoxAv);			
			}
			
			else if (fieldName.getValue()== "List IAvion"){
				lbl.add(new JLabel(fieldName.getKey()));
				lbl.get(lbl.size()-1).setBounds(10, position , 152, 20);
				getContentPane().add(lbl.get(lbl.size()-1));

				ChampListAvion comboListAvion = new ChampListAvion((ArrayList<IAvion>) listeValeur.get(indexValeurs));
				comboListAvion.setLocation(189, position);
				getContentPane().add(comboListAvion);
				listFields.add(comboListAvion);
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
			
			else if (fieldName.getValue() == "Date") {
				lbl.add(new JLabel(fieldName.getKey()));
				lbl.get(lbl.size()-1).setBounds(10, position , 152, 20);
				getContentPane().add(lbl.get(lbl.size()-1));
				
				ChampDate champDate = new ChampDate((Date) listeValeur.get(indexValeurs));
				champDate.setLocation(189, position);
				getContentPane().add(champDate);
				listFields.add(champDate);
			}

			// normale jTextField
			else {
				lbl.add(new JLabel(fieldName.getKey()));
				lbl.get(lbl.size()-1).setBounds(10, position , 152, 30);
				getContentPane().add(lbl.get(lbl.size()-1));

				txtF.add(new JTextField((String) listeValeur.get(indexValeurs)));
				txtF.get(txtF.size()-1).setBounds(189, position, 86, 20);
				txtF.get(txtF.size()-1).setColumns(10);
				getContentPane().add(txtF.get(txtF.size()-1));
				listFields.add(txtF.get(txtF.size()-1));
			}
			position+=listFields.get(listFields.size()-1).getHeight()+30;
			indexValeurs++;
		
		}
		
		btnFinish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().setVisible(false);
				ArrayList<Object> data = new ArrayList<Object>();
				
				for(Component comp : listFields){
					if(comp instanceof ComboBoxDepart){
						data.add(((ComboBoxDepart) comp).getChoice());
					}else if (comp instanceof ComboBoxAvion){
						data.add(((ComboBoxAvion) comp).getSelectedItem());
					}else if (comp instanceof ChampListAvion) {
						data.add(((ChampListAvion) comp).getListAvion());
					}else if(comp instanceof ChampEntier){
						data.add(((ChampEntier) comp).getNumber());
					}else if (comp instanceof ChampDate) {
						data.add(((ChampDate) comp).getDate());
					}else{
						data.add(((JTextField) comp).getText());
					}
				}
				
				try {
					objet.setAttributesList(data);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
				}
				dispose();
			}
		});
		btnFinish.setBounds(350, position, 120, 50);
		getContentPane().add(btnFinish);
		setSize(500, btnFinish.getY()+btnFinish.getHeight()+50);
		this.setResizable(false);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
	}
}