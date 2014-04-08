package com.fiuba.taller.ums;

public class FPUnit {

	static final int BITS_MANTISA = 4;
	static final int BITS_EXPONENTE = 3;
	static final int BITS_SIGNO = 1;
	
	static float puntoFlotanteADecimal(String numeroHexa){
		//TODO Control de errores
		float result = 0;
		//Recibe numero en hexa y lo pasa a binario(punto flotante)
		String myBinary = HexaConverter.hexaToBinary(numeroHexa);		
		//Del string punto flotante separo signo, mantisa y exponente
		String signo = myBinary.substring(0,BITS_SIGNO);
		String exponente = myBinary.substring(BITS_SIGNO,BITS_SIGNO+BITS_EXPONENTE);
		String mantisa = myBinary.substring(BITS_SIGNO+BITS_EXPONENTE,BITS_SIGNO+BITS_EXPONENTE+BITS_MANTISA);
		int matSigno=1;
		//Cambiar polaridad de matSigno si signo es 0;
		
		
		//Calcula exponente
		int matExpo= HexaConverter.baseToDecimal(exponente,2);
		//Calcula mantisa
		int matMantisa = HexaConverter.baseToDecimal(mantisa,2);
		
		
		
		//Calculo del valor
		
		return result;
		
	}

	private static String hexaToBinary(String numeroHexa) {
		// TODO Auto-generated method stub
		String result = "";
		
		
		return result;
	};
	
	
}
