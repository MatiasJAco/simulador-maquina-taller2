package com.fiuba.taller.ums.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Private inner class that handles the event that is generated when the user
 * selects Exit from the file menu.
 */

public class ExitAction implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
