package com.fiuba.taller.ums.component;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.fiuba.taller.ums.UmsEditorGui;
import com.fiuba.taller.ums.action.DecToHexCalculatorAction;

public class ExtraMenu extends JMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1659697822640132466L;

	private JMenuItem decToHexCalcMenuItem;
	
	public ExtraMenu() {
		super("Extra");

		// Decimal to Hexadecimal calculator
		decToHexCalcMenuItem = new JMenuItem("Calculator");
		decToHexCalcMenuItem.setIcon(new ImageIcon(getClass().getResource(
				"/img/icon/DecToHexCalculator.png")));
		this.add(decToHexCalcMenuItem);
		decToHexCalcMenuItem.addActionListener(new DecToHexCalculatorAction());
	}

	public JMenuItem getDecToHexCalcMenuItem() {
		return decToHexCalcMenuItem;
	}

	public void setDecToHexCalcMenuItem(JMenuItem decToHexCalcMenuItem) {
		this.decToHexCalcMenuItem = decToHexCalcMenuItem;
	}

}
