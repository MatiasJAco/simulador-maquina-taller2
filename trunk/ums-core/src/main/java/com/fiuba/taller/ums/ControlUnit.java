package com.fiuba.taller.ums;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.text.DefaultEditorKit.CutAction;

public class ControlUnit {

	private Memory mem;
	private ALU alu;
	private String instructionRegister;
	private int nextInstructionAddress;
	private Instruction currentDecodedInstruction;
	private Instruction currentExecutingInstruction;
	private RegisterMemory regMem;
	public Memory getMem() {
		return mem;
	}

	public ALU getAlu() {
		return alu;
	}

	public RegisterMemory getRegMem() {
		return regMem;
	}

	private boolean programEnded;
	private String  fetchInstructionRegister;
	private String 	instructionToDecode;
	private String  decodeInstructionRegister;
	private String  executionInstructionRegister;
	

	public ControlUnit() {
		this.mem = new Memory();
		this.alu = new ALU();
		this.regMem = new RegisterMemory();
		this.instructionRegister="";
		this.nextInstructionAddress=0;
		currentDecodedInstruction=new noOpInstruction();
		currentExecutingInstruction = new noOpInstruction();
		programEnded = false;
		this.fetchInstructionRegister="0000";
		this.decodeInstructionRegister="0000";
		this.executionInstructionRegister="0000";
		instructionToDecode = "0000";
		
		
	}

	public ControlUnit(Memory aMem) {
		this.mem = aMem;
		this.regMem = new RegisterMemory();
		this.alu = new ALU();
		this.instructionRegister="";
		this.alu = new ALU();
		this.nextInstructionAddress=0;
		currentDecodedInstruction=new noOpInstruction();
		currentExecutingInstruction = new noOpInstruction();
		programEnded = false;
		this.fetchInstructionRegister="0000";
		this.decodeInstructionRegister="0000";
		this.executionInstructionRegister="0000";
		instructionToDecode = "0000";
	}

	public ControlUnit(Memory myMemory, RegisterMemory myRegMem) {		
		this.instructionRegister="";
		this.alu = new ALU();
		this.nextInstructionAddress=0;
		currentDecodedInstruction=new noOpInstruction();
		currentExecutingInstruction = new noOpInstruction();
		this.mem = myMemory;
		this.regMem = myRegMem;
		programEnded = false;
		this.fetchInstructionRegister="0000";
		this.decodeInstructionRegister="0000";
		this.executionInstructionRegister="0000";
		instructionToDecode = "0000";
	}

	public String getInstructionRegister() {
		return instructionRegister;
	}

	public void setInstructionRegister(String instructionRegister) {
		this.instructionRegister = instructionRegister;
	}


	public void loadInstructionToMemory(String inst) {
		String firstHalf = inst.substring(0,2);
		String secondHalf = inst.substring(2,4);
		this.mem.writeCell(mem.getLastInstrucionAddress(), firstHalf);
		this.mem.writeCell(mem.getLastInstrucionAddress()+1, secondHalf);
		this.mem.incrementInstructionPointer();

	}

	public Instruction getCurrentInstruction(){		
		return this.currentDecodedInstruction;		
	}

	public String fetchInstruction() {
		String result= this.mem.readCell(nextInstructionAddress) + this.mem.readCell(nextInstructionAddress + 1);
		this.instructionRegister=result;
		this.instructionToDecode = this.fetchInstructionRegister;
		this.fetchInstructionRegister = result;
		this.nextInstructionAddress++;
		this.nextInstructionAddress++;
//		MainLogger.logError("Fetch instruction: " + getInstructionRegister() );
//		MainLogger.logError("Fetch instruction: " + getFetchInstructionRegister() );
		return getInstructionRegister();
	}

	public Instruction decode(String inst){
		//Extraer codigo de operacion
		//Disitinguir operacion
		char codOp = inst.charAt(0);
		String params = inst.substring(1);
		switch (codOp) {
		case '1':
			this.setCurrentDecodedInstruction(new LoadInstruction(params,this.mem,this.regMem));
			//Setear componentes				
			break;
		case '2':
			this.setCurrentDecodedInstruction(new LoadImmInstruction(params, this.regMem));
			break;
		case '3':
			this.setCurrentDecodedInstruction(new StoreInstruction(params,this.mem,this.regMem));
			break;
		case '4':
			this.setCurrentDecodedInstruction(new CopyInstruction(params, this.regMem));
			break;
		case '5':
			this.setCurrentDecodedInstruction(new SumInstruction(params,this.regMem,this.alu));
			break;
		case '6':
			this.setCurrentDecodedInstruction(new SumFInstruction(params,this.regMem,this.alu));
			break;
		case '7':
			this.setCurrentDecodedInstruction(new OrInstruction(params,this.regMem,this.alu));
			break;
		case '8':
			this.setCurrentDecodedInstruction(new AndInstruction(params,this.regMem,this.alu));
			break;
		case '9':
			this.setCurrentDecodedInstruction(new XorInstruction(params,this.regMem,this.alu));
			break;
		case 'A':
			this.setCurrentDecodedInstruction(new RotateInstruction(params,this.regMem,this.alu));
			break;
		case 'B':
			this.setCurrentDecodedInstruction(new JumpInstruction(params,this.alu,this,this.regMem));
			break;
		case 'C':
			this.setCurrentDecodedInstruction(new RetInstruction(this));
			break;
		default:
			this.setCurrentDecodedInstruction(new noOpInstruction());
			break;
		}



		return this.currentDecodedInstruction;



	}

	public int getNextInstructionAddress() {
		return nextInstructionAddress;
	}

	public void setNextInstructionAddress(int nextInstructionAddress) {
		this.nextInstructionAddress = nextInstructionAddress;
	}

	public void setCurrentDecodedInstruction(Instruction currentInstruction) {
		this.currentDecodedInstruction = currentInstruction;
	}



	public void executeCurrentInstruction() {
		this.currentExecutingInstruction.execute();
//		MainLogger.logError("Executing instruction: " + this.getExecutionInstructionRegister() );
		if(this.mem.readCell("FE").equals("01"))
			System.out.print("Sale: " + this.mem.readCell("FF") + "\n");
		this.mem.writeCell("FE", "00");

	}

	public Instruction decode() {
		this.executionInstructionRegister = this.decodeInstructionRegister;
		this.decodeInstructionRegister = this.instructionToDecode;
		this.currentExecutingInstruction = this.currentDecodedInstruction;
//		MainLogger.logError("Decoded instruction: " + this.getDecodeInstructionRegister() );
		return this.decode(this.decodeInstructionRegister);		
		
	}

	public void loadProgramToMemory(String tempfile) {
		File input = new File(tempfile);
		// This will reference one line at a time
		String line = null;
		try {
			//Open  file reader
			Scanner scanner = new Scanner(input);

			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				String address = line.substring(0,2);
				String inst = line.substring(4,8);
				this.loadInstructionToMemory(inst);
				//				this.loadInstructionToMemory(address,inst);				
			}
			MainLogger.logInfo("Programa cargado en memoria correctamente");
			// Always close files.
			scanner.close();
		}
		catch(FileNotFoundException ex) {
			System.out.println(
					"Unable to open file '" + 
							input + "'");				
		}
		catch(IOException ex) {
			System.out.println(
					"Error reading file '" 
							+ input + "'");					
			// Or we could just do this: 
			// ex.printStackTrace();
		}
	}

	private void loadInstructionToMemory(String address, String inst) {
		String firstHalf = inst.substring(0,2);
		String secondHalf = inst.substring(2,4);
		this.mem.writeCell(mem.getLastInstrucionAddress(), firstHalf);
		this.mem.writeCell(mem.getLastInstrucionAddress()+1, secondHalf);
		//		this.mem.setInstructionPointer(address);

	};

	public String dumpMemory(){
		String dump = "" ;
		for(int i = 0;i<this.mem.getSize();i++){
			dump += "Celda :" + i + "  Contenido: " + this.mem.readCell(i) + ".\n" ;	
		}
		return dump;		
	}

	public boolean isProgramEnded() {
		return this.programEnded;
	}

	public void setProgramEnded(boolean b) {
		this.programEnded = b;		
	}

	public String getFetchInstructionRegister() {
		return fetchInstructionRegister;
	}

	public void setFetchInstructionRegister(String fetchInstructionRegister) {
		this.fetchInstructionRegister = fetchInstructionRegister;
	}

	public String getDecodeInstructionRegister() {
		return decodeInstructionRegister;
	}

	public void setDecodeInstructionRegister(String decodeInstructionRegister) {
		this.decodeInstructionRegister = decodeInstructionRegister;
	}

	public String getExecutionInstructionRegister() {
		return executionInstructionRegister;
	}

	public void setExecutionInstructionRegister(
			String executionInstructionRegister) {
		this.executionInstructionRegister = executionInstructionRegister;
	}

	public void setInstructionToDecode(String string) {
		this.instructionToDecode = string;
		
	}

}
