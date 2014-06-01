package com.fiuba.taller.ums;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMemory {

	@Test
	public void testWriteReadCell() {
		Memory myMemory = new Memory();
		myMemory.writeCell(1, "A3");
		assertEquals("A3",myMemory.readCell(1));
	}

	@Test
	public void testEmptyMemory() {
		Memory myMemory = new Memory();
		myMemory.writeCell(1, "A3");
		myMemory.writeCell(2, "BC");
		myMemory.emptyMemory();
		boolean isEmpty=false;
		int notEmptyCells=0;
		for(int i = 0;i<256;i++){
			if(!myMemory.readCell(i).equals(""))
				notEmptyCells++;
		}
		if(notEmptyCells == 0)
			isEmpty=true;
		
		assertTrue(isEmpty);
	}

}

