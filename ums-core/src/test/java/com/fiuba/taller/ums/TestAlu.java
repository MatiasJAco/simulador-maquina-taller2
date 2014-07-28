package com.fiuba.taller.ums;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAlu {

	@Test
	//10 + 1 = 11
	public void testSumC2Positives() {
		ALU myAlu = new ALU();
		String result = myAlu.sumC2("0A", "01");
		assertEquals("0B", result);		
		assertFalse(myAlu.isOverflow());
	}
	
	@Test
	//-120 + - 2 = -122
	public void testSumC2Negatives() {
		ALU myAlu = new ALU();
		String result = myAlu.sumC2("88", "FE");
		assertEquals("86", result);		
		assertFalse(myAlu.isOverflow());
	}
	
	@Test
	// 54 - 15 = 39
	public void testSumC2PositiveNegativePositiveResult() {
		ALU myAlu = new ALU();
		String result = myAlu.sumC2("36", "F1");
		assertEquals("27", result);
		assertFalse(myAlu.isOverflow());
	}
	
	@Test
	//77 - 111 = -34
	public void testSumC2PositiveNegativeNegativeResult() {
		ALU myAlu = new ALU();
		String result = myAlu.sumC2("4D", "91");
		assertEquals("DE", result);
		assertFalse(myAlu.isOverflow());
	}
	
	@Test
	//Overflow : 77 + 66 = 143
	public void testSumC2Overflow() {
		ALU myAlu = new ALU();
		String result = myAlu.sumC2("4D", "42");
		assertEquals("8F", result);
		assertTrue(myAlu.isOverflow());
	}
	
	@Test
	//1.8125 + 1.125 = 2.9375
	public void testSumFPositive() {
		ALU myAlu = new ALU();
		String result = myAlu.sumF("4D", "42");
//		String result = myAlu.sumF("30", "50");
		assertEquals("58", result);
		assertFalse(myAlu.isOverflow());
	}
	
	@Test
	//1.5 - 2 = -0.5
	public void testSumFNegative() {
		ALU myAlu = new ALU();
		String result = myAlu.sumF("48", "D0");
//		String result = myAlu.sumF("50", "D0");
//		String result = myAlu.sumF("78", "CB");
		assertEquals("B0", result);
		assertFalse(myAlu.isOverflow());
	}
	
	
	@Test
	//1.8125 + 1.125 = 2.9375
	public void testSumFPrecisionPositivo() {
		ALU myAlu = new ALU();
		String result = myAlu.sumFPrecisionCheck("30", "50");
//		String result = myAlu.sumF("4D", "42");
		assertEquals("54", result);
		assertFalse(myAlu.isOverflow());
	}
	@Test
	//-2 + 2 = 0.0
		public void testSumFPrecisionNegativo() {
			ALU myAlu = new ALU();
//			String result = myAlu.sumFPrecisionCheck("48", "D0");
			String result = myAlu.sumFPrecisionCheck("D0", "50");
//			String result = myAlu.sumFPrecisionCheck("78", "CB");
			assertEquals("00", result);
			assertFalse(myAlu.isOverflow());
		}

}
