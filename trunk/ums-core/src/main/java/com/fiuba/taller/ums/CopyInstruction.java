package com.fiuba.taller.ums;

public class CopyInstruction implements Instruction {

	private RegisterMemory regMem;
	private String regNumSrc;
	private String regNumDst;
	
	public CopyInstruction(String params, RegisterMemory r) {
		this.regNumDst = params.substring(2);
		this.regNumSrc = params.substring(1,2);
		this.regMem = r;
	}

	@Override
	public void execute() {
		String dataToCopy = this.regMem.readReg(regNumSrc);
		this.regMem.writeReg(regNumDst, dataToCopy);

	}

}
