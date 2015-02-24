package com.fiuba.taller.ums;


public class CicloFetchPasoAPasoThread extends Thread {
	private String tempfile;
	private CycleController cycleC;
	private ControlUnit myControlUnit ;

	public CicloFetchPasoAPasoThread(String tempfile,CycleController c,ControlUnit cu) {
		super();
		this.tempfile = tempfile;
		this.cycleC = c;
		this.myControlUnit = cu;
	}

	public void run()   {

		//	System.out.print("Entro: "+ usin.getInputData()+"\n" );


//		Memory myMemory = new Memory() ;
//		ControlUnit myControlUnit = new ControlUnit(myMemory);
		myControlUnit.loadProgramToMemory(tempfile);
		while(!myControlUnit.isProgramEnded()){
			if(this.cycleC.getInputData()){
				myControlUnit.fetchInstruction();
				myControlUnit.decode();
				myControlUnit.executeCurrentInstruction();
				/********Esto se va a sacar en el producto final *******/
				
//				System.out.print("Fetch register :" + myControlUnit.getFetchInstructionRegister() + "\n");
//				System.out.print("Decode register:" + myControlUnit.getDecodeInstructionRegister() + "\n");
				System.out.print("Execution register:" + myControlUnit.getExecutionInstructionRegister() + "\n");
//				System.out.print("Program counter:" + myControlUnit.getNextInstructionAddress() + "\n");
//				System.out.print("Instruction register:" + myControlUnit.getInstructionRegister() + "\n");
//				
//				//Registros
//				System.out.print("Register 01:" + myControlUnit.getRegMem().readReg("01") + "\n");
//				System.out.print("Register 02:" + myControlUnit.getRegMem().readReg("02") + "\n");
//				//A la memoria se puede acceder de dos formas, con numero hexa o entero
//				System.out.print("Memory cell 01:" + myControlUnit.getMem().readCell("01") + "\n");
//				System.out.print("Memory cell 02:" + myControlUnit.getMem().readCell(1) + "\n");
//				//ALU
//				System.out.print("Operador1:" + myControlUnit.getAlu().getRegNumSrc1() + "\n");
//				System.out.print("Operador2:" + myControlUnit.getAlu().getRegNumSrc2() + "\n");
//				System.out.print("Resultado:" + myControlUnit.getAlu().getResult() + "\n");
//				
//				System.out.print("Bits de precision perdidos:" + myControlUnit.getAlu().getBitsPrecisionPerdidos() + "\n");
//				System.out.print("Overflow:" + myControlUnit.getAlu().isOverflow() + "\n");
//				
				
				
				
				
				
				
				
				
				
				/***********************************************************************/
				this.cycleC.setInputData(false);
			}else{
				synchronized(cycleC){
					if (cycleC.getInputData() == false){
						try {
							cycleC.wait();
						} catch (InterruptedException e) {								
							e.printStackTrace();
						}
					}
				};
				
			}
		}
	}
};