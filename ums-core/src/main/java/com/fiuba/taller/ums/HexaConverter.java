package com.fiuba.taller.ums;

public class HexaConverter {

	private static int ipow(int base, int exp)
	{
	    int result = 1;
	    while (exp != 0)
	    {
	        if ((exp & 1) == 1)
	            result *= base;
	        exp >>= 1;
	        base *= base;
	    }

	    return result;
	}

	private static int hexaCharToInt(char hexaNum) {
		int result = 0;
		switch (hexaNum) {
		case 'A': 
			result = 10;	
			break;
		case 'B': 
			result = 11;	
			break;
		case 'C': 
			result = 12;	
			break;
		case 'D': 
			result = 13;	
			break;
		case 'E': 
			result = 14;	
			break;
		case 'F': 
			result = 15;	
			break;
		default:
			result = Character.getNumericValue(hexaNum);
			break;
		}  
		return result;
	};

	
	public static int baseToDecimal(String aNum,int base ){
		//Obtener longitud de la cadena
		//Recorrer traduciendo cada caracter y sumando
		int result = 0;
		int longNum= aNum.length();
		for (int i =longNum-1;i>=0;i--){
			int currentDigit=hexaCharToInt(aNum.charAt(i));
			int exponent = longNum - i - 1;
			result += currentDigit* ipow(base,exponent);			
		}
		return result;
	}

	public static String decimalToBase(int decNum, int base, int cantBits) {
		String result = "";
		int cocienteEntero= decNum;
		while (cocienteEntero >= base) {
//			int cocienteInicial = cocienteEntero;
			float cociente= cocienteEntero / base;
			int resto= cocienteEntero % base;
			//Extrae parte entera
			cocienteEntero = (int)cociente;
			String addToHexa = "";
			if (cocienteEntero >= base){				
				addToHexa = "" + hexaIntToChar(resto);			
			}else{
				addToHexa = "" + hexaIntToChar(cocienteEntero) + hexaIntToChar(resto);	
			}			
			
			result= addToHexa + result;
		}
		
		//Chequear alcanzar cantidad de bits minimo
		double bitAdjust = Math.log10(base)/Math.log10(2);
		if (result.length()*bitAdjust < cantBits ){
			
			while (result.length()*bitAdjust < cantBits ){
				result = "0" + result; 
			}
		}
		
		return result;
	}

	public static String decimalToBase(int decNum, int base) {
		return decimalToBase(decNum, base, 8);		
	}
	
	private static char hexaIntToChar(int decDigit) {
		char result;
		switch (decDigit) {
		case 10: 
			result = 'A';	
			break;
		case 11: 
			result = 'B';	
			break;
		case 12: 
			result = 'C';	
			break;
		case 13: 
			result = 'D';	
			break;
		case 14: 
			result = 'E';	
			break;
		case 15: 
			result = 'F';	
			break;
		default:
			result = Character.forDigit(decDigit, 10);
			break;
		}  
		return result;
	}
	
	public static String hexaToBinary(String hexaNum){
		return decimalToBase(baseToDecimal(hexaNum, 16), 2);		
	}

	
}
