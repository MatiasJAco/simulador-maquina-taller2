package com.fiuba.taller.ums.component;

import javax.swing.JTabbedPane;

public class MultiTabPane extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2193662673167057206L;

	public MultiTabPane() {
	}

	public void addTab(String tabName) {
		TextEditorPane textEditorPane = new TextEditorPane(tabName);
		this.add(textEditorPane);
	}

	public void closeTab() {
		TextEditorPane textEditorPane = (TextEditorPane) this
				.getSelectedComponent();
		textEditorPane.removeAll();
		this.remove(textEditorPane);
	}

	public TextEditorPane getSelectedTab() {
		return (TextEditorPane) this.getSelectedComponent();
	}

	public void setSelectedTabName(String name) {
		int index = this.getSelectedIndex();
		this.setTitleAt(index, name);
	}
}
