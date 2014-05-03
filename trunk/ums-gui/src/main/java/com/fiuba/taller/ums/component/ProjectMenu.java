package com.fiuba.taller.ums.component;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ProjectMenu extends JMenu {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 51422172707495563L;
	
	JMenuItem compileMenuItem;
	JMenu converterMenu;
	JMenuItem assemToCodMachMenuItem;

	public ProjectMenu() {
		super("Project");
		// Compile code item @ Project menu
		compileMenuItem = new JMenuItem("Compile");
		this.add(compileMenuItem);
		compileMenuItem.setIcon(new ImageIcon(getClass().getResource(
				"/img/icon/CompileFile.png")));

		// Convert code menu @ Project menu
		converterMenu = new JMenu("Converter");
		this.add(converterMenu);

		// Compile code item @ Convert code menu
		assemToCodMachMenuItem = new JMenuItem(
				"Assembler >> Machine Code");
		converterMenu.add(assemToCodMachMenuItem);

	}

	public JMenuItem getCompileMenuItem() {
		return compileMenuItem;
	}
	
	public JMenuItem getAssemToCodMachMenuItem() {
		return assemToCodMachMenuItem;
	}
}
