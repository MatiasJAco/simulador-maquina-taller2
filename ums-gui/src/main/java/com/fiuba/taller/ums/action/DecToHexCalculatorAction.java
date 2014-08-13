package com.fiuba.taller.ums.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import com.fiuba.taller.ums.component.Calculator;

public class DecToHexCalculatorAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {

		JFrame frmDecToHex = new Calculator();
		frmDecToHex.setVisible(true);
	}

}
