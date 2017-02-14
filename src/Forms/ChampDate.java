package Forms;

import java.awt.Container;
import java.util.Date;
import java.util.Properties;

import javax.swing.JComboBox;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class ChampDate extends Container {

	private JDatePickerImpl datePicker;
	private JComboBox<Integer> heure;
	private JComboBox<Integer> minute;
	
	public ChampDate() {
		createDatePicker();
		createHeure();
		createMinute();
		
		setSize(computeWidth(), computeHeight());
		setVisible(true);
	}
	
	public Date getDate(){
		Date date = (Date) datePicker.getModel().getValue();
		date.setHours((int) heure.getSelectedItem());
		date.setMinutes((int) minute.getSelectedItem());
		return date;
	}
	
	private int computeWidth(){
		return minute.getX()+minute.getWidth()+datePicker.getX();
	}
	
	private int computeHeight(){
		return datePicker.getX()*2+datePicker.getHeight();
	}
	
	private void createDatePicker(){
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
		datePicker.setBounds(10, 10, 120, 20);
		this.add(datePicker);
	}
	
	private void createHeure(){
		heure = new JComboBox<Integer>();
		for(int i= 0; i<24; i++){
			heure.addItem(i);
		}
		heure.setBounds(datePicker.getX()*2+datePicker.getWidth(), datePicker.getY(), 50, 20);
		add(heure);
	}
	
	private void createMinute(){
		minute = new JComboBox<Integer>();
		for(int i= 0; i<60; i=i+10){
			minute.addItem(i);
		}
		minute.setBounds(heure.getX()+heure.getWidth()+datePicker.getX(), datePicker.getY(), 50, 20);
		add(minute);
	}

}
