package com.fiuba.taller.ums;

public class FPUnit {

	static final int BITS_MANTISA = 4;
	static final int BITS_EXPONENTE = 3;
	static final int BITS_SIGNO = 1;
	//	static final int EXCESO = ((2^BITS_EXPONENTE)-1)/2;
	static final int EXCESO = 4;

	public static float puntoFlotanteADecimal(String numeroHexa){
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


	public static String decimalAPuntoFlotante(float num){
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
		if(exp >= -4 && exp <= 3){
//			System.out.println("MybinBum: " + myBinNum);
			String expBin = HexaConverter.decimalToBase(exp + EXCESO, 2, BITS_EXPONENTE);
			myBinNum = myBinNum.replaceAll("\\.", "");
			int index =myBinNum.indexOf("1");
			String mantisa = myBinNum.substring(index +1);
			if(mantisa.length() > BITS_MANTISA){
				mantisa = roundMantisa(mantisa);
				mantisa = mantisa.substring(0,4);			
			}else{
				if(mantisa.length() < BITS_MANTISA){
					int bitsRelleno = BITS_MANTISA - mantisa.length();
					for (int i=0; i < bitsRelleno; i++){
						mantisa = mantisa + "0";
					}
				}
			}


			//		myBinNum = result.substring(0,myBinNum.indexOf("1")) + "." + result.substring(myBinNum.indexOf("1")+1);
//			System.out.println("sign: " + sign + " exp :" + expBin + " man : "+mantisa);
			result = sign + expBin + mantisa;
		}else{
			result = "00000000";			
		}

		return HexaConverter.decimalToBase(HexaConverter.baseToDecimal(result, 2),16);

	}

	private static String roundMantisa(String mantisa) {
		//		recorrer todos los caracteres
		//		si es 1 reemplazar por 0 y seguir
		//		sino
		//		reemplazar por 1 y parar
		//
		//		si llego al comienzo de la mantisa y es 1 
		//		reemplazar por 0 y agregar un 1 al comienzo de la mantisa
		if(mantisa.charAt(BITS_MANTISA) == '1'){
			for (int i = BITS_MANTISA-1; i >=0; i--){
				if (mantisa.charAt(i) == '1'){
					mantisa = mantisa.substring(0,i)+'0'+mantisa.substring(i+1);
					if(i == 0)
						mantisa = '1' + mantisa;
				}else{
					mantisa = mantisa.substring(0,i)+'1'+mantisa.substring(i+1);
					break;
				}					
			}
		}
		return mantisa;
	}

	public static boolean isOverflow(float num){
		boolean result= false;
		if (num < 0){		
			num=num*-1;
		}
		String myBinNum =HexaConverter.decimalToBaseF(num, 2, 8);
		//Normalizar
		int difPos=myBinNum.indexOf(".")-myBinNum.indexOf("1");
		int exp=0;
		if(myBinNum.contains("1")){
			if(difPos >0)
				exp=difPos-1;
			else
				exp=difPos;
		}
		if(exp < -4 || exp > 3){
			result=true;			
		}		
		return result;		
	};


}
