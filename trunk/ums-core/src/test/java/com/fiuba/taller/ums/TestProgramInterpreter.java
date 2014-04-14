package com.fiuba.taller.ums;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Test;

public class TestProgramInterpreter {

	@Test
	public void testCensura() {
		ProgramInterpreter pi = new ProgramInterpreter();
		String result= pi.censura("Esto es un test esto es.", "test", 0);
		assertEquals("Esto es un  esto es.",result);
	}


	@Test
	public void testInterpretarCargaM() {
		ProgramInterpreter pi = new ProgramInterpreter();
		String result= pi.interpret("ldm R,XY");
		assertEquals("1RXY",result);
	}

	@Test
	public void testInterpretarCargaI() {
		ProgramInterpreter pi = new ProgramInterpreter();
		String result= pi.interpret("ldi R,XY");
		assertEquals("2RXY",result);
	}@Test
	public void testInterpretarAlmacen() {
		ProgramInterpreter pi = new ProgramInterpreter();
		String result= pi.interpret("stm R,XY");
		assertEquals("3RXY",result);
	}@Test
	public void testInterpretarCopia() {
		ProgramInterpreter pi = new ProgramInterpreter();
		String result= pi.interpret("cop R,S");
		assertEquals("40RS",result);
	}@Test
	public void testInterpretarSuma() {
		ProgramInterpreter pi = new ProgramInterpreter();
		String result= pi.interpret("add R,S,T");
		assertEquals("5RST",result);
	}@Test
	public void testInterpretarSumaF() {
		ProgramInterpreter pi = new ProgramInterpreter();
		String result= pi.interpret("addf R,S,T");
		assertEquals("6RST",result);
	}@Test
	public void testInterpretarOr() {
		ProgramInterpreter pi = new ProgramInterpreter();
		String result= pi.interpret("or R,S,T");
		assertEquals("7RST",result);
	}@Test
	public void testInterpretarAnd() {
		ProgramInterpreter pi = new ProgramInterpreter();
		String result= pi.interpret("and R,S,T");
		assertEquals("8RST",result);
	}@Test
	public void testInterpretarXor() {
		ProgramInterpreter pi = new ProgramInterpreter();
		String result= pi.interpret("xor R,S,T");
		assertEquals("9RST",result);
	}@Test
	public void testInterpretarRotd() {
		ProgramInterpreter pi = new ProgramInterpreter();
		String result= pi.interpret("rotd R,X");
		assertEquals("AR0X",result);
	}@Test
	public void testInterpretarSalta() {
		ProgramInterpreter pi = new ProgramInterpreter();
		String result= pi.interpret("jpz R,XY");
		assertEquals("BRXY",result);
	}
	@Test
	public void testInterpretarParar() {
		ProgramInterpreter pi = new ProgramInterpreter();
		String result= pi.interpret("ret");
		assertEquals("C000",result);
	}



	@Test
	public void testFileHandling() {

		// The name of the file to open.
		String fileName = "c:\\temp\\input.txt";

		// This will reference one line at a time
		String line = null;

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = 
					new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = 
					new BufferedReader(fileReader);

			while((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}	

			// Always close files.
			bufferedReader.close();			
		}
		catch(FileNotFoundException ex) {
			System.out.println(
					"Unable to open file '" + 
							fileName + "'");				
		}
		catch(IOException ex) {
			System.out.println(
					"Error reading file '" 
							+ fileName + "'");					
			// Or we could just do this: 
			// ex.printStackTrace();
		}

		//Escritura
		
		String f = "c:\\temp\\output.txt";

		
		try{

			FileWriter w = new FileWriter(f);

			BufferedWriter bw = new BufferedWriter(w);

			PrintWriter wr = new PrintWriter(bw);  

			wr.write("Esta es una linea de codigo");//escribimos en el archivo

			wr.append(" - y aqui continua"); //concatenamos en el archivo sin borrar lo existente

			//ahora cerramos los flujos de canales de datos, al cerrarlos el archivo quedará guardado con información escrita

			//de no hacerlo no se escribirá nada en el archivo

			wr.close();

			bw.close();

		}catch(IOException e){};

	}



}









