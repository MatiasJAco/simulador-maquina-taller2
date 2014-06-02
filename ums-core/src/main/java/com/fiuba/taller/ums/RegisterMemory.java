package com.fiuba.taller.ums;

import java.util.ArrayList;

public class RegisterMemory {

	
	private int readFromReg1;
	private int readFromReg2;
	private int writeToReg;
	private String dataToWrite;
	private String dataReadFromR1;
	private String dataReadFromR2;
	private static final int REG_AMOUNT = 16;
	private ArrayList<Register> registers ;
	
	public RegisterMemory() {
		this.readFromReg1 = 0;
	 	this.readFromReg2 = 0;
	 	this.writeToReg =  0;
	 	this.dataReadFromR1 = "";
	 	this.dataReadFromR2 = "";
	 	this.dataToWrite = "";
	 	this.registers = new ArrayList<Register>(REG_AMOUNT);		
		for (int index = 0; index < REG_AMOUNT; index++) {
			registers.add(new Register());					
		}
	}

	public String readReg(String address) {
		return this.getReg(HexaConverter.baseToDecimal(address, 16)).getData();
	}
	
	private Register getReg(int addr){
		return this.registers.get(addr);
		
	}

	public void writeReg(String regNumber, String dataToLoad) {
		this.getReg(HexaConverter.baseToDecimal(regNumber, 16)).setData(dataToLoad);
		
	}
}
