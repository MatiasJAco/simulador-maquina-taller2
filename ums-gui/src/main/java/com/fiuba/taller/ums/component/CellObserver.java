package com.fiuba.taller.ums.component;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

public class CellObserver implements Observer {

	public static Color YELLOW_COLOR = new Color(255,255,0);
	
	private JTextField textField;
	
	public CellObserver(JTextField regTextField) {
		this.textField = regTextField;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		textField.setText((String) arg);
		
		textField.setBackground(YELLOW_COLOR);
	}

}
