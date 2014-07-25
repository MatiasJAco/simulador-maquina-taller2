package com.fiuba.taller.ums;

public class JumpInstruction implements Instruction {

	private ControlUnit cu;
	private ALU alu;
	private RegisterMemory regMem;
	private String nextInstAddr;
	private String regToCompare;

	public JumpInstruction(String params, ALU theAlu, ControlUnit theCu, RegisterMemory rm) {
		this.regToCompare = params.substring(0,1);
		this.nextInstAddr = params.substring(1);
		this.alu = theAlu;
		this.cu = theCu;
		this.regMem = rm;
	}

	@Override
	public void execute() {
		if(this.alu.isZeroReg(HexaConverter.baseToDecimal(this.regMem.readReg(regToCompare),16))){
			this.cu.setNextInstructionAddress(HexaConverter.baseToDecimal(nextInstAddr, 16));
			cu.setCurrentDecodedInstruction(new noOpInstruction());
			cu.setDecodeInstructionRegister("0000");
			cu.setFetchInstructionRegister("0000");
			cu.setInstructionToDecode("0000");
		}

	}

}
