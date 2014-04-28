package com.fiuba.taller.ums.component;

import java.net.URL;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JMenuItem;

public class HelpContentsMenuItem extends JMenuItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4375150046025057334L;

	public HelpContentsMenuItem(String string) {
		super(string);
		
		try {		
			URL hsURL = getClass().getResource("/help/help_set.hs");
			HelpSet helpset = new HelpSet(null, hsURL);
			HelpBroker hb = helpset.createHelpBroker();
			
			hb.enableHelpOnButton(this, "introduccion", helpset);			
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
