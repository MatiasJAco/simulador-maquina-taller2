package com.fiuba.taller.ums;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.junit.BeforeClass;
import org.junit.Test;


public class TestProgram2 {
	private static Memory myMemory;
	private static RegisterMemory myRegMem;
	private static ControlUnit myControlUnit;	
	private static String primerNumero = "2D";
	private static String segundoNumero = "32";
	private static String tercerNumero = "88";
	private static String cuartoNumero = "D2";
	private String parteMasSignificativa = "B6";
	private String parteMenosSignificativa = "04";
	
	@BeforeClass
	public static void loadProgram() throws Exception{		
		String path = Thread.currentThread().getContextClassLoader().getResource("prueba2.maq").getFile();
		FileInputStream fis = new FileInputStream(path);		
		
		@SuppressWarnings("resource")
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis, "UTF-8"));			
		String line = null;
		
		myMemory = new Memory() ;
		myRegMem = new RegisterMemory();
		myControlUnit = new ControlUnit(myMemory,myRegMem);
		
		myControlUnit.loadInstructionToMemory("21" + primerNumero);
		myControlUnit.loadInstructionToMemory("22" + segundoNumero);
		myControlUnit.loadInstructionToMemory("23" + tercerNumero);
		myControlUnit.loadInstructionToMemory("24" + cuartoNumero);
		
		while((line = bufferedReader.readLine()) != null) 
			if(line.length() != 0) {
				myControlUnit.loadInstructionToMemory(line);							
			}
	}

	
	/*
	 *  Se suman dos numeros compuesto de 2 cifras en base hexadecimal
	 *  primer  operando: 	2D32
	 *  segundo operando:	4457
	 *  resultado suma:		7189
	 *  
	 *  la parte mas significativa se almacena en el registro 10 y la menos significativa en el 11
	 */
	@Test
	public void testExecuteProgram() {
		Instruction endInstruction = null;
		
		do{
			myControlUnit.fetchInstruction();
			endInstruction = myControlUnit.decode();
			myControlUnit.executeCurrentInstruction();
		}while(!(endInstruction instanceof RetInstruction));
		
		assertEquals(parteMasSignificativa,myRegMem.readReg("A"));
		assertEquals(parteMenosSignificativa,myRegMem.readReg("B"));
	}
	
}
