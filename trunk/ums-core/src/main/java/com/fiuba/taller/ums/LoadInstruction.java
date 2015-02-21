package com.fiuba.taller.ums;

import java.util.Scanner;
import java.util.Timer;

import javax.swing.JFrame;

import org.w3c.dom.UserDataHandler;

public class LoadInstruction implements Instruction {

	private static final String HEXAVALUES = "0123456789ABCDEF";
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
//			Scanner sc = new Scanner(System.in);

			UserInputData usin = new UserInputData();
			UserInputWindow win = new UserInputWindow(usin);
			while(!validateValue(usin.getInputData())){				
				//				System.out.print("Entra: ");
//				System.out.print("Entra: ");
				usin.setInputData("");
				synchronized(usin){
					if (usin.getInputData().length() < 2){
						try {
							usin.wait();
						} catch (InterruptedException e) {								
							e.printStackTrace();
						}
					}
				};
			
			}
			System.out.print("Entro: "+ usin.getInputData()+"\n" );
			dataToLoad = usin.getInputData();
			win.close();
		}else
			dataToLoad = this.mem.readCell(memAddress);
		this.regMem.writeReg(regNumber,dataToLoad);
		this.mem.writeCell("FC", "00");		
	}

	private boolean validateValue(String inputData) {
		boolean result = true;
		if(inputData.length() != 2){
			result = false;	
		}else{		
			for (int i=0;i<inputData.length();i++){
				if(!HEXAVALUES.contains(Character.toString(inputData.charAt(i))))
					result = false;;
			}
		}
		return result;
	}

}
