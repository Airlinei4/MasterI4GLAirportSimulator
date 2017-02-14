package Forms;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

import planesAndFlights.IAvion;

public class ChampListAvion extends Container {
	
	private ComboBoxAvion comboAvion;
	private DefaultListModel <String> blocAvion;
	private JList<String> list_1;
	private ArrayList<IAvion> listAvion;
	private JButton btnAdd;
	private JButton btnRem;
	

	public ChampListAvion(ArrayList<IAvion> listOriginale) {
		createComboAvion();
		createZoneAvion(listOriginale);
		createBoutonAdd();
		createBoutonRemove();
		setVisible(true);
		setSize(computeWidth(), computeHeight());
	}
	
	public ArrayList<IAvion> getListAvion() {
		return listAvion;
	}
	
	private void createComboAvion(){
		comboAvion = new ComboBoxAvion();
		comboAvion.setBounds(0, 0, 150, 20);
		add(comboAvion);
	}
	
	private void createZoneAvion(ArrayList<IAvion> listOriginale){
		listAvion = new ArrayList<IAvion>();
		blocAvion = new DefaultListModel<String>();
		for(IAvion avion : listOriginale){
			listAvion.add(avion);
			blocAvion.addElement(avion.getNom());
		}
		
		
		list_1 = new JList<String>();
		list_1.setModel(blocAvion);
		list_1.setBounds(comboAvion.getX(), comboAvion.getY()+comboAvion.getHeight()+30, 100, 100);
		add(list_1);
	}
	
	private void createBoutonAdd(){
		btnAdd = new JButton("+");
		btnAdd.setBounds(comboAvion.getX()+comboAvion.getWidth()+10, comboAvion.getY(), 45, 20);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IAvion tFAvion1 = comboAvion.getSelectedItem();
				if(!listAvion.contains(tFAvion1)){
					listAvion.add(tFAvion1);
					blocAvion.addElement(tFAvion1.getNom());
					list_1.setModel(blocAvion);
				}
			}
		});
		add(btnAdd);
	}
	
	private void createBoutonRemove(){
		btnRem = new JButton("-");
		btnRem.setBounds(list_1.getX()+list_1.getWidth()+10, list_1.getY(), 45, 20);
		btnRem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] nomsAvion = (String[]) list_1.getSelectedValues();
				for(String nom : nomsAvion){
					if(blocAvion.contains(nom)){
						int indexAvion = 0;
						while(!blocAvion.get(indexAvion).equalsIgnoreCase(nom) && indexAvion<blocAvion.size()){
							indexAvion++;
						}
						blocAvion.remove(indexAvion);
						listAvion.remove(indexAvion);
					}
				}
			}
		});
		add(btnRem);
	}

	private int computeWidth(){
		int a = btnAdd.getX()+btnAdd.getWidth();
		int b = btnRem.getX()+btnRem.getWidth();
		return (a>b)? a:b;
	}
	
	private int computeHeight(){
		return list_1.getY()+list_1.getHeight();
	}
}
