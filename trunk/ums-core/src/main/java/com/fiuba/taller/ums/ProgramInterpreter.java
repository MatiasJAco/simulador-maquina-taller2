package com.fiuba.taller.ums;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class ProgramInterpreter {
//	private Logger log;
	private static final String FILESYSTEM_SEPARATOR = "\\\\";
	private static final String ASM_EXT = ".asm";
	private static final String CODABS_EXT = ".maq";
	private static final String MAQINTRUCTIONSEPARATOR = "  ";
	private static final int BEGIN_POSITION_MAQ_INSTR = 4;
	private HashMap<String, String> tags; 


	public ProgramInterpreter() {
//		BasicConfigurator.configure();
//		log = Logger.getLogger("UMS Log");
		tags = new HashMap<String, String>();
	}

	public String interpret (String inst, HashMap<String, String> tags) throws InputFileFormatException{
		//ldm R,XY
		String result="";

		if(SyntaxChecker.checkAssembly(inst)){
			result = SyntaxChecker.getMaqInstruction(inst,tags);
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
			collectTags(input);
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				if (!emptyLine(line) &&  !SyntaxChecker.isCommentLine(line)){
					if(SyntaxChecker.isTagLine(line)){
						String[] lineParts = line.split(":");												
						line = lineParts[1];
						if(line.charAt(0) == ' ')
							line = line.substring(1);
						//MainLogger.logInfo("Instruccion :" + inst);
					}
					line= this.interpret(line,tags);
					String hexaCounter="";
					hexaCounter=HexaConverter.decimalToBase(counter, 16, 8);
					line= hexaCounter + MAQINTRUCTIONSEPARATOR + line;
					wr.write(line); 
					//If not the last line.
					if(scanner.hasNextLine())
						wr.write("\n");
					counter++;
					counter++;
				}else{
					wr.write(line);
					if(scanner.hasNextLine())
						wr.write("\n");
				}
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



	private void collectTags(File input) {
		Scanner scanner;		
		try {
			boolean tagRead = false;
			scanner = new Scanner(input);
			int counter = 0;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String newTag = "";
				if(SyntaxChecker.isTagLine(line)){
					tagRead = true;
					String[] lineParts = line.split(":");
					newTag=lineParts[0];						
				}
				String hexaCounter="";
				hexaCounter=HexaConverter.decimalToBase(counter, 16, 8);
				if (tagRead){
					String newTagAddress = hexaCounter;
					tags.put(newTag, newTagAddress);
					tagRead =false;
				}
				counter++;
				counter++;				
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		int lineCount = 1;
		int errorCount = 0;
		// The name of the file to open.
		File input = new File(inputFile);
		// This will reference one line at a time
		String line = null;
		try {
			//Open  file reader
			Scanner scanner = new Scanner(input);

			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				if (!emptyLine(line) && !SyntaxChecker.isCommentLine(line)){
					String inst = "";
					if(SyntaxChecker.isTagLine(line)){
						String[] splittedLine = line.split(":");
						inst = splittedLine[1];
						if(inst.charAt(0) == ' ')
							inst = inst.substring(1);						
					}else
						inst = line;
					if(!this.checkAssemblyLine(inst)){
						result=false;
						errorCount++;
					}
				};
				if(emptyLine(line)){
					result=false;
					MainLogger.logError("Linea en blanco detectada. Numero de linea: " + lineCount );
					errorCount++;
					break;
				}
				if(SyntaxChecker.isCommentLine(line)){
					result=false;
					MainLogger.logError("Linea de comentario detectada. Numero de linea: " + lineCount );
					errorCount++;
					break;
				}
				lineCount++;

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
		if (errorCount > 0)
			MainLogger.logError("Lineas procesadas: " + (lineCount-1) + "  Errores detectados: " + errorCount);
		else
			MainLogger.logInfo("Lineas procesadas: " + (lineCount-1) + "  Errores detectados: " + errorCount);
		return result;
	}

	public boolean compileMachinecode(String inputFile) {
		boolean result = true;
		int lineCount = 0;
		// The name of the file to open.
		File input = new File(inputFile);
		// This will reference one line at a time
		String line = null;
		try {
			//Open  file reader
			Scanner scanner = new Scanner(input);

			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				if (!emptyLine(line) && !SyntaxChecker.isCommentLine(line)){
					if(!this.checkMachineLine(line))
						result=false;		
				}
				if(emptyLine(line)){
					result=false;
					MainLogger.logError("Linea en blanco detectada. Numero de posicion: " + HexaConverter.decimalToBase(lineCount, 16) );
					break;
				}
				if(SyntaxChecker.isCommentLine(line)){
					result=false;
					MainLogger.logError("Linea de comentario detectada. Numero de posicion: " + HexaConverter.decimalToBase(lineCount, 16) );
					break;
				}

				lineCount++;
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

	private boolean emptyLine(String line) {
		if (line==null) return true;
		if (line.length()==0) return true;
		if (line.trim().length()==0) return true;
		for (int n=0;n<line.length();n++)
			if (!(line.charAt(n) == ' ')) return false;
		return true;
	}

	private boolean checkAssemblyLine(String inst) {
		return SyntaxChecker.checkAssembly(inst);
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
			if (!emptyLine(line) && !SyntaxChecker.isCommentLine(line)){
				String hexaCounter="";
				hexaCounter=HexaConverter.decimalToBase(counter, 16, 8);
				counter++;
				if(scanner.hasNextLine())
					line = line + "\n";
				result += hexaCounter + MAQINTRUCTIONSEPARATOR + line;
			}else {				
				if(scanner.hasNextLine())
					line = line + "\n";
				result += line;
			}		  
		}
		scanner.close();		
		return result;
	}

	public String removeMemoryAddresses(String fileContent) {
		String result= "";
		Scanner scanner = new Scanner(fileContent);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (!emptyLine(line) && !SyntaxChecker.isCommentLine(line)){
				line = line.substring(BEGIN_POSITION_MAQ_INSTR);
				if(scanner.hasNextLine())
					line = line + "\n";
				result +=line;
			}else {				
				if(scanner.hasNextLine())
					line = line + "\n";
				result += line;
			}
		}
		scanner.close();		
		return result;	
	}

	public String interpret(String inst) {

		return this.interpret(inst, new HashMap<String,String>());
	}



}
