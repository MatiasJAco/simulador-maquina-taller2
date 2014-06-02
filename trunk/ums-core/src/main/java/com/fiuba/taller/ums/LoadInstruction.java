package com.fiuba.taller.ums;

public class LoadInstruction implements Instruction {

	String memAddress;
	String regNumber;
	Memory mem;
	RegisterMemory regMem;
	
	public LoadInstruction(String params,Memory m, RegisterMemory r) {
		this.memAddress = params.substring(1);
		this.regNumber = params.substring(0,1);
		this.mem = m;
		this.regMem = r;
	}

	@Override
	public void execute() {
		String dataToLoad = this.mem.readCell(memAddress);
		this.regMem.writeReg(regNumber,dataToLoad);
	}

}
