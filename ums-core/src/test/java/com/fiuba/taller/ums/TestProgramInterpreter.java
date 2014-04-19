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

import org.junit.Test;

public class TestProgramInterpreter {

	@Test
	public void testCensura() {
		ProgramInterpreter pi = new ProgramInterpreter();
		String result= pi.censura("Esto es un test esto es.", "test", 0);
		assertEquals("Esto es un  esto es.",result);
	}


	@Test
	public void testInterpretarCargaM() throws InputFileFormatException {
		ProgramInterpreter pi = new ProgramInterpreter();
		String result= pi.interpret("ldm R,XY");
		assertEquals("1RXY",result);
	}

	@Test
	public void testInterpretarCargaI() throws InputFileFormatException {
		ProgramInterpreter pi = new ProgramInterpreter();
		String result= pi.interpret("ldi R,XY");
		assertEquals("2RXY",result);
	}@Test
	public void testInterpretarAlmacen() throws InputFileFormatException {
		ProgramInterpreter pi = new ProgramInterpreter();
		String result= pi.interpret("stm R,XY");
		assertEquals("3RXY",result);
	}@Test
	public void testInterpretarCopia() throws InputFileFormatException {
		ProgramInterpreter pi = new ProgramInterpreter();
		String result= pi.interpret("cop R,S");
		assertEquals("40RS",result);
	}@Test
	public void testInterpretarSuma() throws InputFileFormatException {
		ProgramInterpreter pi = new ProgramInterpreter();
		String result= pi.interpret("add R,S,T");
		assertEquals("5RST",result);
	}@Test
	public void testInterpretarSumaF() throws InputFileFormatException {
		ProgramInterpreter pi = new ProgramInterpreter();
		String result= pi.interpret("addf R,S,T");
		assertEquals("6RST",result);
	}@Test
	public void testInterpretarOr() throws InputFileFormatException {
		ProgramInterpreter pi = new ProgramInterpreter();
		String result= pi.interpret("or R,S,T");
		assertEquals("7RST",result);
	}@Test
	public void testInterpretarAnd() throws InputFileFormatException {
		ProgramInterpreter pi = new ProgramInterpreter();
		String result= pi.interpret("and R,S,T");
		assertEquals("8RST",result);
	}@Test
	public void testInterpretarXor() throws InputFileFormatException {
		ProgramInterpreter pi = new ProgramInterpreter();
		String result= pi.interpret("xor R,S,T");
		assertEquals("9RST",result);
	}@Test
	public void testInterpretarRotd() throws InputFileFormatException {
		ProgramInterpreter pi = new ProgramInterpreter();
		String result= pi.interpret("rotd R,X");
		assertEquals("AR0X",result);
	}@Test
	public void testInterpretarSalta() throws InputFileFormatException {
		ProgramInterpreter pi = new ProgramInterpreter();
		String result= pi.interpret("jpz R,XY");
		assertEquals("BRXY",result);
	}
	@Test
	public void testInterpretarParar() throws InputFileFormatException {
		ProgramInterpreter pi = new ProgramInterpreter();
		String result= pi.interpret("ret");
		assertEquals("C000",result);
	}



	@Test
	public void testGenerarCodigoMaquina() {
		ProgramInterpreter pi = new ProgramInterpreter();
		pi.generateAbsoluteCodeFile("C:\\temp\\input.asm");
	}


}









