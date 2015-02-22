package com.fiuba.taller.ums.component;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.fiuba.taller.ums.UmsEditorGui;
import com.fiuba.taller.ums.action.CompileAction;
import com.fiuba.taller.ums.action.ConvertAction;
import com.fiuba.taller.ums.action.ExecuteAction;

public class ProjectMenu extends JMenu {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 51422172707495563L;
	
	JMenuItem compileMenuItem;
	JMenu converterMenu;
	JMenuItem assemToCodMachMenuItem;
	JMenuItem executeCodMachMenuItem;

	public ProjectMenu() {
		super("Project");
		// Compile code item @ Project menu
		compileMenuItem = new JMenuItem("Check Syntax");
		this.add(compileMenuItem);
		compileMenuItem.setIcon(new ImageIcon(getClass().getResource(
				"/img/icon/CompileFile.png")));

		// Execute machine code item @ Project menu
		executeCodMachMenuItem = new JMenuItem("Execute");
		this.add(executeCodMachMenuItem);
		executeCodMachMenuItem.setIcon(new ImageIcon(getClass().getResource(
				"/img/icon/ExecuteFile.png")));
		
		
		// Convert code menu @ Project menu
		converterMenu = new JMenu("Converter");
		converterMenu.setIcon(new ImageIcon(getClass().getResource(
				"/img/icon/Converter.png")));
		this.add(converterMenu);

		// Compile code item @ Convert code menu
		assemToCodMachMenuItem = new JMenuItem(
				"Assembler >> Machine Code");
		converterMenu.add(assemToCodMachMenuItem);

	}

	public ProjectMenu(UmsEditorGui umsEditorGui) {
		this();
		compileMenuItem.addActionListener(new CompileAction(umsEditorGui));
		assemToCodMachMenuItem.addActionListener(new ConvertAction(umsEditorGui));
		executeCodMachMenuItem.addActionListener(new ExecuteAction(umsEditorGui));
	}

	public JMenuItem getCompileMenuItem() {
		return compileMenuItem;
	}
	
	public JMenuItem getAssemToCodMachMenuItem() {
		return assemToCodMachMenuItem;
	}
}
