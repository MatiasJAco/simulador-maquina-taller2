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
		assertEquals("58", result);
		assertFalse(myAlu.isOverflow());
	}
	

}
