package com.fiuba.taller.ums;

public class FPUnit {

	static final int BITS_MANTISA = 4;
	static final int BITS_EXPONENTE = 3;
	static final int BITS_SIGNO = 1;
	//	static final int EXCESO = ((2^BITS_EXPONENTE)-1)/2;
	static final int EXCESO = 4;

	static float puntoFlotanteADecimal(String numeroHexa){
		//TODO Control de errores
		float result = 0;
		//Recibe numero en hexa y lo pasa a binario(punto flotante)
		String myBinary = HexaConverter.hexaToBinary(numeroHexa);		
		//Del string punto flotante separo signo, mantisa y exponente
		String signo = myBinary.substring(0,BITS_SIGNO);
		String exponente = myBinary.substring(BITS_SIGNO,BITS_SIGNO+BITS_EXPONENTE);
		String mantisa = myBinary.substring(BITS_SIGNO+BITS_EXPONENTE,BITS_SIGNO+BITS_EXPONENTE+BITS_MANTISA);
		int matSigno=getSign(signo);
		//Cambiar polaridad de matSigno si signo es 0;

		//Calcula exponente
		int matExpo= HexaConverter.baseToDecimal(exponente,2);
		matExpo=matExpo-EXCESO;
		//Calcula mantisa
		//		int matMantisa = HexaConverter.baseToDecimal(mantisa,2);
		String numBin = getOriginalBinary(mantisa, matExpo);

		//Calculo del valor	
		result = HexaConverter.baseToDecimalF(numBin, 2) * matSigno;


		return result;

	}

	private static int getSign(String signo) {
		int result=1;
		if(signo.equals("1"))
			result=result*(-1);

		return result;
	}

	private static String getOriginalBinary(String mantisa, int matExpo) {
		String result = "1";
		if(matExpo >= 0){
			for (int i = 0; i < matExpo; i++){
				if(mantisa.length()== 0){
					result += "0";
				}else{
					result += mantisa.charAt(0);
					mantisa = mantisa.substring(1);
				}
			}
			if (mantisa.length()>0)
				result += "." + mantisa;

		}else{

			for (int i = 0; i < (matExpo*(-1)); i++){
				result = "0" + result;
			}
			result = result + mantisa;
			result = result.substring(0,0) + "." + result.substring(1); 
		}

		return result;
	}


	static String decimalAPuntoFlotante(float num){
		String result = "";
		String sign= "0";
		if (num < 0){
			sign = "1";
			num=num*-1;
		}

		String myBinNum =HexaConverter.decimalToBaseF(num, 2, 8);
		//Normalizar
		int difPos=myBinNum.indexOf(".")-myBinNum.indexOf("1");
		int exp=0;
		if(difPos >0)
			exp=difPos-1;
		else
			exp=difPos;
		
		String expBin = HexaConverter.decimalToBase(exp + EXCESO, 2, BITS_EXPONENTE);
		myBinNum = myBinNum.replaceAll("\\.", "");
		int index =myBinNum.indexOf("1");
		String mantisa = myBinNum.substring(index +1);


		//		myBinNum = result.substring(0,myBinNum.indexOf("1")) + "." + result.substring(myBinNum.indexOf("1")+1);
		result = sign + expBin + mantisa;
		return HexaConverter.decimalToBase(HexaConverter.baseToDecimal(result, 2),16);


	}


}
