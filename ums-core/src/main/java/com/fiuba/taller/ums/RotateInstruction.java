package com.fiuba.taller.ums;

public class RotateInstruction implements Instruction {

	private RegisterMemory regMem;
	private ALU alu;
	private String regNum;
	private String repetitions;
	
	
	public RotateInstruction(String params, RegisterMemory r, ALU theAlu) {
		this.regNum = params.substring(0,1);
		this.repetitions = params.substring(2);
		this.regMem = r;
		this.alu = theAlu;
	}

	@Override
	public void execute() {
		String data = this.regMem.readReg(regNum);
		this.regMem.writeReg(regNum, this.alu.rotateR(data,repetitions));
	}

}
