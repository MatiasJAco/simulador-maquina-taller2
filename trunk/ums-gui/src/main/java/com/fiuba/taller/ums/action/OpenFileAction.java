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
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.fiuba.taller.ums.UmsEditorGui;
import com.fiuba.taller.ums.component.TextEditorPane;

/**
 * Private inner class that handles the event that is generated when the user
 * selects Open from the file menu.
 */

public class OpenFileAction implements ActionListener {

	private UmsEditorGui editorUmsGui;

	public OpenFileAction(UmsEditorGui editorUmsGui) {
		this.editorUmsGui = editorUmsGui;
	}

	public void actionPerformed(ActionEvent e) {
		int chooserStatus;

		JFileChooser chooser = new JFileChooser();
		String fileName;
		String fileContent = null;

		FileFilter filter = new FileNameExtensionFilter(
				"Assembler or Machine Code (*.asm, *.maq)", "asm", "maq");
		chooser.setFileFilter(filter);
		chooserStatus = chooser.showOpenDialog(null);
		if (chooserStatus == JFileChooser.APPROVE_OPTION) {
			// Get a reference to the selected file.
			File selectedFile = chooser.getSelectedFile();

			// Get the path of the selected file.
			fileName = selectedFile.getPath();

			// Open the file.
			if (!openFile(fileName, fileContent)) {
				JOptionPane.showMessageDialog(null,
						"Error reading " + fileName, "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				TextEditorPane editorPane = new TextEditorPane(fileName, fileContent);
				editorUmsGui.getMultiTabPane().addTab(editorPane);
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

	private boolean openFile(String filename, String fileContent) {
		boolean success;
		String inputLine = "";
		FileReader freader;
		BufferedReader inputFile;

		try {
			// Open the file.
			freader = new FileReader(filename);
			inputFile = new BufferedReader(freader);

			// Read the file contents into the editor.
			inputLine = inputFile.readLine();
			while (inputLine != null) {
				fileContent = fileContent + inputLine + "\n";
				inputLine = inputFile.readLine();
			}

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
