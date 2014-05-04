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
	private static final String CODABS_EXT = ".maq";
	private static final String MAQINTRUCTIONSEPARATOR = "  ";
	private static final int BEGIN_POSITION_MAQ_INSTR = 4;

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

		String f = generateOutputFilePath(inputFile);

		// This will reference one line at a time
		String line = null;

		try {
			//Open  file reader
			Scanner scanner = new Scanner(input);
			//Open file writer
			FileWriter w = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(w);
			PrintWriter wr = new PrintWriter(bw);  
			int counter = 0;
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				line= this.interpret(line);
				String hexaCounter="";
				hexaCounter=HexaConverter.decimalToBase(counter, 16, 8);
				line= hexaCounter + MAQINTRUCTIONSEPARATOR + line;
				wr.write(line); 
				//If not the last line.
				if(scanner.hasNextLine())
					wr.write("\n");
				counter++;
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

	public String generateOutputFilePath(String inputFile) {
		String result = "";		
		//		BasicConfigurator.configure();
		//        log = Logger.getLogger("UMS Log");
		//		log.warn("un warning");
		//        log.error("un error");
		result = inputFile.replace(ASM_EXT,CODABS_EXT);
		return result;
	}

	public boolean compileAssembly(String inputFile) {
		boolean result = true;
		// The name of the file to open.
		File input = new File(inputFile);
		// This will reference one line at a time
		String line = null;
		try {
			//Open  file reader
			Scanner scanner = new Scanner(input);

			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				if(!this.checkAssemblyLine(line))
					result=false;				
			}	

			// Always close files.
			scanner.close();
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

		return result;
	}

	private boolean checkAssemblyLine(String inst) {
		return SyntaxChecker.checkAssembly(inst);
	}

	public boolean compileMachinecode(String inputFile) {
		boolean result = true;
		// The name of the file to open.
		File input = new File(inputFile);
		// This will reference one line at a time
		String line = null;
		try {
			//Open  file reader
			Scanner scanner = new Scanner(input);

			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				if(!this.checkMachineLine(line))
					result=false;				
			}	

			// Always close files.
			scanner.close();
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

		return result;
	}

	private boolean checkMachineLine(String line) {
		return SyntaxChecker.checkMaq(line);
	}

	public String appendMemoryAddress(String textContent) {
		String result= "";
		int counter=0;

		Scanner scanner = new Scanner(textContent);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String hexaCounter="";
			hexaCounter=HexaConverter.decimalToBase(counter, 16, 8);
			counter++;
			if(scanner.hasNextLine())
				line = line + "\n";
			result += hexaCounter + MAQINTRUCTIONSEPARATOR + line;		  
		}
		scanner.close();		
		return result;
	}

	public String removeMemoryAddresses(String fileContent) {
		String result= "";
		Scanner scanner = new Scanner(fileContent);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			line = line.substring(BEGIN_POSITION_MAQ_INSTR);
			if(scanner.hasNextLine())
				line = line + "\n";
			result +=line;		  
		}
		scanner.close();		
		return result;	
	}



}
