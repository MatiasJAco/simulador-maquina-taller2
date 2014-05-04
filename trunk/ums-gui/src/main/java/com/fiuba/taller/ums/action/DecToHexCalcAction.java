package com.fiuba.taller.ums.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.fiuba.taller.ums.component.DecToHexConverter;

public class DecToHexCalcAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {

		JFrame frmDecToHex = new DecToHexConverter();
		frmDecToHex.setVisible(true);
	}

}
