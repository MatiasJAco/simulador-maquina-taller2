package com.fiuba.taller.ums;

public class SumFInstruction implements Instruction {

	private RegisterMemory regMem;
	private ALU alu;
	private String regNumSrc1;
	private String regNumSrc2;
	private String regNumDst;

	public SumFInstruction(String params, RegisterMemory r, ALU theAlu) {
		this.regNumDst = params.substring(0,1);
		this.regNumSrc1 = params.substring(1,2);
		this.regNumSrc2 = params.substring(2);
		this.regMem = r;
		this.alu = theAlu;
	}

	@Override
	public void execute() {
		//Suma complemento a 2	
		String op1 = this.regMem.readReg(regNumSrc1);
		String op2 = this.regMem.readReg(regNumSrc2);
		this.regMem.writeReg(regNumDst, this.alu.sumF(op1,op2));
		this.alu.sumFPrecisionCheck(op1,op2); //actualiza los bits de precision.
	}

}
