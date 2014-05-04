package com.fiuba.taller.ums.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.fiuba.taller.ums.component.DecToHexCalculatorWindow;

public class ConvertDecToHexAction implements ActionListener {

	private DecToHexCalculatorWindow decToHexConverter;

	public ConvertDecToHexAction(DecToHexCalculatorWindow decToHexConverter) {
		this.decToHexConverter = decToHexConverter;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String strDecimal = decToHexConverter.getDecimalField().getText();
		String strHexadecimal = "";
		if(!strDecimal.isEmpty()){
			int numDecimal = Integer.parseInt(strDecimal);
			strHexadecimal = Integer.toHexString(numDecimal).toUpperCase();
		}
		decToHexConverter.getHexaField().setText(strHexadecimal);	
	}

}
