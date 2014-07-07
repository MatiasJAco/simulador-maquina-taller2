package com.fiuba.taller.ums;

import java.util.ArrayList;



public class Memory {

	private static final int CELL_AMOUNT = 256;
	private ArrayList<Cell> cells ;
	private int lastInstructionPointer;

	public Memory() {
		this.cells = new ArrayList<Cell>(CELL_AMOUNT);		
		for (int index = 0; index < CELL_AMOUNT; index++) {
			cells.add(new Cell());					
		}
		this.lastInstructionPointer=0;
	}
	
	public void emptyMemory(){
		for (int index = 0; index < CELL_AMOUNT; index++) {
			this.writeCell(index, "");					
		}
		this.lastInstructionPointer=0;
	}
	
	public void writeCell(int address, String data){
		this.getCell(address).setData(data);
	}

	public String readCell(int address){
		return this.getCell(address).getData();
		
	};
	
	//Indicates beggining of the last instruction in memory.
	public int getLastInstrucionAddress(){
		return lastInstructionPointer;
		
	};

	//Indicates beggining of the first instruction in memory.
	public int getFirstInstrucionAddress(){
		return 0;
		
	};
	
	private Cell getCell(int addr){
		return this.cells.get(addr);
		
	}

	public void incrementInstructionPointer() {
		this.lastInstructionPointer++;
		this.lastInstructionPointer++;		
	}

	public String readCell(String address) {
		return this.getCell(HexaConverter.baseToDecimal(address, 16)).getData();
	}

	public void writeCell(String address, String data) {
		this.getCell(HexaConverter.baseToDecimal(address, 16)).setData(data);
		
	}

	public int getSize() {
		return CELL_AMOUNT;
	};


}
