package com.fiuba.taller.ums.component;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import com.fiuba.taller.ums.UmsEditorGui;
import com.fiuba.taller.ums.action.CloseFileAction;
import com.fiuba.taller.ums.action.ExitAction;
import com.fiuba.taller.ums.action.NewFileAction;
import com.fiuba.taller.ums.action.OpenFileAction;
import com.fiuba.taller.ums.action.SaveFileAction;

public class FileMenu extends JMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8787342388996575987L;
	
	private JMenu newFileMenu;
	private JMenuItem newAssemblerFileItem;
	private JMenuItem newMachineCodeFileItem;
	private JMenuItem openFileMenuItem;
	private JMenuItem closeFileMenuItem;
	private JMenuItem saveAsFileMenuItem;
	private JMenuItem saveFileMenuItem;
	private JMenuItem exitMenuItem;

	public FileMenu() {
		super("File");

		// File operations menu
		newFileMenu = new JMenu("New");
		newFileMenu.setIcon(new ImageIcon(getClass().getResource("/img/icon/NewFile.png")));
		this.add(newFileMenu);

		newAssemblerFileItem = new JMenuItem("Assembler");
		newFileMenu.add(newAssemblerFileItem);

		newMachineCodeFileItem = new JMenuItem("Machine Code");
		newFileMenu.add(newMachineCodeFileItem);

		// Open file item @ File operations menu
		openFileMenuItem = new JMenuItem("Open File...");
		this.add(openFileMenuItem);
		openFileMenuItem.setIcon(new ImageIcon(getClass().getResource(
				"/img/icon/OpenFile.png")));

		JSeparator openFileSeparator = new JSeparator();
		this.add(openFileSeparator);

		// Close file item @ File operations menu
		closeFileMenuItem = new JMenuItem("Close");
		closeFileMenuItem.setIcon(new ImageIcon(getClass().getResource(
				"/img/icon/CloseFile.png")));
		this.add(closeFileMenuItem);

		// Separator between Close file operation and Save file operations @
		// File operations menu
		JSeparator closeFileSeparator = new JSeparator();
		this.add(closeFileSeparator);

		// Save As file item @ File operations menu
		saveAsFileMenuItem = new JMenuItem("Save As...");
		saveAsFileMenuItem.setIcon(new ImageIcon(getClass().getResource(
				"/img/icon/SaveAsFile.png")));
		this.add(saveAsFileMenuItem);

		// Save file item @ File operations menu
		saveFileMenuItem = new JMenuItem("Save");
		saveFileMenuItem.setIcon(new ImageIcon(getClass().getResource(
				"/img/icon/SaveFile.png")));
		this.add(saveFileMenuItem);

		// Separator between Save file operations and exit program @ File
		// operations menu
		JSeparator saveFileSeparator = new JSeparator();
		this.add(saveFileSeparator);

		// Exit program item @ File operations menu
		exitMenuItem = new JMenuItem("Exit");
		this.add(exitMenuItem);
	}

	public FileMenu(UmsEditorGui umsEditorGui) {
		this();
		newAssemblerFileItem.addActionListener(
				new NewFileAction(umsEditorGui));
		newMachineCodeFileItem.addActionListener(
				new NewFileAction(umsEditorGui));
		openFileMenuItem.addActionListener(
				new OpenFileAction(umsEditorGui));
		closeFileMenuItem.addActionListener(
				new CloseFileAction(umsEditorGui));
		saveAsFileMenuItem.addActionListener(
				new SaveFileAction(umsEditorGui));
		saveFileMenuItem.addActionListener(
				new SaveFileAction(umsEditorGui));
		exitMenuItem.addActionListener(new ExitAction());
	}

	public JMenu getNewFileMenu() {
		return newFileMenu;
	}

	public void setNewFileMenu(JMenu newFileMenu) {
		this.newFileMenu = newFileMenu;
	}

	public JMenuItem getNewAssemblerFileItem() {
		return newAssemblerFileItem;
	}

	public void setNewAssemblerFileItem(JMenuItem newAssemblerFileItem) {
		this.newAssemblerFileItem = newAssemblerFileItem;
	}

	public JMenuItem getNewMachineCodeFileItem() {
		return newMachineCodeFileItem;
	}

	public void setNewMachineCodeFileItem(JMenuItem newMachineCodeFileItem) {
		this.newMachineCodeFileItem = newMachineCodeFileItem;
	}

	public JMenuItem getOpenFileMenuItem() {
		return openFileMenuItem;
	}

	public void setOpenFileMenuItem(JMenuItem openFileMenuItem) {
		this.openFileMenuItem = openFileMenuItem;
	}

	public JMenuItem getCloseFileMenuItem() {
		return closeFileMenuItem;
	}

	public void setCloseFileMenuItem(JMenuItem closeFileMenuItem) {
		this.closeFileMenuItem = closeFileMenuItem;
	}

	public JMenuItem getSaveAsFileMenuItem() {
		return saveAsFileMenuItem;
	}

	public void setSaveAsFileMenuItem(JMenuItem saveAsFileMenuItem) {
		this.saveAsFileMenuItem = saveAsFileMenuItem;
	}

	public JMenuItem getSaveFileMenuItem() {
		return saveFileMenuItem;
	}

	public void setSaveFileMenuItem(JMenuItem saveFileMenuItem) {
		this.saveFileMenuItem = saveFileMenuItem;
	}

	public JMenuItem getExitMenuItem() {
		return exitMenuItem;
	}

	public void setExitMenuItem(JMenuItem exitMenuItem) {
		this.exitMenuItem = exitMenuItem;
	}

}
