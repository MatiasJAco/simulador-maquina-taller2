package com.fiuba.taller.ums.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.fiuba.taller.ums.UmsEditorGui;
import com.fiuba.taller.ums.component.FileEditorPane;

/**
 * Private inner class that handles the event that is generated when the user
 * selects Save or Save As from the file menu.
 */

public class SaveFileAction implements ActionListener {

	private String fileName;
	private JTextPane editorText;
	private JFrame frmUms;

	private UmsEditorGui editorUmsGui;

	public SaveFileAction(JFrame frmUms, JTextPane editorText, String fileName) {
		this.editorText = editorText;
		this.fileName = fileName;
		this.frmUms = frmUms;
	}

	public SaveFileAction(UmsEditorGui editorUmsGui) {
		this.editorUmsGui = editorUmsGui;
	}

	public void actionPerformed(ActionEvent e) {
		int chooserStatus;

		// If the user selected Save As, or the contents
		// of the editor have not been saved, use a file
		// chooser to get the file name. Otherwise, save
		// the file under the current file name.

		FileEditorPane textEditor = (FileEditorPane) editorUmsGui
				.getMultiTabPane().getSelectedTab();
		String textContent = textEditor.getContent();
		String fileName = textEditor.getName();
		String filePath = textEditor.getFilePath();
		boolean saveFileApproved = true;

		if (e.getActionCommand() == "Save As..." || filePath == null) {
			JFileChooser chooser = new JFileChooser();
			FileFilter filter = new FileNameExtensionFilter(
					"Assembler or Machine Code (*.asm, *.maq)", "asm", "maq");
			chooser.setFileFilter(filter);
			chooserStatus = chooser.showSaveDialog(null);

			if (chooserStatus == JFileChooser.APPROVE_OPTION) {
				// Get a reference to the selected file.
				File selectedFile = chooser.getSelectedFile();

				// Get the path of the selected file.
				filePath = selectedFile.getPath();
				fileName = selectedFile.getName();
			} else {
				saveFileApproved = false;
			}
		}

		if (saveFileApproved) {
			// Save the file.
			if (!saveFile(fileName, textContent)) {
				JOptionPane.showMessageDialog(null, "Error saving " + filePath,
						"Error", JOptionPane.ERROR_MESSAGE);
			} else {
				editorUmsGui.getMultiTabPane().setSelectedTabName(fileName);
				textEditor.setFilePath(filePath);
			}
		}

	}

	/**
	 * The saveFile method saves the contents of the text area to a file. The
	 * method returns true if the file was saved successfully, or false if an
	 * error occurred.
	 * 
	 * @param filename
	 *            The name of the file.
	 * @return true if successful, false otherwise.
	 */

	private boolean saveFile(String filename, String fileContent) {
		boolean success;
		FileWriter fwriter;
		PrintWriter outputFile;

		try {
			// Open the file.
			fwriter = new FileWriter(filename);
			outputFile = new PrintWriter(fwriter);

			// Write the contents of the text area
			// to the file.
			outputFile.print(fileContent);

			// Close the file.
			outputFile.close();

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
