package com.fiuba.taller.ums.component;

import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;

public class LanguageCodeMenu extends JMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5145006776578277961L;

	private ButtonGroup languageCodeGroup;

	public LanguageCodeMenu() {
		super("Language Code");

		// Assembler codification item @ Language menu
		JRadioButtonMenuItem assemblerRadioItem = new JRadioButtonMenuItem(
				"Assembler");
		this.add(assemblerRadioItem);

		// Machine code codification item @ Language menu
		JRadioButtonMenuItem machineCodeRadioItem = new JRadioButtonMenuItem(
				"Machine Code");
		this.add(machineCodeRadioItem);

		// Group the radio buttons.
		languageCodeGroup = new ButtonGroup();
		languageCodeGroup.add(assemblerRadioItem);
		languageCodeGroup.add(machineCodeRadioItem);

	}

	public String getLanguageCodeSelected() {
		for (Enumeration<AbstractButton> buttons = languageCodeGroup
				.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.isSelected()) {
				return button.getText();
			}
		}
		return null;
	}

	public ButtonGroup getLanguageCodeGroup() {
		return languageCodeGroup;
	}

	public void setLanguageCodeGroup(ButtonGroup languageCodeGroup) {
		this.languageCodeGroup = languageCodeGroup;
	}

}
