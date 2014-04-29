package com.fiuba.taller.ums.component;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class TextEditorPane extends JScrollPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6899634953116260814L;

	private JTextPane editorText;

	public TextEditorPane(String name) {
		// Scrollable text area with line numbers
		editorText = new JTextPane();
		this.setViewportView(editorText);
		TextLineNumber textLineNumber = new TextLineNumber(editorText);
		this.setRowHeaderView(textLineNumber);
		this.setName(name);
	}

	public TextEditorPane(String tabName, String tabContent) {
		this(tabName);
		editorText.setText(tabContent);
	}

	public String getContent() {
		return editorText.getText();
	}

}
