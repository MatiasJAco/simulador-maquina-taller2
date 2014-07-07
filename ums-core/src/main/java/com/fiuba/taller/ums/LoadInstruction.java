package com.fiuba.taller.ums;

import java.util.Scanner;

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
		String dataToLoad = "";
		if(memAddress.equals("FD")){
			this.mem.writeCell("FC", "01");
			Scanner sc = new Scanner(System.in);
			while(dataToLoad.length() < 2){
				System.out.print("Ingrese un patrón de 1 byte en formato hexadecimal: ");
				dataToLoad = sc.nextLine(); 
			}
			dataToLoad = dataToLoad.substring(0,2);
		}else
			dataToLoad = this.mem.readCell(memAddress);
		this.regMem.writeReg(regNumber,dataToLoad);
		this.mem.writeCell("FC", "00");
	}

}
