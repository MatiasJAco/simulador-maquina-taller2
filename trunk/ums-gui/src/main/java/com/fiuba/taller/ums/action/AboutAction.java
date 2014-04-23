/*
 * Creation : 22 Apr 2014
 */
package com.fiuba.taller.ums.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AboutAction implements ActionListener {

	private JFrame frame;

	public AboutAction(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane
				.showMessageDialog(frame, "UMS Code Editor - Version: 1.0.0");
	}

}
