package Pruebas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Observable;
import java.util.Observer;

import com.fiuba.taller.ums.ControlUnit;
import com.fiuba.taller.ums.Instruction;
import com.fiuba.taller.ums.Memory;
import com.fiuba.taller.ums.RegisterMemory;
import com.fiuba.taller.ums.RetInstruction;

public class Modelo extends Observable{	
	private Memory myMemory;
	private RegisterMemory myRegMem;
	private ControlUnit myControlUnit;	
	public int step = 0;
	public static final int PROGRAMASININICIAR = 0;
	public static final int PROGRAMACORRIENDO = 1;
	public static final int PROGRAMAFINALIZADO = 2;
	private int estado = -1;
	private File file = null;
	
	public Modelo(Observer o) {		
		addObserver(o);
	}
	
	private void inicializar() {
		myMemory = new Memory() ;
		myRegMem = new RegisterMemory();
		myControlUnit = new ControlUnit(myMemory,myRegMem);	
	}
	
	public void recargarPrograma() {
		if(file != null) {			
			cargarPrograma(file);
		}
	}
	
	// no comprueba que sea un .maq, carga lo que venga
	public void cargarPrograma(File input) {
		FileReader reader;
		BufferedReader buffer;
		String line = null;
		
		inicializar();
		try {	
			reader  = new FileReader(input);
			buffer = new BufferedReader(reader);

			while((line = buffer.readLine()) != null) {
				if(line.length() != 0) {
					line = line.substring(4); // ignora los numeros del lado izquierdo
					myControlUnit.loadInstructionToMemory(line);		
				}
			}
			estado = PROGRAMASININICIAR;
			file = input;
			notificar();

		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public void notificar() {
		setChanged();
		notifyObservers();
	}
	
	public void ejecutarPrograma() {
		Instruction i = null;
		
		if(estado == PROGRAMASININICIAR || estado == PROGRAMACORRIENDO) {
			do{
				myControlUnit.fetchInstruction();
				i = myControlUnit.decode();
				myControlUnit.executeCurrentInstruction();
			}while(!(i instanceof RetInstruction));

			estado = PROGRAMAFINALIZADO;
			notificar();
		}
	}
	
	public void ejecutarPasoApaso() {
		Instruction i = null;
		if(estado == PROGRAMASININICIAR || estado == PROGRAMACORRIENDO) {
			myControlUnit.fetchInstruction();
			i = myControlUnit.decode();
			myControlUnit.executeCurrentInstruction();

			step++;			
			estado = (i instanceof RetInstruction)?PROGRAMAFINALIZADO:PROGRAMACORRIENDO;
			notificar();
		}
	}

	public Memory getMemory() {
		return myMemory;
	}
	
	public RegisterMemory getRegisterMemory() {
		return myRegMem;
	}
	
	public ControlUnit getControlUnity() {
		return myControlUnit; 
	}
	
	public int getEstado() {
		return estado;
	}
	
}
