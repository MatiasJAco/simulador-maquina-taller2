package com.fiuba.taller.ums.action;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import com.fiuba.taller.ums.UmsEditorGui;

/**
 * Private inner class that handles the event that is generated when the user
 * selects Exit from the file menu.
 */

public class ExitAction implements ActionListener {

	public void actionPerformed(ActionEvent e) {

		int n = JOptionPane.showConfirmDialog(null, "Exit UMS Editor?",
				"Confirm Exit", JOptionPane.YES_NO_OPTION);

		if (n == 0) {
			System.exit(0);
		}
	}
}
