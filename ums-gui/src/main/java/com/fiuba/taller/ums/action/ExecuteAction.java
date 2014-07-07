package com.fiuba.taller.ums.action;

import com.fiuba.taller.ums.common.FileType;
import com.fiuba.taller.ums.component.JTextPaneAppender;
import com.fiuba.taller.ums.MainLogger;

import java.awt.BorderLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import com.fiuba.taller.ums.ControlUnit;
import com.fiuba.taller.ums.Memory;
import com.fiuba.taller.ums.ProgramInterpreter;
import com.fiuba.taller.ums.UmsEditorGui;
import com.fiuba.taller.ums.component.FileEditorPane;

public class ExecuteAction implements ActionListener {
	private static final String TEMPASMFILE = "input.asm";
	private static final String TEMPMAQFILE = "input.maq";
	private UmsEditorGui editorUmsGui;

	public ExecuteAction(UmsEditorGui editorUmsGui) {
		this.editorUmsGui = editorUmsGui;
	}

	public void actionPerformed(ActionEvent arg0) {
		JFrame frame = new JFrame();
		frame.setTitle("Compilation Log");
		frame.setBounds(0, 0,
				600, 700);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JTextPane editorText = new JTextPane();
		editorText.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(editorText);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		frame.setVisible(true);

		MainLogger.init(
				new JTextPaneAppender(editorText),
				org.apache.log4j.Level.TRACE);

		//guardar archivo
		FileEditorPane textEditor = (FileEditorPane) editorUmsGui
				.getMultiTabPane().getSelectedTab();
		String textContent = textEditor.getContent();
		String tempfile="";
		if (textEditor.getFileType() == FileType.ASSEMBLER)
			tempfile=TEMPASMFILE;
		else{
			tempfile=TEMPMAQFILE;
			//Memory addresses added to  string of maq file.
			ProgramInterpreter pi = new ProgramInterpreter();	
			textContent = pi.appendMemoryAddress(textContent);
		}


		if(saveFile(tempfile, textContent)){
			//Compilar (chequear sintaxis)
			ProgramInterpreter pi = new ProgramInterpreter();
			boolean compileSuccesfull=true;
			if (textEditor.getFileType() == FileType.MACHINE_CODE)
				compileSuccesfull=pi.compileMachinecode(tempfile);
			if(compileSuccesfull){
				//Cargar en memoria
				Memory myMemory = new Memory() ;
				ControlUnit myControlUnit = new ControlUnit(myMemory);
				myControlUnit.loadProgramToMemory(tempfile);
				while(!myControlUnit.isProgramEnded()){
					myControlUnit.fetchInstruction();
					myControlUnit.decode();
					myControlUnit.executeCurrentInstruction();
				}
//				MainLogger.logTrace(myControlUnit.dumpMemory());
			}
		};
		// TODO Auto-generated method stub
	}



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
