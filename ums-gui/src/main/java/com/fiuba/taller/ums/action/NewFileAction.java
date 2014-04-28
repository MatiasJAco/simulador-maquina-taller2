package com.fiuba.taller.ums.action;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;

import com.fiuba.taller.ums.UmsEditorGui;
import com.fiuba.taller.ums.component.TextLineNumber;

/**
 * Private inner class that handles the event that is generated when the user
 * selects New from the file menu.
 */

public class NewFileAction implements ActionListener {

	private UmsEditorGui editorUmsGui;
	private int newFileCounter = 1;

	public NewFileAction(UmsEditorGui editorUmsGui) {
		this.editorUmsGui = editorUmsGui;
	}

	public void actionPerformed(ActionEvent e) {
		editorUmsGui.getMultiTabPane().addTab("New File " + newFileCounter++);
	}
}
