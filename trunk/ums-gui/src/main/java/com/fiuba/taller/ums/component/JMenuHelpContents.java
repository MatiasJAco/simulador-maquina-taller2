package com.fiuba.taller.ums.component;

import java.net.URL;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JFrame;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class JMenuHelpContents extends JMenuItem{

	public JMenuHelpContents(String string, JFrame frame) {
		super(string);
		
		try {		
			URL hsURL = getClass().getResource("/help/help_set.hs");
			HelpSet helpset = new HelpSet(null, hsURL);
			HelpBroker hb = helpset.createHelpBroker();
			
			hb.enableHelpOnButton(this, "introduccion", helpset);			
			
			// habilita la tecla F1 para invocar la ayuda
			hb.enableHelpKey(frame.getContentPane(), "introduccion", helpset);

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
