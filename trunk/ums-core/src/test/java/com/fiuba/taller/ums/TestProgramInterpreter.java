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
		String result= pi.interpret("ldm 1,A8");
		assertEquals("11A8",result);
	}

	@Test
	public void testInterpretarCargaI() throws InputFileFormatException {
		String result= pi.interpret("ldi 1,A8");
		assertEquals("21A8",result);
	}
	
	@Test
	public void testInterpretarAlmacen() throws InputFileFormatException {
		String result= pi.interpret("stm 1,A8");
		assertEquals("31A8",result);
	}
	
	@Test
	public void testInterpretarCopia() throws InputFileFormatException {
		String result= pi.interpret("cop 1,3");
		assertEquals("4013",result);
	}
	
	@Test
	public void testInterpretarSuma() throws InputFileFormatException {
		String result= pi.interpret("add 1,10,11");
		assertEquals("51AB",result);
	}
	
	@Test
	public void testInterpretarSumaF() throws InputFileFormatException {
		String result= pi.interpret("addf 1,10,11");
		assertEquals("61AB",result);
	}
	
	@Test
	public void testInterpretarOr() throws InputFileFormatException {
		String result= pi.interpret("or 1,10,11");
		assertEquals("71AB",result);
	}
	
	
	@Test
	public void testInterpretarAnd() throws InputFileFormatException {
		String result= pi.interpret("and 1,10,11");
		assertEquals("81AB",result);
	}
	
	@Test
	public void testInterpretarXor() throws InputFileFormatException {
		String result= pi.interpret("xor 1,10,11");
		assertEquals("91AB",result);
	}
	
	@Test
	public void testInterpretarRotd() throws InputFileFormatException {
		String result= pi.interpret("rotd 1,A");
		assertEquals("A10A",result);
	}
	
	@Test
	public void testInterpretarSalta() throws InputFileFormatException {
		String result= pi.interpret("jpz 1,A8");
		assertNotEquals("B1A8",result);
	}
	
	@Test
	public void testInterpretarParar() throws InputFileFormatException {
		String result= pi.interpret("ret");
		assertEquals("C000",result);
	}



	@Test
	public void testGenerarCodigoMaquina() {
		pi.generateAbsoluteCodeFile(".\\src\\main\\resources\\input2.asm");
	}


}









