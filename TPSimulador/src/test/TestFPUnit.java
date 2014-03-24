package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFPUnit {

	//Pasar de un punto flotante en hexa a decimal
	@Test
	public void testPuntoFlotanteADecimal() {
		float result = FPUnit.puntoFlotanteADecimal("01010001");
		assertEquals(2.125, result,0.0000001);
	}

}
