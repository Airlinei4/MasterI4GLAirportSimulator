package Forms;

import java.awt.Button;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.util.*;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import planesAndFlights.EnumAvion;
import planesAndFlights.IAvion;

public class Formulaire extends JFrame implements ActionListener{

	private ArrayList <JLabel> lbl = new ArrayList<JLabel>();


	//private ArrayList<JLabel> 
	private ArrayList <JTextField> txtF = new ArrayList<JTextField>() ;
	private ArrayList<Object> data;
	private IAvion [] iAv; 
	private ComboBoxAvion comboBoxAv;
	private JComboBox comboBoxAv2 = new JComboBox();
	private JComboBox comboBoxPiste = new JComboBox();
	private int position = 30;

	private JFrame frame ;
	private Entry<String, String> fieldName;

	public Formulaire(Map<String, String> listChamps){
		JButton btnFinish = new JButton("Enregistrer");
		

		frame= new JFrame("Formulaire");
		getContentPane().setLayout(null);
		this.setSize(500, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		int i=0;
		Set<Entry<String, String>> setList = listChamps.entrySet();
		Iterator<Entry<String, String>> it = setList.iterator();

		while (it.hasNext()){			

			fieldName = it.next();
			//comboBox type de piste
			if(fieldName.getValue() == "boolean"){
				String [] piste = {"Départ","Arrivée"};
				comboBoxPiste = new JComboBox(piste);
				comboBoxPiste.addActionListener(this);
				comboBoxPiste.setBounds(189, position, 86, 20);
				getContentPane().add(comboBoxPiste);

				lbl.add(new JLabel(fieldName.getKey()));
				lbl.get(lbl.size()-1).setBounds(10, position , 152, 30);
				System.out.println(fieldName.getKey()+": "+position);
				getContentPane().add(lbl.get(lbl.size()-1));
				position+=30;
			}

			//ComboBox type iAvion
			else if (fieldName.getValue()== "IAvion"){

				
				

				lbl.add(new JLabel(fieldName.getKey()));
				lbl.get(lbl.size()-1).setBounds(10, position , 152, 20);
				System.out.println(fieldName.getKey()+": "+position);
				getContentPane().add(lbl.get(lbl.size()-1));

				comboBoxAv = new ComboBoxAvion();
				comboBoxAv.addActionListener(this);
				comboBoxAv.setBounds(189, position, 86, 20);
				getContentPane().add(comboBoxAv);
				position+=30;
				
			}
			else if (fieldName.getValue()== "List IAvion"){
				lbl.add(new JLabel(fieldName.getKey()));
				lbl.get(lbl.size()-1).setBounds(10, position , 152, 20);
				System.out.println(fieldName.getKey()+": "+position);
				getContentPane().add(lbl.get(lbl.size()-1));

				comboBoxAv = new ComboBoxAvion();
				comboBoxAv.addActionListener(this);
				comboBoxAv.setBounds(189, position, 86, 20);
				getContentPane().add(comboBoxAv);
				position+=30;
			
				JButton btnAdd = new JButton("+");
				btnAdd.setBounds(300, position, 45, 20);
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						
						String tFAvion1 = comboBoxAv.getSelectedItem().toString();
						System.out.println("avion selectionné "+tFAvion1);
						
						lbl.add(new JLabel(tFAvion1));
						lbl.get(lbl.size()-1).setBounds(10, position+50 , 152, 20);
						System.out.println(lbl+ " : "+position);
						getContentPane().add(lbl.get(lbl.size()-1));
						
						JLabel lblTerminalsDeLaroport = new JLabel("Terminals de l'a\u00E9roport");
						lblTerminalsDeLaroport.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 17));
						lblTerminalsDeLaroport.setBounds(10, position , 152, 20);
						getContentPane().add(lblTerminalsDeLaroport);
						
						position+=30;

					}
				});
				getContentPane().add(btnAdd);
			}

			// normale jTextField
			else {
				lbl.add(new JLabel(fieldName.getKey()));
				lbl.get(lbl.size()-1).setBounds(10, position , 152, 30);
				System.out.println(fieldName.getKey()+": "+position);
				getContentPane().add(lbl.get(lbl.size()-1));

				txtF.add(new JTextField());
				txtF.get(txtF.size()-1).setBounds(189, position, 86, 20);
				txtF.get(txtF.size()-1).setColumns(10);
				getContentPane().add(txtF.get(txtF.size()-1));

				position+=30;
			}
		
		}
		 

		

		
		
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().setVisible(false);

				//Enregistrement iAvion selectionne
				String tFAvion = comboBoxAv.getSelectedItem().toString();
				System.out.println("avion selectionné "+tFAvion);

				//Enregistrement type d'avion boolPiste dans : true -> Depart ...
				Boolean boolPiste;
				String tFPiste = comboBoxPiste.getSelectedItem().toString();
				System.out.println("Type de piste selectionné "+tFPiste);
				if(tFPiste == "Depart")
					boolPiste = true;
				else
					boolPiste = false;

				//Enregistrement texte ecris
				String [] txt = new String [txtF.size()];
				for (int jj=0; jj< txtF.size(); jj++ ){
					txt[jj] = txtF.get(jj).getText();
					System.out.println("txt écrit "+ txt[jj]);
				}
				
				JLabel lblTerminalsDeLaroport = new JLabel("Terminals de l'a\u00E9roport");
				lblTerminalsDeLaroport.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 17));
				lblTerminalsDeLaroport.setBounds(10, position , 152, 20);
				getContentPane().add(lblTerminalsDeLaroport);
			}
		});
		btnFinish.setBounds(350, 300, 120, 50);
		getContentPane().add(btnFinish);

		this.setVisible(true);
	}	

	public ArrayList<Object> getData() {
		System.out.println(data);
		return data;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
	}
}