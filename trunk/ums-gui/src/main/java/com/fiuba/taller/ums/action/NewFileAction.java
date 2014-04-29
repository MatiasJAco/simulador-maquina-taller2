package com.fiuba.taller.ums.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.fiuba.taller.ums.UmsEditorGui;
import com.fiuba.taller.ums.component.TextEditorPane;

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
		TextEditorPane editorPane;
		if (e.getActionCommand() == "Assembler") {
			editorPane = new TextEditorPane("NewFile" + newFileCounter++ + ".asm");
		}else{
			editorPane = new TextEditorPane("NewFile" + newFileCounter++ + ".maq");
		}
		editorUmsGui.getMultiTabPane().addTab(editorPane);
	}
}
