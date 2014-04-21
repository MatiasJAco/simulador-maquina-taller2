package com.fiuba.taller.ums.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

/**
 * Private inner class that handles the event that is generated when the user
 * selects Open from the file menu.
 */

public class OpenFileAction implements ActionListener {

	private String filename; // To hold the file name
	private JTextPane editorText;
	private JFrame frmUms;

	public OpenFileAction(JFrame frmUms, JTextPane editorText) {
		this.editorText = editorText;
		this.frmUms = frmUms;
	}

	public void actionPerformed(ActionEvent e) {
		int chooserStatus;

		JFileChooser chooser = new JFileChooser();
		chooserStatus = chooser.showOpenDialog(null);
		if (chooserStatus == JFileChooser.APPROVE_OPTION) {
			// Get a reference to the selected file.
			File selectedFile = chooser.getSelectedFile();

			// Get the path of the selected file.
			filename = selectedFile.getPath();

			// Open the file.
			if (!openFile(filename)) {
				JOptionPane.showMessageDialog(null,
						"Error reading " + filename, "Error",
						JOptionPane.ERROR_MESSAGE);
			}else{
				frmUms.setTitle(filename + " - UMS Code Editor");
			}
		}
	}

	/**
	 * The openFile method opens the file specified by filename and reads its
	 * contents into the text area. The method returns true if the file was
	 * opened and read successfully, or false if an error occurred.
	 * 
	 * @param filename
	 *            The name of the file to open.
	 */

	private boolean openFile(String filename) {
		boolean success;
		String inputLine, editorString = "";
		FileReader freader;
		BufferedReader inputFile;

		try {
			// Open the file.
			freader = new FileReader(filename);
			inputFile = new BufferedReader(freader);

			// Read the file contents into the editor.
			inputLine = inputFile.readLine();
			while (inputLine != null) {
				editorString = editorString + inputLine + "\n";
				inputLine = inputFile.readLine();
			}
			editorText.setText(editorString);

			// Close the file.
			inputFile.close();

			// Indicate that everything went OK.
			success = true;
		} catch (IOException e) {
			// Something went wrong.
			success = false;
		}

		// Return our status.
		return success;
	}
}
