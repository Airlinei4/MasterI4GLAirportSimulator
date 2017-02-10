package Forms;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private ArrayList <JTextField> txtF = new ArrayList<JTextField>() ;
	private ArrayList <String> data;
	private IAvion [] iAv; 
	private JComboBox comboBox = new JComboBox();

	public Formulaire(Map<String, String> listChamps){
	    iAv = EnumAvion.values();
	    System.out.println(iAv[0].getNom());
	    
		getContentPane().setLayout(null);
		this.setSize(500, 400);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setResizable(false);
		
		int position = 50, i=0;
	      Set<Entry<String, String>> setList = listChamps.entrySet();
	      Iterator<Entry<String, String>> it = setList.iterator();	
	      
	      while (it.hasNext()){			
	    	 
	    	Entry<String, String> fieldName = it.next();
	  
	    	
	      	//ComboBox
	    	 if (fieldName.getValue()== "iAvion"){
	    		
	    		String [] avions = new String[iAv.length];
	    		for (int j = 0; j< iAv.length; j++){
	    			avions[j] = iAv[j].getNom();
	    			System.out.println(" aaa : "+avions[j]);
	    		}
	    		
	    		JPanel panel_2 = new JPanel();
	    		panel_2.setBounds(-10008, -10031, 434, 261);
	    		getContentPane().add(panel_2);
	    		panel_2.setLayout(null);
	    	
	    		comboBox = new JComboBox(avions);
	    		comboBox.addActionListener(this);
	    		panel_2.add(comboBox);

	    	}
	    	 
	    	//Tf normale
	    	 else if(fieldName.getValue() == "deux"){
				lbl.add(new JLabel(fieldName.getKey()));
				lbl.get(lbl.size()-1).setBounds(10, position , 152, 30);
				System.out.println(fieldName.getKey()+": "+position);
				getContentPane().add(lbl.get(lbl.size()-1));
				
				txtF.add(new JTextField());
				txtF.get(txtF.size()-1).setBounds(189, position, 86, 20);
				txtF.get(txtF.size()-1).setColumns(10);
				getContentPane().add(txtF.get(txtF.size()-1));
				//String s = txtF.get(i).getText();
				//data.set(i, s);
				System.out.println(listChamps);
				//i++;
	    	}
	    	
	  
			position += 30;
		}
		
		JButton btnFinish = new JButton("Enregistrer");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			getContentPane().setVisible(false);
			//data.add(listChamps);
			}
		});
		btnFinish.setBounds(350, 300, 120, 50);
		getContentPane().add(btnFinish);
		
		this.setVisible(true);
		
		
	}	
	
	public ArrayList<String> getData() {
		System.out.println(data);

		return data;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
