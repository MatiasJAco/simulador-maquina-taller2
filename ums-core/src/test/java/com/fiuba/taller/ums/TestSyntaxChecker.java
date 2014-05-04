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
		boolean result= SyntaxChecker.checkAssembly("ldm 3,8E");
		assertTrue(result);
	}

	@Test
	public void testChequearAssemblerCargaI() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkAssembly("ldi 3,8E");
		assertTrue(result);
	}
	@Test
	public void testChequearAssemblerAlmacen() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkAssembly("stm 3,8E");
		assertTrue(result);
	}
	@Test
	public void testChequearAssemblerCopia() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkAssembly("cop 3,A");
		assertTrue(result);
	}
	@Test
	public void testChequearAssemblerSuma() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkAssembly("add 3,A,2");
		assertTrue(result);
	}
	@Test
	public void testChequearAssemblerSumaF() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkAssembly("addf 3,A,2");
		assertTrue(result);
	}
	@Test
	public void testChequearAssemblerOr() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkAssembly("or 3,A,2");
		assertTrue(result);
	}
	@Test
	public void testChequearAssemblerAnd() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkAssembly("and 3,A,2");
		assertTrue(result);
	}
	@Test
	public void testChequearAssemblerXor() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkAssembly("xor 3,A,2");
		assertTrue(result);
	}
	@Test
	public void testChequearAssemblerRotd() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkAssembly("rotd 3,8");
		assertTrue(result);
	}
	@Test
	public void testChequearAssemblerSalta() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkAssembly("jpz 3,8E");
		assertTrue(result);
	}
	@Test
	public void testChequearAssemblerParar() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkAssembly("ret");
		assertTrue(result);
	}
	
	@Test
	public void testChequearMaqCargaM() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkMaq("00  138E");
		assertTrue(result);
	}
	@Test
	public void testChequearMaqCargaI() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkMaq("00  238E");
		assertTrue(result);
	}
	@Test
	public void testChequearMaqAlmacen() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkMaq("00  338E");
		assertTrue(result);
	}
	@Test
	public void testChequearMaqCopia() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkMaq("00  403A");
		assertTrue(result);
	}
	@Test
	public void testChequearMaqSuma() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkMaq("00  53A2");
		assertTrue(result);
	}
	@Test
	public void testChequearMaqSumaF() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkMaq("00  63A2");
		assertTrue(result);
	}
	@Test
	public void testChequearMaqOr() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkMaq("00  73A2");
		assertTrue(result);
	}
	@Test
	public void testChequearMaqAnd() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkMaq("00  83A2");
		assertTrue(result);
	}
	@Test
	public void testChequearMaqXor() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkMaq("00  93A2");
		assertTrue(result);
	}
	@Test
	public void testChequearMaqRotd() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkMaq("00  A308");
		assertTrue(result);
	}
	@Test
	public void testChequearMaqSalta() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkMaq("00  B38E");
		assertTrue(result);
	}
	@Test
	public void testChequearMaqParar() throws InputFileFormatException {
		boolean result= SyntaxChecker.checkMaq("00  C000");
		assertTrue(result);
	}	
	

}
