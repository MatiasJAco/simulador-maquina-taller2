package com.fiuba.taller.ums;

public class ControlUnit {

	private Memory mem;
	private String instructionRegister;
	int nextInstructionAddress;
	public ControlUnit() {
		this.mem = new Memory();
		this.instructionRegister="";
		this.nextInstructionAddress=0;
	}

	public ControlUnit(Memory aMem) {
		this.mem = aMem;
		this.instructionRegister="";
		this.nextInstructionAddress=0;
	}

	public void loadInstructionToMemory(String inst) {
		String firstHalf = inst.substring(0,2);
		String secondHalf = inst.substring(2,4);
		this.mem.writeCell(mem.getLastInstrucionAddress(), firstHalf);
		this.mem.writeCell(mem.getLastInstrucionAddress()+1, secondHalf);
		this.mem.incrementInstructionPointer();
		
	}
	
	public String getCurrentInstruction(){		
		return instructionRegister;		
	}

	public String fetchInstruction() {
		String result= this.mem.readCell(nextInstructionAddress) + this.mem.readCell(nextInstructionAddress + 1);
		this.instructionRegister=result;
		this.nextInstructionAddress++;
		this.nextInstructionAddress++;
		return getCurrentInstruction();
	}

	

}
