package com.fiuba.taller.ums.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.fiuba.taller.ums.UmsEditorGui;

public class CloseFileAction implements ActionListener {

	private UmsEditorGui editorUmsGui;

	public CloseFileAction(UmsEditorGui editorUmsGui) {
		this.editorUmsGui = editorUmsGui;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		editorUmsGui.getMultiTabPane().closeTab();
	}

}
