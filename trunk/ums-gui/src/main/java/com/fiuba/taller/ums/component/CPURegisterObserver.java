package com.fiuba.taller.ums.component;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

public class CPURegisterObserver implements Observer {

	public static Color YELLOW_COLOR = new Color(255,255,0);
	public static Color GREEN_COLOR = new Color(144,245,0);
	public static Color WHITE_COLOR = new Color(255, 255, 255);
	
	private JTextField textField;
	
	public CPURegisterObserver(JTextField regTextField) {
		this.textField = regTextField;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		textField.setText((String) arg);
		
		textField.setBackground(GREEN_COLOR);
	}

}
