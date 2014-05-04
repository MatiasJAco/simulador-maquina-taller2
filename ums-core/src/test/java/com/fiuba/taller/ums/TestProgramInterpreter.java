package com.fiuba.taller.ums;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class TestProgramInterpreter {
	
	private ProgramInterpreter pi;
	
	@Before
    public void init() {
		pi = new ProgramInterpreter();
    }
	
	@Test
	public void testInterpretarCargaM() throws InputFileFormatException {
		String result= pi.interpret("ldm R,XY");
		assertEquals("1RXY",result);
	}

	@Test
	public void testInterpretarCargaI() throws InputFileFormatException {
		String result= pi.interpret("ldi R,XY");
		assertEquals("2RXY",result);
	}
	
	@Test
	public void testInterpretarAlmacen() throws InputFileFormatException {
		String result= pi.interpret("stm R,XY");
		assertEquals("3RXY",result);
	}
	
	@Test
	public void testInterpretarCopia() throws InputFileFormatException {
		String result= pi.interpret("cop R,S");
		assertEquals("40RS",result);
	}
	
	@Test
	public void testInterpretarSuma() throws InputFileFormatException {
		String result= pi.interpret("add R,S,T");
		assertEquals("5RST",result);
	}
	
	@Test
	public void testInterpretarSumaF() throws InputFileFormatException {
		String result= pi.interpret("addf R,S,T");
		assertEquals("6RST",result);
	}
	
	@Test
	public void testInterpretarOr() throws InputFileFormatException {
		String result= pi.interpret("or R,S,T");
		assertEquals("7RST",result);
	}
	
	
	@Test
	public void testInterpretarAnd() throws InputFileFormatException {
		String result= pi.interpret("and R,S,T");
		assertEquals("8RST",result);
	}
	
	@Test
	public void testInterpretarXor() throws InputFileFormatException {
		String result= pi.interpret("xor R,S,T");
		assertEquals("9RST",result);
	}
	
	@Test
	public void testInterpretarRotd() throws InputFileFormatException {
		String result= pi.interpret("rotd R,X");
		assertEquals("AR0X",result);
	}
	
	@Test
	public void testInterpretarSalta() throws InputFileFormatException {
		String result= pi.interpret("jpz R,XY");
		assertEquals("BRXY",result);
	}
	
	@Test
	public void testInterpretarParar() throws InputFileFormatException {
		String result= pi.interpret("ret");
		assertEquals("C000",result);
	}



	@Test
	public void testGenerarCodigoMaquina() {
		pi.generateAbsoluteCodeFile(".\\src\\main\\resources\\input.asm");
	}


}









