package com.fiuba.taller.ums.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.fiuba.taller.ums.FileType;
import com.fiuba.taller.ums.ProgramInterpreter;
import com.fiuba.taller.ums.UmsEditorGui;
import com.fiuba.taller.ums.component.FileEditorPane;

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
		String fileName = null;
		String filePath = null;
		String fileContent = "";

		FileFilter filter = new FileNameExtensionFilter(
				"Assembler & Machine Code (*.asm, *.maq)", "asm", "maq");

		chooser.setFileFilter(filter);
		chooser.setAcceptAllFileFilterUsed(false);
		chooserStatus = chooser.showOpenDialog(null);
		if (chooserStatus == JFileChooser.APPROVE_OPTION) {
			// Get a reference to the selected file.
			File selectedFile = chooser.getSelectedFile();

			// Get the path of the selected file.
			filePath = selectedFile.getPath();
			fileName = selectedFile.getName();


			// Open the file.
			try {
				fileContent = openFile(filePath);
				FileType fileType;
				FileEditorPane editorPane;
				if (fileName.endsWith(".asm")) {
					fileType = FileType.ASSEMBLER;
					editorPane = new FileEditorPane(fileName,
							filePath, fileContent, fileType, false);
				} else {
					fileType = FileType.MACHINE_CODE;
					//Memory addresses removed from string of maq file.
					ProgramInterpreter pi = new ProgramInterpreter();
					fileContent = pi.removeMemoryAddresses(fileContent);
					editorPane = new FileEditorPane(fileName,
							filePath, fileContent, fileType, true);
				}
				editorUmsGui.getMultiTabPane().addTab(editorPane, editorPane.getName(), editorPane.getFilePath());
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null,
						"Error reading " + filePath, "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * The openFile method opens the file specified by filename and reads its
	 * contents into the text area.
	 * 
	 * @param fileName
	 *            The name of the file to open.
	 * @throws IOException
	 */

	private String openFile(String fileName) throws IOException {
		String inputLine = "";
		String fileContent = "";
		FileReader freader;
		BufferedReader inputFile;

		// Open the file.
		freader = new FileReader(fileName);
		inputFile = new BufferedReader(freader);

		// Read the file contents into the editor.
		inputLine = inputFile.readLine();
		while (inputLine != null) {
			fileContent = fileContent + inputLine + "\n";
			inputLine = inputFile.readLine();
		}

		// Close the file.
		inputFile.close();

		return fileContent;
	}
}
