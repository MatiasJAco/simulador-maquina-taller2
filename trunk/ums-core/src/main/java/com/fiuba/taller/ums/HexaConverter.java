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
		if(cocienteEntero < base)
			result = result +  hexaIntToChar(cocienteEntero);
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


	public static float baseToDecimalF(String aNum,int base ){
		float result =0;

		//		IndexOf"."(IO.) = 2
		int indexOfPoint= aNum.indexOf(".");
		//		Remover .
		aNum=aNum.replaceAll("\\.", "");
		//		L=6
		int numLenght = aNum.length();
		//		L - IO. = 4
		//		ExponenteMenor= (L-IO.)*-1
		int minorExp=( numLenght -indexOfPoint )*-1;		
		//				for i = 0 ....
		for (int i = 0; i<numLenght;i++){
			//			exp = ExponenteMenor + i
			int exp= minorExp + i; 

			//			final = caratcter (L-1-i) ^ exp
			int currentDigit=hexaCharToInt(aNum.charAt(numLenght-1-i));			
			result += currentDigit* Math.pow(base,exp);


		}


		return result;

	}

	public static String decimalToBaseF(float num, int base, int cantBits) {
		//Funciona solo para base 2.

		String result = "";
		String fracAcum ="";
		float parteFraccionaria=num - (int)num;
		String parteEntera = decimalToBase((int)num, base,1);

		//Multiplicar por la base
		while(parteEntera.length() +1 + fracAcum.length() < cantBits && parteFraccionaria != 0){
			parteFraccionaria= parteFraccionaria * base;
			fracAcum += String.valueOf((int)parteFraccionaria);
			if(parteFraccionaria - 1 >= 0)
				parteFraccionaria = parteFraccionaria - 1;
		}
		result= parteEntera + "." + fracAcum;

		//Chequear alcanzar cantidad de bits minimo
		double bitAdjust = Math.log10(base)/Math.log10(2);
		if (result.length()*bitAdjust < cantBits ){
			while (result.length()*bitAdjust < cantBits ){
				result = "0" + result; 
			}
		}

		return result;
	}

}
