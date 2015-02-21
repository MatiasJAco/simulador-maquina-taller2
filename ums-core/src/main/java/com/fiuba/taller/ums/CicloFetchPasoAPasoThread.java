//package com.fiuba.taller.ums;
//
//
//public class CicloFetchPasoAPasoThread extends Thread {
//	private String tempfile;
//	private CycleController cycleC;
//
//	public CicloFetchPasoAPasoThread(String tempfile,CycleController c) {
//		super();
//		this.tempfile = tempfile;
//		this.cycleC = c;
//	}
//
//	public void run()   {
//
//		//	System.out.print("Entro: "+ usin.getInputData()+"\n" );
//
//
//		Memory myMemory = new Memory() ;
//		ControlUnit myControlUnit = new ControlUnit(myMemory);
//		myControlUnit.loadProgramToMemory(tempfile);
//		while(!myControlUnit.isProgramEnded()){
//			if(this.cycleC.getInputData()){
//				myControlUnit.fetchInstruction();
//				myControlUnit.decode();
//				myControlUnit.executeCurrentInstruction();
//				System.out.print("Instruccion:" + myControlUnit.getInstructionRegister());
//				this.cycleC.setInputData(false);
//			}else{
//				synchronized(cycleC){
//					if (cycleC.getInputData() == false){
//						try {
//							cycleC.wait();
//						} catch (InterruptedException e) {								
//							e.printStackTrace();
//						}
//					}
//				};
//				
//			}
//		}
//	}
//};