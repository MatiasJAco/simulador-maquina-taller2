package com.fiuba.taller.ums;

public class ALU {

	private boolean overflow;

	public ALU() {
		this.overflow = false;
	}

	public boolean isOverflow() {
		return overflow;
	}

	public void setOverflow(boolean overflow) {
		this.overflow = overflow;
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
		this.setOverflow(false);
		int result =0;
		int op1=HexaConverter.hexaToDecimalC2(regNumSrc1);
		int op2=HexaConverter.hexaToDecimalC2(regNumSrc2);
		result = op1 + op2;			
		if((result > 0 && result > 127) || (result < 0 && result < -128) )
			this.setOverflow(true);
		return HexaConverter.decimalToBaseC2(result, 16);
	}

	public String sumF(String regNumSrc1, String regNumSrc2) {
		this.setOverflow(false);
		float result =0;
		float op1=FPUnit.puntoFlotanteADecimal(regNumSrc1);
		float op2=FPUnit.puntoFlotanteADecimal(regNumSrc2);
		result = op1 + op2;			
		this.setOverflow(FPUnit.isOverflow(result));
		return FPUnit.decimalAPuntoFlotante(result);
	}

	public String logicOR(String op1, String op2) {
		int intOp1 = HexaConverter.baseToDecimal(op1, 16);
		int intOp2 = HexaConverter.baseToDecimal(op2, 16);
		int result = intOp1 | intOp2; 		
		return HexaConverter.decimalToBase(result, 16);
	}

	public String logicAND(String op1, String op2) {
		int intOp1 = HexaConverter.baseToDecimal(op1, 16);
		int intOp2 = HexaConverter.baseToDecimal(op2, 16);
		int result = intOp1 & intOp2; 		
		return HexaConverter.decimalToBase(result, 16);
	}

	public String logicXOR(String op1, String op2) {
		int intOp1 = HexaConverter.baseToDecimal(op1, 16);
		int intOp2 = HexaConverter.baseToDecimal(op2, 16);
		int result = intOp1 ^ intOp2; 		
		return HexaConverter.decimalToBase(result, 16);
	}

	public String rotateR(String data, String repetitions) {
		String binData = HexaConverter.hexaToBinary(data);
		int intRep = HexaConverter.baseToDecimal(repetitions, 16);		
		for (int i =0 ;i < intRep;i++){
			int lastBitPos = binData.length()-1;
			String lastBit = binData.substring(lastBitPos);
			binData = binData.substring(0, lastBitPos);
			binData = lastBit + binData;			
		};
		int result = HexaConverter.baseToDecimal(binData, 2);
		return HexaConverter.decimalToBase(result, 16);		
	}

}
