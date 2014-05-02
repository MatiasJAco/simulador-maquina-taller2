package com.fiuba.taller.ums;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class ProgramInterpreter {
	private Logger log;
	private static final String FILESYSTEM_SEPARATOR = "\\\\";
	private static final String ASM_EXT = ".asm";
	private static final String CODABS_EXT = ".mq";

	public ProgramInterpreter() {
		BasicConfigurator.configure();
		log = Logger.getLogger("UMS Log");
	}

	public String interpret (String inst) throws InputFileFormatException{
		//ldm R,XY
		String result="";
		
		if(SyntaxChecker.checkAssembly(inst)){
			result = SyntaxChecker.getMaqInstruction(inst);
		}else{
			result = "ERROR";
		}
		
		

		return result;
	}
	

	public void generateAbsoluteCodeFile(String inputFile) {
		// The name of the file to open.
		File input = new File(inputFile);

		String f = generateOutputFilename(inputFile);

		// This will reference one line at a time
		String line = null;

		try {
			//Open  file reader
			Scanner scanner = new Scanner(input);
			//Open file writer
			FileWriter w = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(w);
			PrintWriter wr = new PrintWriter(bw);  

			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				line= this.interpret(line);
				wr.write(line); 
				//If not the last line.
				if(scanner.hasNextLine())
					wr.write("\n");
			}	

			// Always close files.
			
			scanner.close();

			wr.close();

			bw.close();

		}
		catch(FileNotFoundException ex) {
			System.out.println(
					"Unable to open file '" + 
							input + "'");				
		}
		catch(IOException ex) {
			System.out.println(
					"Error reading file '" 
							+ input + "'");					
			// Or we could just do this: 
			// ex.printStackTrace();
		}
	}

	private String generateOutputFilename(String inputFile) {
		String result = "";		
//		BasicConfigurator.configure();
//        log = Logger.getLogger("UMS Log");
//		log.warn("un warning");
//        log.error("un error");
		result = inputFile.replace(ASM_EXT,CODABS_EXT);
		return result;
	}




}
