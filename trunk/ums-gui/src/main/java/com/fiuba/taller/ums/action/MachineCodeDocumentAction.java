package com.fiuba.taller.ums.action;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MachineCodeDocumentAction implements DocumentListener {

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("insertUpdate");
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
