package com.fiuba.taller.ums;

public class RetInstruction implements Instruction {

	private ControlUnit myControlUnit;

	public RetInstruction(ControlUnit cu) {
		this.myControlUnit = cu;
	}

	@Override
	public void execute() {
		this.myControlUnit.setProgramEnded(true);
	}

}
