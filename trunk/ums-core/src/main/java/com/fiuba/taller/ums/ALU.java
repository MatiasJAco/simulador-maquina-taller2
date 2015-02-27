package com.fiuba.taller.ums;

import javax.swing.tree.ExpandVetoException;

public class ALU {

	private static final int MANTISA_LENGHT = 4;
	private boolean overflow;
	public ObservableOverflow getObsOverflow() {
		return obsOverflow;
	}

	public void setObsOverflow(ObservableOverflow obsOverflow) {
		this.obsOverflow = obsOverflow;
	}

	public ObservablePrecision getObsPrec() {
		return obsPrec;
	}

	public void setObsPrec(ObservablePrecision obsPrec) {
		this.obsPrec = obsPrec;
	}

	private ObservableOverflow obsOverflow;
	private ObservablePrecision obsPrec;
	
	public int getBitsPrecisionPerdidos() {
		return bitsPrecisionPerdidos;
	}

	private int bitsPrecisionPerdidos;
	private ObservableRegister obsReg1;
	public ObservableRegister getObsReg1() {
		return obsReg1;
	}

	public ObservableRegister getObsReg2() {
		return obsReg2;
	}

	public ObservableRegister getObsRegRes() {
		return obsRegRes;
	}

	private ObservableRegister obsReg2;
	private ObservableRegister obsRegRes;
	private String regSrc1;
	private String regSrc2;
	private String regNumResult;
	private String result;

	
	public String getRegNumSrc1() {
		return regSrc1;
	}

	public void setRegNumSrc1(String regNumSrc1) {
		this.regSrc1 = regNumSrc1;
	}

	public String getRegNumSrc2() {
		return regSrc2;
	}

	public void setRegNumSrc2(String regNumSrc2) {
		this.regSrc2 = regNumSrc2;
	}

	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public ALU() {
		this.overflow = false;
		this.obsOverflow=new ObservableOverflow(this.overflow);
		this.bitsPrecisionPerdidos = 0;
		this.obsPrec = new ObservablePrecision(Integer.toString(this.bitsPrecisionPerdidos));
		this.setResult("");
		this.setRegNumSrc1("");
		this.setRegNumSrc2("");
		this.obsReg1 = new ObservableRegister(regSrc1);
		this.obsReg2 = new ObservableRegister(regSrc2);
		this.obsRegRes = new ObservableRegister(result);
	}

	public boolean isOverflow() {
		return overflow;
	}

	public void setOverflow(boolean overflow) {
		this.overflow = overflow;
		this.obsOverflow.setData(overflow);
	}

	public boolean isZeroReg(int i) {
		if (i == 0)
			return true;
		else
			return false;

	}

	public String sumC2(String regNumSrc1, String regNumSrc2) {
		//4 casos, ++, -- , +- de resultado positivo, +- de resultado negativo.
		//++
		this.setRegNumSrc1(regNumSrc1);
		this.setRegNumSrc2(regNumSrc2);
		this.obsReg1.setData(this.regSrc1);
		this.obsReg2.setData(this.regSrc2);
		this.setOverflow(false);
		this.bitsPrecisionPerdidos = 0;
		this.obsPrec.setData(Integer.toString(this.bitsPrecisionPerdidos));
		int result =0;
		int op1=HexaConverter.hexaToDecimalC2(regNumSrc1);
		int op2=HexaConverter.hexaToDecimalC2(regNumSrc2);
		result = op1 + op2;			
		if((result > 0 && result > 127) || (result < 0 && result < -128) )
			this.setOverflow(true);
		this.setResult(HexaConverter.decimalToBaseC2(result, 16));
		this.obsRegRes.setData(this.result);
		return this.result;
	}

	public String sumF(String regNumSrc1, String regNumSrc2) {
		this.setRegNumSrc1(regNumSrc1);
		this.setRegNumSrc2(regNumSrc2);
		this.obsReg1.setData(this.regSrc1);
		this.obsReg2.setData(this.regSrc2);
		this.setOverflow(false);
		this.bitsPrecisionPerdidos = 0;
		this.obsPrec.setData(Integer.toString(this.bitsPrecisionPerdidos));
		float result =0;
		float op1=FPUnit.puntoFlotanteADecimal(regNumSrc1);		
		float op2=FPUnit.puntoFlotanteADecimal(regNumSrc2);
		result = op1 + op2;			
		this.setOverflow(FPUnit.isOverflow(result));
//		System.out.println("Res: " + result);
		this.setResult(FPUnit.decimalAPuntoFlotante(result));
		this.obsRegRes.setData(this.result);
		return this.result;
	}

	public String sumFPrecisionCheck(String regNumSrc1, String regNumSrc2) {
		this.setRegNumSrc1(regNumSrc1);
		this.setRegNumSrc2(regNumSrc2);
		this.obsReg1.setData(this.regSrc1);
		this.obsReg2.setData(this.regSrc2);
		this.setOverflow(false);
		this.bitsPrecisionPerdidos = 0;
		this.obsPrec.setData(Integer.toString(this.bitsPrecisionPerdidos));
		//		float result =0;
		String sumando1B=HexaConverter.hexaToBinary(regNumSrc1);
		String sumando2B=HexaConverter.hexaToBinary(regNumSrc2);
		String signo1 = sumando1B.substring(0,1);
		String signo2 =	sumando2B.substring(0,1);
		String exp1Bin = sumando1B.substring(1,4);
		String exp2Bin = sumando2B.substring(1,4);
		String mantisa1 = sumando1B.substring(4);
		String mantisa2 = sumando2B.substring(4);
		int exp1Ent = HexaConverter.baseToDecimal(exp1Bin, 2);
		int exp2Ent = HexaConverter.baseToDecimal(exp2Bin, 2);
		int exp1EntInicial = HexaConverter.baseToDecimal(exp1Bin, 2);
		int exp2EntInicial = HexaConverter.baseToDecimal(exp2Bin, 2);
		mantisa1 = "1" + mantisa1;
		mantisa2 = "1" + mantisa2;

		//Detectar el de exponente menor para normalizar.
		//String aNormalizar = ;

		if(exp1Ent != exp2Ent){
			if( exp1Ent > exp2Ent ){
				this.bitsPrecisionPerdidos = (exp1Ent - exp2Ent);
				this.obsPrec.setData(Integer.toString(this.bitsPrecisionPerdidos));
				mantisa2 = normalizar(mantisa2, bitsPrecisionPerdidos );
				exp2Ent = exp1Ent;
				exp2Bin = exp1Bin;
			}else{
				this.bitsPrecisionPerdidos = (exp2Ent - exp1Ent);
				this.obsPrec.setData(Integer.toString(this.bitsPrecisionPerdidos));
				mantisa1 = normalizar(mantisa1, bitsPrecisionPerdidos );
				exp1Ent = exp2Ent;
				exp1Bin = exp2Bin;
			}
		}

//		System.out.println("Mantisa1:  " + mantisa1 +"\n" + "Mantisa2: " + mantisa2);


		//Determinar signo de la operacion
		String signo = "0";
		boolean esResta = false;
		if( signo1.equals(signo2))
			signo = signo1;
		else{			
			if(exp1EntInicial > exp2EntInicial ){
				signo = signo1;
			}else{
				if(exp1EntInicial < exp2EntInicial ){
					signo = signo2;
				}else{
					int man1Ent= HexaConverter.baseToDecimal(mantisa1,2);
					int man2Ent= HexaConverter.baseToDecimal(mantisa2,2);
					if( man1Ent > man2Ent){
						signo = signo1;
					}else{
						if( man1Ent < man2Ent){
							signo = signo2;	
						}else{
							signo = "0";
						}
					}					
				}
			}
			esResta =true;
			if(signo1.equals("1"))
				mantisa1 = complementarA2("0" + mantisa1);
			else
				mantisa2 = complementarA2("0" + mantisa2);
		}



		//Sumar las mantisas con el 1 entero incluido
		String result = sumarMantisas(esResta, signo, mantisa1, mantisa2, exp2Ent);



		//		float op1=FPUnit.puntoFlotanteADecimal(regNumSrc1);
		//		String myBinNum1 =HexaConverter.decimalToBaseF(op1, 2, 8);
		//		float op2=FPUnit.puntoFlotanteADecimal(regNumSrc2);
		//		String myBinNum2 =HexaConverter.decimalToBaseF(op2, 2, 8);
		//		
		//		
		//		result = op1 + op2;			
		//		this.setOverflow(FPUnit.isOverflow(result));
		//		return FPUnit.decimalAPuntoFlotante(result);
		this.setResult(HexaConverter.decimalToBase(HexaConverter.baseToDecimal(result, 2),16));
		this.obsRegRes.setData(this.result);
		return this.result;
	}


	private String complementarA2(String numBinario) {
		int longNum = numBinario.length();
		int tempInt = Integer.parseInt(numBinario, 2);
		tempInt = ~ tempInt;
		tempInt++;

		String result = Integer.toBinaryString(tempInt);
		if(result.length() > longNum)
			result = result.substring(result.length() - longNum);
//		System.out.println("TempInt:  " + tempInt + " MantisaInicial: " + numBinario + " Resultado: " + result);
		return result;
	}

	private String sumarMantisas(boolean esResta, String signo, String mantisa1,	String mantisa2, int exp2Ent) {
		this.setOverflow(false);
		String result = "";
		result = addBinary(mantisa1, mantisa2);
		if (esResta){
			//Por suma en complemento a 2, eliminar el bit mas significativo si salio de rango
			if(result.length() > mantisa1.length() && result.length() > mantisa2.length()){
				result = result.substring(1);
			}else					
				result = complementarA2(result);
		}
//		System.out.println("Resultados suma binaria: " + result);
		//Remover el primer 1
		//		String bitsNormalizacion = result.substring(0,result.indexOf('1')+1);
		int posPrimerUno = result.indexOf('1');
		int expAdjust = 0;
		if(posPrimerUno >= 0){
			result = result.substring(posPrimerUno+1);
			expAdjust = result.length() - MANTISA_LENGHT;
		}else{
			expAdjust = exp2Ent * -1;
		}
		//Normalizar		

		if (expAdjust != 0)
			result = normalizar(result, expAdjust);
//		System.out.println("Resultados suma normalizado: " + result);
		exp2Ent += expAdjust;

		if (exp2Ent > 7 || exp2Ent < 0)
			setOverflow(true);
		else{
			String binExp=HexaConverter.decimalToBase(exp2Ent, 2);
//			System.out.println("binExpo: " + binExp);
			result=signo +binExp.substring(5,8) + result;
		}

//		System.out.println("Resultados suma binaria final: " + result + " Exponente: " + exp2Ent);
		return result;

	}

	private String normalizar(String mantisa, int cantShifts) {
		String shiftedi =mantisa;
		//		mantisa = "1" + mantisa;

		int tempInt = Integer.parseInt(mantisa, 2);
//		System.out.println("TempInt:  " + tempInt + " Mantisa: " + mantisa + " numero de shifts: " + cantShifts);
		//		for (int j = 0; j < i; j++){			 
		if(cantShifts > 0)
			shiftedi = Integer.toBinaryString(tempInt>>cantShifts);
		else {
			cantShifts = cantShifts *-1;
			shiftedi = Integer.toBinaryString(tempInt<<cantShifts);
		}
		//		}		
		if(shiftedi.contains("1")){
			if(shiftedi.length() < MANTISA_LENGHT){
				int difLong = MANTISA_LENGHT-shiftedi.length();
				for(int i = 0; i < difLong; i++)
					shiftedi = "0" + shiftedi;
			}
		}else{
			shiftedi ="0000";	
		}
//		System.out.println("Resultado de shift:  " + shiftedi);
		return shiftedi;
	}

	private String addBinary(String a, String b) {
		if(b.indexOf('1') == -1)
			return a.indexOf('1') == -1 ? a : a.substring(a.indexOf('1'));
		int diff = Math.abs(a.length() - b.length());
		if(a.length() > b.length()) {
			for(int i = 0; i < diff; ++i)
				b = '0' + b;
		} else {
			for(int i = 0; i < diff; ++i)
				a = '0' + a;
		}

		String sum = new String();
		String carry = "0";
		for(int i = a.length() - 1; i >= 0; --i) {
			if( (a.charAt(i) == '1' && b.charAt(i) == '1') ||
					(a.charAt(i) == '0' && b.charAt(i) == '0'))
				sum = '0' + sum;
			else
				sum = '1' + sum;
			if (a.charAt(i) == '1' && b.charAt(i) == '1')
				carry = '1' + carry;
			else
				carry = '0' + carry;
		}
		return addBinary(sum, carry);
	}


	public String logicOR(String op1, String op2) {
		this.setRegNumSrc1(op1);
		this.setRegNumSrc2(op2);
		this.obsReg1.setData(this.regSrc1);
		this.obsReg2.setData(this.regSrc2);
		this.bitsPrecisionPerdidos = 0;
		this.obsPrec.setData(Integer.toString(this.bitsPrecisionPerdidos));
		this.setOverflow(false);
		int intOp1 = HexaConverter.baseToDecimal(op1, 16);
		int intOp2 = HexaConverter.baseToDecimal(op2, 16);
		int result = intOp1 | intOp2; 		
		this.setResult( HexaConverter.decimalToBase(result, 16));
		this.obsRegRes.setData(this.result);
		return this.result;
	}

	public String logicAND(String op1, String op2) {
		this.setRegNumSrc1(op1);
		this.setRegNumSrc2(op2);
		this.obsReg1.setData(this.regSrc1);
		this.obsReg2.setData(this.regSrc2);
		this.bitsPrecisionPerdidos = 0;
		this.obsPrec.setData(Integer.toString(this.bitsPrecisionPerdidos));
		this.setOverflow(false);
		int intOp1 = HexaConverter.baseToDecimal(op1, 16);
		int intOp2 = HexaConverter.baseToDecimal(op2, 16);
		int result = intOp1 & intOp2; 		
		this.setResult(HexaConverter.decimalToBase(result, 16));
		this.obsRegRes.setData(this.result);
		return this.result;
	}

	public String logicXOR(String op1, String op2) {
		this.setRegNumSrc1(op1);
		this.setRegNumSrc2(op2);
		this.obsReg1.setData(this.regSrc1);
		this.obsReg2.setData(this.regSrc2);
		this.bitsPrecisionPerdidos = 0;
		this.obsPrec.setData(Integer.toString(this.bitsPrecisionPerdidos));
		this.setOverflow(false);
		int intOp1 = HexaConverter.baseToDecimal(op1, 16);
		int intOp2 = HexaConverter.baseToDecimal(op2, 16);
		int result = intOp1 ^ intOp2;
		this.setResult(HexaConverter.decimalToBase(result, 16));
		this.obsRegRes.setData(this.result);
		return this.result;
	}

	public String rotateR(String data, String repetitions) {
		this.setRegNumSrc1(data);
		this.setRegNumSrc2(repetitions);
		this.obsReg1.setData(this.regSrc1);
		this.obsReg2.setData(this.regSrc2);
		this.bitsPrecisionPerdidos = 0;
		this.obsPrec.setData(Integer.toString(this.bitsPrecisionPerdidos));
		this.setOverflow(false);
		String binData = HexaConverter.hexaToBinary(data);
		int intRep = HexaConverter.baseToDecimal(repetitions, 16);		
		for (int i =0 ;i < intRep;i++){
			int lastBitPos = binData.length()-1;
			String lastBit = binData.substring(lastBitPos);
			binData = binData.substring(0, lastBitPos);
			binData = lastBit + binData;			
		};
		int result = HexaConverter.baseToDecimal(binData, 2);
		this.setResult(HexaConverter.decimalToBase(result, 16));
		this.obsRegRes.setData(this.result);
		return this.result;		
	}

}
