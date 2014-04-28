package com.fiuba.taller.ums.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.fiuba.taller.ums.EditorUmsGui;

public class CloseFileAction implements ActionListener {

	private EditorUmsGui editorUmsGui;

	public CloseFileAction(EditorUmsGui editorUmsGui) {
		this.editorUmsGui = editorUmsGui;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		editorUmsGui.getMultiTabPane().closeTab();
	}

}
