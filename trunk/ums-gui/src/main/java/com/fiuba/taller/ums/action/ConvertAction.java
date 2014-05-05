package com.fiuba.taller.ums.action;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import com.fiuba.taller.ums.MainLogger;
import com.fiuba.taller.ums.ProgramInterpreter;
import com.fiuba.taller.ums.UmsEditorGui;
import com.fiuba.taller.ums.common.FileType;
import com.fiuba.taller.ums.component.FileEditorPane;
import com.fiuba.taller.ums.component.JTextPaneAppender;

public class ConvertAction implements ActionListener {

	private static final String TEMPASMFILE = "default.asm";
	private static final String TEMPMAQFILE = "default.maq";
	private UmsEditorGui editorUmsGui;

	public ConvertAction(UmsEditorGui editorUmsGui) {
		this.editorUmsGui = editorUmsGui;
	}

	public void actionPerformed(ActionEvent arg0) {

		FileEditorPane textEditor = (FileEditorPane) editorUmsGui
				.getMultiTabPane().getSelectedTab();
		if (textEditor != null) {
			// Solo si se trata de un assembler.
			if (textEditor.getFileType() == FileType.ASSEMBLER) {

				String textContent = textEditor.getContent();
				// Get filepath if exists, if not use temp
				String filepath = textEditor.getFilePath();
				if (filepath == null)
					filepath = TEMPASMFILE;

				JFrame frame = new JFrame();
				frame.setTitle("Convertion Log");
				frame.setBounds(0, 0, 200, 300);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				JTextPane editorText = new JTextPane();
				editorText.setEditable(false);
				JScrollPane scrollPane = new JScrollPane(editorText);
				frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

				frame.setVisible(true);

				MainLogger.init(new JTextPaneAppender(editorText),
						org.apache.log4j.Level.TRACE);

				ProgramInterpreter pi = new ProgramInterpreter();

				// Save file
				if (saveFile(filepath, textContent)) {
					// Compilar (chequear sintaxis)

					if (!pi.compileAssembly(filepath)) {
						// Cancelar conversion y mostrar error.
					} else {
						// Generar el maq
						pi.generateAbsoluteCodeFile(filepath);
						String maqFilePath = pi
								.generateOutputFilePath(filepath);
						String fileName = maqFilePath.substring(maqFilePath
								.lastIndexOf('\\') + 1);
						FileType fileType;
						try {
							// Abrir el archivo creado
							String fileContent = openFile(maqFilePath);
							fileType = FileType.MACHINE_CODE;
							// Memory addresses removed from string of maq file.
							fileContent = pi.removeMemoryAddresses(fileContent);
							// Devolverlo a la pantalla
							FileEditorPane editorPane = new FileEditorPane(
									fileName, maqFilePath, fileContent,
									fileType, true);
							editorUmsGui.getMultiTabPane().addTab(editorPane,
									editorPane.getName(),
									editorPane.getFilePath());
						} catch (IOException ex) {
							JOptionPane.showMessageDialog(null,
									"Error reading " + maqFilePath, "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}
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
