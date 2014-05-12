package com.fiuba.taller.ums;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fiuba.taller.ums.FPUnit;

public class TestFPUnit {

	//Pasar de un punto flotante en hexa a decimal
	@Test
	public void testPuntoFlotanteADecimalPositivo() {
		float result = FPUnit.puntoFlotanteADecimal("51");
		assertEquals(2.125, result, 0.0000001);
	}
	
	@Test
	public void testPuntoFlotanteADecimalNegativo() {
		float result = FPUnit.puntoFlotanteADecimal("A9");
		assertEquals(-0.390625, result, 0.0000001);
	}
	
	@Test
	public void testDecimalAPuntoFlotantePositivo() {
		String result = FPUnit.decimalAPuntoFlotante((float) 2.125);
		assertEquals("51", result);
	}
	
	@Test
	public void testDecimalAPuntoFlotanteNegativo() {
		String result = FPUnit.decimalAPuntoFlotante((float) -0.390625);
		assertEquals("A9", result);
	}

}
