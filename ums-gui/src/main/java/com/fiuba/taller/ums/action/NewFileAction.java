package com.fiuba.taller.ums.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import com.fiuba.taller.ums.UmsEditorGui;
import com.fiuba.taller.ums.common.FileType;
import com.fiuba.taller.ums.component.FileEditorPane;

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
		FileEditorPane editorPane;
		if (e.getActionCommand() == "Assembler") {
			editorPane = new FileEditorPane("NewFile" + newFileCounter++
					+ ".asm", null, FileType.ASSEMBLER, false);
		} else {
			editorPane = new FileEditorPane("NewFile" + newFileCounter++
					+ ".maq", null, FileType.MACHINE_CODE, true);
			;
		}
		editorUmsGui.getMultiTabPane().addTab(editorPane, editorPane.getName(),
				editorPane.getFilePath());
	}
}
