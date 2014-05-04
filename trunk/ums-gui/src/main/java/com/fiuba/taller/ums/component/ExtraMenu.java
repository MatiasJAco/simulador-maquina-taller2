package com.fiuba.taller.ums.component;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.fiuba.taller.ums.UmsEditorGui;
import com.fiuba.taller.ums.action.DecToHexCalcAction;

public class ExtraMenu extends JMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1659697822640132466L;

	private JMenuItem decToHexCalcMenuItem;
	
	public ExtraMenu() {
		super("Extra");

		// Decimal to Hexadecimal calculator
		decToHexCalcMenuItem = new JMenuItem("DEC to HEX calculator");
		this.add(decToHexCalcMenuItem);
		decToHexCalcMenuItem.addActionListener(new DecToHexCalcAction());
	}

	public JMenuItem getDecToHexCalcMenuItem() {
		return decToHexCalcMenuItem;
	}

	public void setDecToHexCalcMenuItem(JMenuItem decToHexCalcMenuItem) {
		this.decToHexCalcMenuItem = decToHexCalcMenuItem;
	}

}
