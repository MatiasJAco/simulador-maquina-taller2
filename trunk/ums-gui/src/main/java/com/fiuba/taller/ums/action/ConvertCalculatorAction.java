package com.fiuba.taller.ums.action;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import com.fiuba.taller.ums.FPUnit;
import com.fiuba.taller.ums.HexaConverter;
import com.fiuba.taller.ums.component.Calculator;

public class ConvertCalculatorAction implements KeyListener {
	private Calculator myCalculator;
	
	public ConvertCalculatorAction(Calculator calculator) {
		myCalculator = calculator;				
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		e.setKeyChar(convertirCharMayuscula(e.getKeyChar()));			
		
		if(!caracterValido(e.getKeyChar())) {					
			e.consume();
		}		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == KeyEvent.VK_ENTER) {
			String numero = myCalculator.getNumberInput();
			
			if(entradaValida(numero)) {
				myCalculator.setResult(getResult(numero));
			}
			else {
				myCalculator.informarError();
			}
		}		
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	/*
	 *  desde este metodo se llama a los metodos del core que encargan de convertir numeros 
	 */
	private String getResult(String text) {				
		if(myCalculator.esConvertirDecimalAHexadecimal()) {
			if(myCalculator.esConvertirComplemento2()) {
				return HexaConverter.decimalToBaseC2(Integer.parseInt(text), 16);
			}			
		    return FPUnit.decimalAPuntoFlotante(Float.parseFloat(text));
		} else {
			if(myCalculator.esConvertirComplemento2()) {
				return Integer.toString(HexaConverter.hexaToDecimalC2(text));
			}
			return Float.toString(FPUnit.puntoFlotanteADecimal(text));
		}
	}	

	private boolean caracterValido(char car) {
		if(charEsNumero(car) || charEsMenos(car) || charEsPunto(car) || charEsLetra(car)) {
			return true;
		}
		return false;
	}
	
	// comprueba todos los caracteres ingresados antes de realizar la conversion 
	private boolean entradaValida(String numero) {
		if(myCalculator.esConvertirDecimalAHexadecimal()) {
			if(myCalculator.esConvertirComplemento2()) {		
				try {
					Integer.parseInt(numero);
					return true;
				}
				catch(NumberFormatException e) {}			
			} else {
				try {
					Float.parseFloat(numero);
					return true;
				}
				catch(NumberFormatException e) {}
			}
		} else {
			char car;
			for(int i = 0; i < numero.length(); i++) {
				car = numero.charAt(i);
				if( !(charEsLetra(car) || charEsNumero(car)) ) {
					return false;
				}
			}
			return true;
		}
			
		
		return false;
	}


	private boolean charEsPunto(char punto) {
		return (punto == '.')?true:false;
	}
	
	private boolean charEsMenos(char signo) {
		return (signo == '-')?true:false;
	}
		
	private boolean charEsNumero(char num) {
		if((num >= '0') && (num <= '9')) {
			return true;
		}
		return false;
	}
	
	private boolean charEsLetra(char car) {
		if(car == 'A' || car == 'B' || car == 'C' || car == 'D' || car == 'E' || car == 'F') {
			return true;
		}
		return false;
	}
	
	private char convertirCharMayuscula(char car) {
		String cad = " ";
		
		cad = cad.replace(' ', car).toUpperCase();
		return cad.charAt(0);
	}
}
