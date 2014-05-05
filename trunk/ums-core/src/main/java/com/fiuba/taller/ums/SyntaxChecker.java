package com.fiuba.taller.ums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class SyntaxChecker {

	private static final int SECOND_PARAMETER = 1;

	private static final char JUMP_OP_CODE = 'B';

	private static final String COMMENTARY_SEPARATOR = "#";

	private static final int MINIMUM_INST_LENGHT = 3;


	private static Logger log;
	//	private MainLogger mlogger;

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


	private static final Set<String> ASSEMBLYVALUES = new HashSet<String>(Arrays.asList(
			new String[] {"ldm","ldi" ,"stm","cop" ,"add" ,"addf","or","and","xor","rotd","jpz","ret"}));                  

	private static final String  HEXAVALUES= "0123456789ABCDEF";
	private static final String  HEXASPECIALVALUES= "ABCDEF";

	private static final String  MAQVALUES= "123456789ABC";

	private static final String ASSEMBLYSEPARATOR = " ";

	private static final String MAQSEPARATOR = "  ";

	private static final int BEGIN_POSITION_MAQ_INSTR = 4;

	public static boolean checkAssembly(String inst) {
		boolean result=true;
		//Procesar posible comentario
		inst=getInstructionFromLine(inst);

		if (inst != null){
			MainLogger.logInfo("Verificando sintaxis de instruccion : "+ inst);

			String[] instructionArray = inst.split(ASSEMBLYSEPARATOR);
			String instName = instructionArray[0];
			instName = instName.toLowerCase();
			String instParam="";
			if (instructionArray.length > 1)
				instParam = instructionArray[1];
			instParam=instParam.replaceAll("\\s","");
			if(ASSEMBLYVALUES.contains(instName))
				result=validateParametersAssembly(instParam,instName);
			else{
				MainLogger.logError("No se reconoce la instruccion: "+instName+" .");
				result = false;
			}

			if (!result)
				MainLogger.logError("Error al interpretar la instruccion: "+inst+" .");
			else
				MainLogger.logInfo("Sintaxis correcta");
		}
		return result;
	}

	public static boolean checkMaq(String inst) {

		boolean result=true;

		inst=inst.substring(BEGIN_POSITION_MAQ_INSTR);
		//Procesar posible comentario
		inst=getInstructionFromLine(inst);
		inst = inst.replaceAll("\\s","");
		if (inst != null){

			MainLogger.logInfo("Verificando sintaxis de instruccion : "+ inst);


			char opCode = inst.charAt(0);
			String instParam=inst.substring(1);
			if(MAQVALUES.contains(Character.toString(opCode)))
				result=validateParametersMaq(instParam, opCode);
			else{
				MainLogger.logError("No se reconoce el codigo de operacion: "+opCode+" .");
				result=false;
			}

			if (!result)
				MainLogger.logError("Error al interpretar la instruccion: "+inst+" .");
			else
				MainLogger.logInfo("Sintaxis correcta");
		}
		return result;

	}

	public static String getMaqInstruction(String inst, HashMap<String, String> tags) {
		String result= "";
		String comment="";
		//Procesar posible comentario
		comment =getCommentaryFromLine(inst);
		inst=getInstructionFromLine(inst);
		if (inst != null){
			MainLogger.logInfo("Traduciendo a lenguaje maquina: "+ inst);
			String[] instructionArray = inst.split(" ");
			String instName = instructionArray[0];
			String instParam="";
			if (instructionArray.length > 1)
				instParam = instructionArray[1];
			instParam = instParam.replaceAll("\\s","");
			instName = instName.toLowerCase();
			String opCode = getOpCode(instName);
			String param = getParameters(instParam, opCode.charAt(0), tags);
			result = opCode + param;
			MainLogger.logInfo("Traduccion completada satisfactoriamente: "+ result);
		}
		result = result + comment;
		return result;
	}

	private static String getInstructionFromLine(String inst) {
		String result=null;
		//buscar #, si existe
		if(inst.contains(COMMENTARY_SEPARATOR)){
			//si esta entre los primeros caracteres solo hay 
			//comentario en la linea y debe ser ignorada			
			if(!(inst.indexOf(COMMENTARY_SEPARATOR) < MINIMUM_INST_LENGHT)){
				String[] lineParts = inst.split(COMMENTARY_SEPARATOR);
				result = lineParts[0]; 
			};			
		}else{
			result = inst;
		};	

		return result;
	}

	private static String getCommentaryFromLine(String inst) {
		String result="";
		//buscar #, si existe
		if(inst.contains(COMMENTARY_SEPARATOR)){
			//si esta entre los primeros caracteres solo hay 
			//comentario en la linea 			
			if(!(inst.indexOf(COMMENTARY_SEPARATOR) < MINIMUM_INST_LENGHT)){
				String[] lineParts = inst.split(COMMENTARY_SEPARATOR);
				result = "  " + COMMENTARY_SEPARATOR + lineParts[1]; 
			}else{
				result = inst;	
			};

		};	

		return result;
	}

	private static boolean validateParametersMaq(String instParam, char opCode) {
		boolean result=true;
		String[] paramArray = instParam.split("(?!^)");

		if (validarCantidadParametros(paramArray, opCode)){


			if(!validarSpecificParameters(instParam,opCode) || !validarValorHexa(instParam) ){
				result=false;

			}
		}else{
			result=false;
		}
		return result;
	}

	private static boolean validarSpecificParameters(String instParam, char opCode) {
		boolean result = false;
		switch (opCode){
		case 'C':
			if(instParam.equals("000"))
				result = true;
			else
				MainLogger.logError("Valor de parametros incorrecto");
			break;
		case '1':
		case '2':
		case '3':
		case 'B':
			result = true;
			break;
		case '4':
			if(instParam.charAt(0) == '0')
				result = true;
			else
				MainLogger.logError("Valor de parametros incorrecto");
			break;
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			result = true;
			break;
		case 'A':
			if(instParam.charAt(1) == '0')
				result = true;
			else
				MainLogger.logError("Valor de parametros incorrecto");
			break;
		default: break;
		}

		return result;
	}

	private static boolean validateParametersAssembly(String instParam, String instName) {
		boolean result=true;
		String[] paramArray = instParam.split(",");

		if (validarCantidadParametros(paramArray, instName)){

			for (int i = 0; i < paramArray.length ; i++){
				if (!instName.toLowerCase().equals("jpz")){
					if(!validarParameterSize(paramArray[i]) || !validarValorHexa(paramArray[i])){
						result=false;
					};
				}
			}
		}else{
			result=false;
		}
		return result;
	}



	private static boolean validarValorHexa(String s) {
		boolean result = true;
		for (int i = 0; i < s.length(); i++) {
			if (!HEXAVALUES.contains(Character.toString(s.charAt(i)))){
				result = false;
				String msg = "Valor incorrecto de parametro. No es un valor hexadecimal : " + s.charAt(i);
				MainLogger.logError(msg);
			}
		}
		return result;
	}

	private static boolean validarCantidadParametros(String[] paramArray,
			String instName) {
		boolean result = true;
		if(paramArray.length >3){
			String msg = "Cantidad de parametros excedida. Hay "+ paramArray.length + " parametros.";
			MainLogger.logError(msg);
			result = false;
		}
		if(paramArray.length <2 && !instName.equals("ret")){
			String msg = "Cantidad de parametros insuficiente. Hay "+ paramArray.length + " parametros.";
			MainLogger.logError(msg);
			result = false;
		}		

		return result;
	}



	private static String getParameters(String instParam, char opCode, HashMap<String, String> tags) {
		String[] paramArray = instParam.split(",");
		String result = "";
		//TODO traducir decimal a hexa
		for (int i = 0; i < paramArray.length ; i++){
			String param=""; 
			//			validarParameterSize(paramArray[i]);
			if (opCode == JUMP_OP_CODE && i==SECOND_PARAMETER)
				param = replacetag(paramArray[i],tags);
			else{
				//				todos menos c traducir el 0.
				if (opCode != 'C' && i == 0)
					param = getHexaValueOf(paramArray[i]);
				else{
					//				si esta en 4,5,6,7,8,9 traducir el 1
					if ("456789".contains(""+opCode) && i == 1)
						param = getHexaValueOf(paramArray[i]);	else{
							//				si esta en 5,6,7,8,9 traducir el 2	
							if ("56789".contains(""+opCode) && i == 2)
								param = getHexaValueOf(paramArray[i]);
							else
								param = paramArray[i];
						}
				}
			}

			result = result + param;
		};		
		result=parseSpecialInstructions(result,opCode);
		return result;
	}

	private static String getHexaValueOf(String param) {
		int numReg = Integer.parseInt(param);
		return HexaConverter.decimalToBase(numReg, 16, 4);
	}

	private static String replacetag(String tagName, HashMap<String, String> tags) {
		return tags.get(tagName);		
	}

	private static boolean validarParameterSize(String string) throws InstructionParametersException {
		boolean result =true;
		if (string.length() > 2){

			String msg = "Tamanio de parametro excedido. Supera los 2 bytes. Tamanio: " + string.length() + ".";
			MainLogger.logError(msg);
			MainLogger.logWarn("Parametro: "+ string);
			result = false;
			//			throw new InstructionParametersException(msg);

		}
		return result;

	}

	private static boolean validarCantidadParametros(String[] paramArray, char opCode) throws InstructionParametersException {
		boolean result = true;
		if(paramArray.length >3){
			String msg = "Cantidad de parametros excedida. Hay "+ paramArray.length + " parametros.";
			MainLogger.logError(msg);
			result = false;			
		}
		if(paramArray.length <3 ){
			String msg = "Cantidad de parametros insuficiente. Hay "+ paramArray.length + " parametros.";
			MainLogger.logError(msg);
			result = false;			
		}
		return result;		
	}

	private static String parseSpecialInstructions(String result, char opCode) {
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

	private static String getOpCode (String instName) throws InputFileFormatException {
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

			MainLogger.logError("El archivo input no tiene el formato aceptado.");

		}
		catch(IllegalArgumentException exc){
			MainLogger.logError("El archivo input no tiene el formato aceptado.");
			return "X";
		}
		return result;
	}	

	static boolean isTagLine(String line) {
		boolean result = false;
		if(line.contains(":") && !line.contains(COMMENTARY_SEPARATOR))
			result=true;
		return result;
	}

	public static boolean isCommentLine(String line) {

		return getCommentaryFromLine(line).equals(line);

	}

}
