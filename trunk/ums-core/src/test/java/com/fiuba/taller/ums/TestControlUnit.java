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
	
}
