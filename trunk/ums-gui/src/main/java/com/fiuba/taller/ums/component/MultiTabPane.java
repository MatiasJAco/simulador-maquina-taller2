package com.fiuba.taller.ums.component;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class MultiTabPane extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2193662673167057206L;

	public MultiTabPane() {
	}

	public void addTab(JScrollPane componentPane, String name, String description) {
		this.addTab(name, null, componentPane, description);
		this.setSelectedIndex(this.getTabCount() - 1);
	}

	public void closeTab() {
		JScrollPane componentPane = (JScrollPane) this.getSelectedComponent();
		componentPane.removeAll();
		;
		this.remove(componentPane);
	}

	public JScrollPane getSelectedTab() {
		return (JScrollPane) this.getSelectedComponent();
	}

	public void setSelectedTabName(String name) {
		int index = this.getSelectedIndex();
		this.setTitleAt(index, name);
	}

	public void setSelectedTabToolTip(String toolTipText) {
		int index = this.getSelectedIndex();
		this.setToolTipTextAt(index, toolTipText);
	}
}
