package com.fiuba.taller.ums;

public class CicloFetchThread extends Thread {
	private String tempfile;
	
   public CicloFetchThread(String tempfile) {
		super();
		this.tempfile = tempfile;
	}

public void run()
   {
	 //Cargar en memoria
		Memory myMemory = new Memory() ;
		ControlUnit myControlUnit = new ControlUnit(myMemory);
		myControlUnit.loadProgramToMemory(tempfile);
		while(!myControlUnit.isProgramEnded()){
			myControlUnit.fetchInstruction();
			myControlUnit.decode();
			myControlUnit.executeCurrentInstruction();
		}
   }
};