package com.fiuba.taller.ums;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fiuba.taller.ums.HexaConverter;

public class TestHexa {

	
	//Numero diez.
	@Test
	public void testDiez() {
		int result = HexaConverter.baseToDecimal("A",16);
		assertEquals(10, result);		
	}
	
	//Numero once.
	@Test
	public void testOnce() {
		int result = HexaConverter.baseToDecimal("B",16);
		assertEquals(11, result);		
	}
		
	//Numero doce.
	@Test
	public void testDoce() {
		int result = HexaConverter.baseToDecimal("C",16);
		assertEquals(12, result);		
	}

	//Numero trece.
	@Test
	public void testTrece() {
		int result = HexaConverter.baseToDecimal("D",16);
		assertEquals(13, result);		
	}

	//Numero catorce.
	@Test
	public void testCatorce() {
		int result = HexaConverter.baseToDecimal("E",16);
		assertEquals(14, result);		
	}

	//Numero quince.
	@Test
	public void testQuince() {
		int result = HexaConverter.baseToDecimal("F",16);
		assertEquals(15, result);		
	}

	//Numero comun 1 caracter
	@Test
	public void testCuatro() {
		int result = HexaConverter.baseToDecimal("4",16);
		assertEquals(4, result);		
	}
	
	//Numero comun 2 caracteres
	@Test
	public void testDosCaracteres() {
		int result = HexaConverter.baseToDecimal("EF",16);
		assertEquals(239, result);		
	}

	//Numero comun 3 caracteres
	@Test
	public void testTresCaracteres() {
		int result = HexaConverter.baseToDecimal("FFF",16);
		assertEquals(4095, result);		
	}

	//Numero comun 4 caracteres
	@Test
	public void testCuatroCaracteres() {
		int result = HexaConverter.baseToDecimal("3A5D",16);
		assertEquals(14941, result);		
	}

	//Decimal a hexa de 2 digitos
		@Test
		public void testDecimalAHexaUNO() {
			String result = HexaConverter.decimalToBase(10,16,8);
			assertEquals("0A", result);		
		}
	
	//Decimal a hexa de 2 digitos
	@Test
	public void testDecimalAHexaDos() {
		String result = HexaConverter.decimalToBase(239,16);
		assertEquals("EF", result);		
	}
	
	//Decimal a hexa de 3 digitos
	@Test
	public void testDecimalAHexaTres() {
		String result = HexaConverter.decimalToBase(4095,16);
		assertEquals("FFF", result);		
	}

		
	//Decimal a hexa de 4 digitos
	@Test
	public void testDecimalAHexaCuatro() {
		String result = HexaConverter.decimalToBase(14941,16);
		assertEquals("3A5D", result);		
	}
	

	//Decimal a binario de 2 digitos
	@Test
	public void testDecimalABinarioUno() {
		String result = HexaConverter.decimalToBase(3,2);
		assertEquals("00000011", result);		
	}

	//Decimal a binario de 3 digitos
	@Test
	public void testDecimalABinarioTres() {
		String result = HexaConverter.decimalToBase(5,2);
		assertEquals("00000101", result);		
	}

	//Decimal a binario de 4 digitos
	@Test
	public void testDecimalABinarioCuatro() {
		String result = HexaConverter.decimalToBase(14,2);
		assertEquals("00001110", result);		
	}
	//Decimal a binario de 8 digitos
	@Test
	public void testDecimalABinarioOcho() {
		String result = HexaConverter.decimalToBase(178,2);
		assertEquals("10110010", result);		
	}
	
	//Hexadecimal a binario
	@Test
	public void testHexaABinario() {
		String result = HexaConverter.hexaToBinary("3A5D0");
		assertEquals("111010010111010000", result);		
	}
	
	//Binario a decimal
	@Test
	public void testBinarioADecimal() {
		int result = HexaConverter.baseToDecimal("11101001011101",2);
		assertEquals(14941, result);		
	}

	//Hexa a decimal en c2
	@Test
	public void testHexaADecimalC2() {
		int result = HexaConverter.hexaToDecimalC2("E2");
		assertEquals(-30, result);		
	}
	
	
	//Decimal a base 16
	@Test
	public void testDecimalAHexaC2() {
		String result = HexaConverter.decimalToBaseC2(-30, 16);
		assertEquals("E2", result);		
	}
	
	
}
