package com.fiuba.taller.ums;

import static org.junit.Assert.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class TestSyntaxChecker {

	Logger log;
	
	@Before
    public void init() {
		BasicConfigurator.resetConfiguration();
		BasicConfigurator.configure();
    }
	
	@Test
	public void testChequearAssemblerCargaM() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkAssembly("ldm R,XY");
		assertTrue(result);
	}

	@Test
	public void testChequearAssemblerCargaI() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkAssembly("ldi R,XY");
		assertTrue(result);
	}
	@Test
	public void testChequearAssemblerAlmacen() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkAssembly("stm R,XY");
		assertTrue(result);
	}
	@Test
	public void testChequearAssemblerCopia() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkAssembly("cop R,S");
		assertTrue(result);
	}
	@Test
	public void testChequearAssemblerSuma() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkAssembly("add R,S,T");
		assertTrue(result);
	}
	@Test
	public void testChequearAssemblerSumaF() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkAssembly("addf R,S,T");
		assertTrue(result);
	}
	@Test
	public void testChequearAssemblerOr() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkAssembly("or R,S,T");
		assertTrue(result);
	}
	@Test
	public void testChequearAssemblerAnd() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkAssembly("and R,S,T");
		assertTrue(result);
	}
	@Test
	public void testChequearAssemblerXor() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkAssembly("xor R,S,T");
		assertTrue(result);
	}
	@Test
	public void testChequearAssemblerRotd() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkAssembly("rotd R,X");
		assertTrue(result);
	}
	@Test
	public void testChequearAssemblerSalta() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkAssembly("jpz R,XY");
		assertTrue(result);
	}
	@Test
	public void testChequearAssemblerParar() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkAssembly("ret");
		assertTrue(result);
	}
	
	@Test
	public void testChequearMaqCargaM() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkMaq("1RXY");
		assertTrue(result);
	}
	@Test
	public void testChequearMaqCargaI() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkMaq("2RXY");
		assertTrue(result);
	}
	@Test
	public void testChequearMaqAlmacen() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkMaq("3RXY");
		assertTrue(result);
	}
	@Test
	public void testChequearMaqCopia() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkMaq("40RS");
		assertTrue(result);
	}
	@Test
	public void testChequearMaqSuma() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkMaq("5RST");
		assertTrue(result);
	}
	@Test
	public void testChequearMaqSumaF() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkMaq("6RST");
		assertTrue(result);
	}
	@Test
	public void testChequearMaqOr() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkMaq("7RST");
		assertTrue(result);
	}
	@Test
	public void testChequearMaqAnd() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkMaq("8RST");
		assertTrue(result);
	}
	@Test
	public void testChequearMaqXor() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkMaq("9RST");
		assertTrue(result);
	}
	@Test
	public void testChequearMaqRotd() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkMaq("AR0X");
		assertTrue(result);
	}
	@Test
	public void testChequearMaqSalta() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkMaq("BRXY");
		assertTrue(result);
	}
	@Test
	public void testChequearMaqParar() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkMaq("C000");
		assertTrue(result);
	}	
	

}
