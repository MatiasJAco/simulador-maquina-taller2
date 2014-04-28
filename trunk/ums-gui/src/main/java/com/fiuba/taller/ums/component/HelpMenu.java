package com.fiuba.taller.ums.component;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import com.fiuba.taller.ums.action.AboutAction;

public class HelpMenu extends JMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 475499303476216514L;

	private HelpContentsMenuItem helpContentsMenuItem;
	private JMenuItem aboutHelpMenuItem;

	public HelpMenu() {
		super("Help");

		// Help Contents item @ Help menu
		 helpContentsMenuItem = new HelpContentsMenuItem("Help Contents");
		 helpContentsMenuItem.setIcon(new ImageIcon(getClass().getResource(
		 "/img/icon/HelpContents.png")));
		 this.add(helpContentsMenuItem);

		// Separator between Help contents and about @ Help menu
		JSeparator helpContentsSeparator = new JSeparator();
		this.add(helpContentsSeparator);

		// About item @ Help menu
		aboutHelpMenuItem = new JMenuItem("About UMS");
		this.add(aboutHelpMenuItem);

	}
}
