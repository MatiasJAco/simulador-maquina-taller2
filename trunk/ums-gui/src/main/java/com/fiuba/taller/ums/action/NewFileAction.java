package com.fiuba.taller.ums.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextPane;

/**
 * Private inner class that handles the event that is generated when the user
 * selects New from the file menu.
 */

public class NewFileAction implements ActionListener {

	private JTextPane editorText;

	public NewFileAction(JTextPane editorText) {
		this.editorText = editorText;
	}

	public void actionPerformed(ActionEvent e) {
		editorText.setText("");
	}
}
