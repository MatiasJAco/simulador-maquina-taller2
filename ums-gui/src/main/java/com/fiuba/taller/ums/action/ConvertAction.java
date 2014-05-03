package com.fiuba.taller.ums.action;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import com.fiuba.taller.ums.ProgramInterpreter;
import com.fiuba.taller.ums.SyntaxChecker;
import com.fiuba.taller.ums.UmsEditorGui;
import com.fiuba.taller.ums.component.FileEditorPane;

public class ConvertAction implements ActionListener {

	private static final String TEMPASMFILE = "c:\\\\Temp\\\\test.asm";
	private UmsEditorGui editorUmsGui;
	
	public ConvertAction(UmsEditorGui editorUmsGui) {
		this.editorUmsGui = editorUmsGui;
	}

	public void actionPerformed(ActionEvent arg0) {
		//guardar archivo
		FileEditorPane textEditor = (FileEditorPane) editorUmsGui
				.getMultiTabPane().getSelectedTab();
		String textContent = textEditor.getContent();
		if(saveFile(TEMPASMFILE, textContent)){
			//Compilar (chequear sintaxis)
			ProgramInterpreter pi = new ProgramInterpreter();
			if(!pi.compileAssembly(TEMPASMFILE)){
				//Cancelar conversion y mostrar error.
			}else{
				//Generar el maq
				pi.generateAbsoluteCodeFile(TEMPASMFILE);
				//Devolverlo a la pantalla
				
				};
		};
		
		
		
		
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setTitle("Convertion Log");
		frame.setBounds(0, 0,
				200, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JTextPane editorText = new JTextPane();
		editorText.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(editorText);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		frame.setVisible(true);
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
