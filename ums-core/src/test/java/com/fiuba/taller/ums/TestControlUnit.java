package com.fiuba.taller.ums;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestControlUnit {

	@Test
	public void testLoadInstructionToMemory() {
		Memory myMemory = new Memory() ;
		ControlUnit myControlUnit = new ControlUnit(myMemory);
		myControlUnit.loadInstructionToMemory("11A8");
		myControlUnit.loadInstructionToMemory("21A8");
		assertEquals("11", myMemory.readCell(0));
		assertEquals("A8", myMemory.readCell(1));
		assertEquals("21", myMemory.readCell(2));
		assertEquals("A8", myMemory.readCell(3));		
	}

	@Test
	public void testInstructionFetch() {
		Memory myMemory = new Memory() ;
		ControlUnit myControlUnit = new ControlUnit(myMemory);
		myControlUnit.loadInstructionToMemory("11A8");
		myControlUnit.loadInstructionToMemory("21A8");
		assertEquals("11A8", myControlUnit.fetchInstruction());
		assertEquals("21A8", myControlUnit.fetchInstruction());		
	}
	
	@Test
	public void testDecodeLoad() {
		Memory myMemory = new Memory() ;
		ControlUnit myControlUnit = new ControlUnit(myMemory);
		myControlUnit.loadInstructionToMemory("11A8");
		myControlUnit.loadInstructionToMemory("21A8");
		assertEquals(new LoadInstruction("1A8",myMemory,new RegisterMemory()).getClass(), myControlUnit.decode(myControlUnit.fetchInstruction()).getClass());
				
	}
	
	@Test
	public void testExecuteLoad() {
		Memory myMemory = new Memory() ;
		RegisterMemory myRegMem = new RegisterMemory();
		myMemory.writeCell("A8", "03");
		ControlUnit myControlUnit = new ControlUnit(myMemory,myRegMem);
		myControlUnit.loadInstructionToMemory("11A8");
		myControlUnit.fetchInstruction();
		myControlUnit.decode();
		myControlUnit.executeCurrentInstruction();
		assertEquals("03",myRegMem.readReg("1"));				
	}
	
	@Test
	public void testExecuteLoadImm() {
		Memory myMemory = new Memory() ;
		RegisterMemory myRegMem = new RegisterMemory();
		ControlUnit myControlUnit = new ControlUnit(myMemory,myRegMem);
		myControlUnit.loadInstructionToMemory("21A8");
		myControlUnit.fetchInstruction();
		myControlUnit.decode();
		myControlUnit.executeCurrentInstruction();
		assertEquals("A8",myRegMem.readReg("1"));				
	}
	
	@Test
	public void testExecuteStore() {
		Memory myMemory = new Memory() ;
		RegisterMemory myRegMem = new RegisterMemory();
		myRegMem.writeReg("1", "16");
		ControlUnit myControlUnit = new ControlUnit(myMemory,myRegMem);
		myControlUnit.loadInstructionToMemory("31A8");
		myControlUnit.fetchInstruction();
		myControlUnit.decode();
		myControlUnit.executeCurrentInstruction();
		assertEquals("16",myMemory.readCell("A8"));				
	}
	
	@Test
	public void testExecuteCopy() {
		Memory myMemory = new Memory() ;
		RegisterMemory myRegMem = new RegisterMemory();
		myRegMem.writeReg("1", "16");
		ControlUnit myControlUnit = new ControlUnit(myMemory,myRegMem);
		myControlUnit.loadInstructionToMemory("4013");
		myControlUnit.fetchInstruction();
		myControlUnit.decode();
		myControlUnit.executeCurrentInstruction();
		assertEquals("16",myRegMem.readReg("3"));				
	}
	
	@Test
	public void testExecuteJump() {
		Memory myMemory = new Memory() ;
		RegisterMemory myRegMem = new RegisterMemory();
		myRegMem.writeReg("1", "16");
		myRegMem.writeReg("2", "11");
		myRegMem.writeReg("4", "00");
		ControlUnit myControlUnit = new ControlUnit(myMemory,myRegMem);
		myControlUnit.loadInstructionToMemory("4013");
		myControlUnit.loadInstructionToMemory("4023");
		myControlUnit.loadInstructionToMemory("B400");
		myControlUnit.loadInstructionToMemory("4011");
		//4 ciclos de fetch
		myControlUnit.fetchInstruction();
		myControlUnit.decode();
		myControlUnit.executeCurrentInstruction();
		myControlUnit.fetchInstruction();
		myControlUnit.decode();
		myControlUnit.executeCurrentInstruction();
		myControlUnit.fetchInstruction();
		myControlUnit.decode();
		myControlUnit.executeCurrentInstruction();
		myControlUnit.fetchInstruction();
		myControlUnit.decode();
		myControlUnit.executeCurrentInstruction();
		assertEquals("16",myRegMem.readReg("3"));				
	}
	
	@Test
	public void testExecuteSum() {
		Memory myMemory = new Memory() ;
		RegisterMemory myRegMem = new RegisterMemory();
		myRegMem.writeReg("A", "20");
		myRegMem.writeReg("B", "16");
		ControlUnit myControlUnit = new ControlUnit(myMemory,myRegMem);
		myControlUnit.loadInstructionToMemory("51AB");
		myControlUnit.fetchInstruction();
		myControlUnit.decode();
		myControlUnit.executeCurrentInstruction();
		assertEquals("36",myRegMem.readReg("1"));				
	}
	
	@Test
	public void testExecuteSumF() {
		Memory myMemory = new Memory() ;
		RegisterMemory myRegMem = new RegisterMemory();
		myRegMem.writeReg("A", "20");
		myRegMem.writeReg("B", "16");
		ControlUnit myControlUnit = new ControlUnit(myMemory,myRegMem);
		myControlUnit.loadInstructionToMemory("61AB");
		myControlUnit.fetchInstruction();
		myControlUnit.decode();
		myControlUnit.executeCurrentInstruction();
		assertEquals("2B",myRegMem.readReg("1"));				
	}
	
	@Test
	public void testExecuteOR() {
		Memory myMemory = new Memory() ;
		RegisterMemory myRegMem = new RegisterMemory();
		myRegMem.writeReg("A", "B2");
		myRegMem.writeReg("B", "CE");
		ControlUnit myControlUnit = new ControlUnit(myMemory,myRegMem);
		myControlUnit.loadInstructionToMemory("71AB");
		myControlUnit.fetchInstruction();
		myControlUnit.decode();
		myControlUnit.executeCurrentInstruction();
		assertEquals("FE",myRegMem.readReg("1"));				
	}
	
	@Test
	public void testExecuteAND() {
		Memory myMemory = new Memory() ;
		RegisterMemory myRegMem = new RegisterMemory();
		myRegMem.writeReg("A", "B2");
		myRegMem.writeReg("B", "CE");
		ControlUnit myControlUnit = new ControlUnit(myMemory,myRegMem);
		myControlUnit.loadInstructionToMemory("81AB");
		myControlUnit.fetchInstruction();
		myControlUnit.decode();
		myControlUnit.executeCurrentInstruction();
		assertEquals("82",myRegMem.readReg("1"));				
	}
	
	@Test
	public void testExecuteXOR() {
		Memory myMemory = new Memory() ;
		RegisterMemory myRegMem = new RegisterMemory();
		myRegMem.writeReg("A", "B2");
		myRegMem.writeReg("B", "CE");
		ControlUnit myControlUnit = new ControlUnit(myMemory,myRegMem);
		myControlUnit.loadInstructionToMemory("91AB");
		myControlUnit.fetchInstruction();
		myControlUnit.decode();
		myControlUnit.executeCurrentInstruction();
		assertEquals("7C",myRegMem.readReg("1"));				
	}
	
	@Test
	public void testExecuteRotate() {
		Memory myMemory = new Memory() ;
		RegisterMemory myRegMem = new RegisterMemory();
		myRegMem.writeReg("1", "B2");
		ControlUnit myControlUnit = new ControlUnit(myMemory,myRegMem);
		myControlUnit.loadInstructionToMemory("A10A");
		myControlUnit.fetchInstruction();
		myControlUnit.decode();
		myControlUnit.executeCurrentInstruction();
		assertEquals("AC",myRegMem.readReg("1"));				
	}
	
	
	
}
