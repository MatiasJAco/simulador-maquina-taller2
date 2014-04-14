package com.fiuba.taller.ums;

public class ProgramInterpreter {

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

	public String interpret(String inst) {
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
		for (int i = 0; i < paramArray.length ; i++){
			result = result + paramArray[i];					
		};		
		result=parseSpecialInstructions(result,opCode);
		return result;
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
		default: ;		
		}
		
		
		return result;
	}

	private String getOpCode(String instName) {
		String result = null;
		//switch (instName){
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
		
		return result;
	}

}
