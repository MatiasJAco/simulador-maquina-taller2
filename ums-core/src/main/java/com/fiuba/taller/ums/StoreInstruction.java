package com.fiuba.taller.ums;

import java.util.Scanner;

public class StoreInstruction implements Instruction {

	String memAddress;
	String regNumber;
	Memory mem;
	RegisterMemory regMem;
	
	public StoreInstruction(String params, Memory m, RegisterMemory r) {
		this.memAddress = params.substring(1);
		this.regNumber = params.substring(0,1);
		this.mem = m;
		this.regMem = r;
	}

	@Override
	public void execute() {
		String dataToStore = this.regMem.readReg(regNumber);
		this.mem.writeCell(memAddress, dataToStore);
		if(memAddress.equals("FF")){
			this.mem.writeCell("FE", "01");			
		}
	}

}
