package com.fiuba.taller.ums.component;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class OverflowObserver implements Observer {

	public static Color YELLOW_COLOR = new Color(255,255,0);
	public static Color GREEN_COLOR = new Color(144,245,0);
	public static Color WHITE_COLOR = new Color(255, 255, 255);
	
	private JCheckBox textField;
	
	public OverflowObserver(JCheckBox overCheck) {
		this.textField = overCheck;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		this.textField.setSelected(((Boolean) arg).booleanValue());
		
//		textField.setBackground(GREEN_COLOR);
	}

}
