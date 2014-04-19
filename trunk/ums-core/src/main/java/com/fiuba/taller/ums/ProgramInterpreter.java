package com.fiuba.taller.ums;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProgramInterpreter {

	private static final String FILESYSTEM_SEPARATOR = "\\\\";
	private static final String ASM_EXT = ".asm";
	private static final String CODABS_EXT = ".mq";

	private enum MustUseSwitch{
		LDM,
		LDI, 
		STM, 
		COP, 
		ADD, 
		ADDF,
		OR,
		AND,
		XOR, 
		ROTD,
		JPZ, 
		RET;	    
	}

	String censura(String texto, String tabu, int tipo){ 

		while(texto.contains(tabu))
		{
			int inicio = texto.indexOf(tabu);
			int fin = inicio + tabu.length();
			StringBuffer aux = new StringBuffer();
			switch(tipo){
			case 0 : { 
				texto=texto.substring(0,inicio).concat(texto.substring(fin));
				texto=texto.trim();
				break;
			}
			case 1 : {
				for (int i = 0; i < tabu.length(); i++) aux.append('*');				
				texto.replace(tabu, aux);
				break;
			}
			default :break; 
			}
		}

		return texto;
	}

	public String interpret (String inst) throws InputFileFormatException{
		//ldm R,XY
		String[] instructionArray = inst.split(" ");
		String instName = instructionArray[0];
		String instParam="";
		if (instructionArray.length > 1)
			instParam = instructionArray[1];
		String opCode = this.getOpCode(instName);
		String param = this.getParameters(instParam, opCode.charAt(0));
		String result = opCode + param;

		return result;
	}

	private String getParameters(String instParam, char opCode) {
		String[] paramArray = instParam.split(",");
		String result = "";
		try{
			validarCantidadParametros(paramArray, opCode);
		}
		catch (InstructionParametersException ex){
			System.out.println(ex.getMessage());
			return ex.getMessage();
		}
		for (int i = 0; i < paramArray.length ; i++){
			try {
				validarParameterSize(paramArray[i]);
				result = result + paramArray[i];
			}catch (InstructionParametersException ex){
				System.out.println(ex.getMessage());
				return ex.getMessage();
			}

		};		
		result=parseSpecialInstructions(result,opCode);
		return result;
	}

	private void validarParameterSize(String string) throws InstructionParametersException {
		if (string.length() > 2){
			String msg = "Tamanio de parametro excedido. Supera los 2 bytes. Tamanio: " + string.length() + ".";
			throw new InstructionParametersException(msg);
		}

	}

	private void validarCantidadParametros(String[] paramArray, char opCode) throws InstructionParametersException {
		if(paramArray.length >3){
			String msg = "Cantidad de parametros excedida. Hay "+ paramArray.length + " parametros.";
			throw new InstructionParametersException(msg);
		}
		if(paramArray.length <2 && opCode != 'C'){
			String msg = "Cantidad de parametros insuficiente. Hay "+ paramArray.length + " parametros.";
			throw new InstructionParametersException(msg);
		}		
	}

	private String parseSpecialInstructions(String result, char opCode) {
		switch (opCode){
		case '4':
			result = '0' + result;
			break;
		case 'A':
			result = result.substring(0, 1)+ '0' + result.substring(1, result.length());
			break;
		case 'C':
			result = result + "000";
			break;
		case 'X':
			result = "ERROR";
		default: ;		
		}


		return result;
	}

	private String getOpCode (String instName) throws InputFileFormatException {
		String result = null;
		//switch (instName){
		try{
			switch(MustUseSwitch.valueOf(instName.toUpperCase())){
			case LDM:
				result="1";
				break;
			case LDI: 
				result="2";
				break;
			case STM:
				result="3";
				break;
			case COP:
				result="4";
				break;
			case ADD:
				result="5";
				break;
			case ADDF:
				result="6";
				break;
			case OR:
				result="7";
				break;
			case AND:
				result="8";
				break;
			case XOR:
				result="9";
				break;
			case ROTD:
				result="A";
				break;
			case JPZ:
				result="B";
				break;
			case RET:
				result="C";
				break;		
			default:break;		

			}
		}catch(InputFileFormatException exc){
			System.out.println("El archivo input no tiene el formato aceptado.");

		}
		catch(IllegalArgumentException exc){
			System.out.println("El archivo input no tiene el formato aceptado.");
			return "X";
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
		result = inputFile.replace(ASM_EXT,CODABS_EXT);
		return result;
	}




}
