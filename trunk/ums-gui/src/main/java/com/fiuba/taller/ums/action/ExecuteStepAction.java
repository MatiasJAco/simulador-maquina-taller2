package com.fiuba.taller.ums.action;

import com.fiuba.taller.ums.common.FileType;
import com.fiuba.taller.ums.component.EmulatorComponent;
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

import com.fiuba.taller.ums.CicloFetchPasoAPasoThread;
import com.fiuba.taller.ums.CicloFetchThread;
import com.fiuba.taller.ums.ControlUnit;
import com.fiuba.taller.ums.CycleController;
import com.fiuba.taller.ums.Memory;
import com.fiuba.taller.ums.ProgramInterpreter;
import com.fiuba.taller.ums.UmsEditorGui;
import com.fiuba.taller.ums.component.FileEditorPane;

public class ExecuteStepAction implements ActionListener {
	private static final String TEMPASMFILE = "input.asm";
	private static final String TEMPMAQFILE = "input.maq";
	private UmsEditorGui editorUmsGui;

	public ExecuteStepAction(UmsEditorGui editorUmsGui) {
		this.editorUmsGui = editorUmsGui;
	}

	public void actionPerformed(ActionEvent arg0) {
		if((FileEditorPane) editorUmsGui.getMultiTabPane().getSelectedTab()!= null){
		JFrame compilationLogFrame = new JFrame();
		compilationLogFrame.setTitle("Compilation Log");
		compilationLogFrame.setBounds(0, 0,
				600, 700);
		compilationLogFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JTextPane editorText = new JTextPane();
		editorText.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(editorText);
		compilationLogFrame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		compilationLogFrame.setVisible(true);

		MainLogger.init(
				new JTextPaneAppender(editorText),
				org.apache.log4j.Level.TRACE);

		//guardar archivo
		FileEditorPane textEditor = (FileEditorPane) editorUmsGui
				.getMultiTabPane().getSelectedTab();
		String textContent = textEditor.getContent();
		String tempfile="";
		if (textEditor.getFileType() == FileType.ASSEMBLER){
			tempfile=TEMPASMFILE;
			MainLogger.logError("Convierta el programa a lenguaje maquina para ejecutar. ");
			}
		else{
			tempfile=TEMPMAQFILE;
			//Memory addresses added to  string of maq file.
			ProgramInterpreter pi = new ProgramInterpreter();	
			textContent = pi.appendMemoryAddress(textContent);
		}

		//Cargar en memoria
		
		if(saveFile(tempfile, textContent) && textEditor.getFileType() == FileType.MACHINE_CODE){
			//Compilar (chequear sintaxis)
			ProgramInterpreter pi = new ProgramInterpreter();
			boolean compileSuccesfull=false;
			Memory myMemory = new Memory() ;
			ControlUnit myControlUnit = new ControlUnit(myMemory);
			CycleController usin = new CycleController();
			if (textEditor.getFileType() == FileType.MACHINE_CODE)
				compileSuccesfull=pi.compileMachinecode(tempfile);
			if(compileSuccesfull){
				
//				myControlUnit.loadProgramToMemory(tempfile);
//				while(!myControlUnit.isProgramEnded()){
//					myControlUnit.fetchInstruction();
//					myControlUnit.decode();
//					myControlUnit.executeCurrentInstruction();
//				}
//				MainLogger.logTrace(myControlUnit.dumpMemory());
				
				CicloFetchPasoAPasoThread hiloFetch = new CicloFetchPasoAPasoThread(tempfile,usin,myControlUnit);
				hiloFetch.start();
				
				
			}
			
			//Execution window of the emulator
			JFrame emulatorFrame = new EmulatorComponent(myControlUnit,usin);
			emulatorFrame.setTitle("Emulator");
			emulatorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			emulatorFrame.setVisible(true);
		};
		
		
		
		}
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
