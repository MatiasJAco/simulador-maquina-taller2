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
	private Instruction currentInstruction;
	private RegisterMemory regMem;


	public String getInstructionRegister() {
		return instructionRegister;
	}

	public void setInstructionRegister(String instructionRegister) {
		this.instructionRegister = instructionRegister;
	}


	public ControlUnit() {
		this.mem = new Memory();
		this.alu = new ALU();
		this.regMem = new RegisterMemory();
		this.instructionRegister="";
		this.nextInstructionAddress=0;
		currentInstruction=null;
	}

	public ControlUnit(Memory aMem) {
		this.mem = aMem;
		this.regMem = new RegisterMemory();
		this.alu = new ALU();
		this.instructionRegister="";
		this.alu = new ALU();
		this.nextInstructionAddress=0;
		currentInstruction = null;
	}

	public ControlUnit(Memory myMemory, RegisterMemory myRegMem) {		
		this.instructionRegister="";
		this.alu = new ALU();
		this.nextInstructionAddress=0;
		currentInstruction = null;
		this.mem = myMemory;
		this.regMem = myRegMem;
	}

	public void loadInstructionToMemory(String inst) {
		String firstHalf = inst.substring(0,2);
		String secondHalf = inst.substring(2,4);
		this.mem.writeCell(mem.getLastInstrucionAddress(), firstHalf);
		this.mem.writeCell(mem.getLastInstrucionAddress()+1, secondHalf);
		this.mem.incrementInstructionPointer();

	}

	public Instruction getCurrentInstruction(){		
		return this.currentInstruction;		
	}

	public String fetchInstruction() {
		String result= this.mem.readCell(nextInstructionAddress) + this.mem.readCell(nextInstructionAddress + 1);
		this.instructionRegister=result;
		this.nextInstructionAddress++;
		this.nextInstructionAddress++;
		return getInstructionRegister();
	}

	public Instruction decode(String inst){
		//Extraer codigo de operacion
		//Disitinguir operacion
		char codOp = inst.charAt(0);
		String params = inst.substring(1);
		switch (codOp) {
		case '1':
			this.setCurrentInstruction(new LoadInstruction(params,this.mem,this.regMem));
			//Setear componentes				
			break;
		case '2':
			this.setCurrentInstruction(new LoadImmInstruction(params, this.regMem));
			break;
		case '3':
			this.setCurrentInstruction(new StoreInstruction(params,this.mem,this.regMem));
			break;
		case '4':
			this.setCurrentInstruction(new CopyInstruction(params, this.regMem));
			break;
		case '5':
			this.setCurrentInstruction(new SumInstruction(params,this.regMem,this.alu));
			break;
		case '6':
			this.setCurrentInstruction(new SumFInstruction(params,this.regMem,this.alu));
			break;
		case '7':
			this.setCurrentInstruction(new OrInstruction(params,this.regMem,this.alu));
			break;
		case '8':
			this.setCurrentInstruction(new AndInstruction(params,this.regMem,this.alu));
			break;
		case '9':
			this.setCurrentInstruction(new XorInstruction(params,this.regMem,this.alu));
			break;
		case 'A':
			this.setCurrentInstruction(new RotateInstruction(params,this.regMem,this.alu));
			break;
		case 'B':
			this.setCurrentInstruction(new JumpInstruction(params,this.alu,this,this.regMem));
			break;
		case 'C':
			this.setCurrentInstruction(new RetInstruction());
			break;
		default:
			break;
		}



		return this.currentInstruction;



	}

	public int getNextInstructionAddress() {
		return nextInstructionAddress;
	}

	public void setNextInstructionAddress(int nextInstructionAddress) {
		this.nextInstructionAddress = nextInstructionAddress;
	}

	public void setCurrentInstruction(Instruction currentInstruction) {
		this.currentInstruction = currentInstruction;
	}



	public void executeCurrentInstruction() {
		this.currentInstruction.execute();

	}

	public Instruction decode() {
		return this.decode(this.instructionRegister);		
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
}
