package com.fiuba.taller.ums;

public class LoadImmInstruction implements Instruction {
	
	private RegisterMemory regMem;
	private String regNum;
	private String dataToLoad;

	public LoadImmInstruction(String params, RegisterMemory r) {
		this.dataToLoad = params.substring(1);
		this.regNum = params.substring(0,1);
		this.regMem = r;
	}

	@Override
	public void execute() {
		this.regMem.writeReg(regNum, dataToLoad);
	}

}
