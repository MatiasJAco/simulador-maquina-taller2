package com.fiuba.taller.ums;

public class testPasoAPasoConsola {


	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CycleController usin = new CycleController();
		MockNextStepButton nextB = new MockNextStepButton(usin);
		CicloFetchPasoAPasoThread hiloFetch = new CicloFetchPasoAPasoThread("C:\\pruebaASM\\prueba 1TEST.maq",usin);
		hiloFetch.start();
		
		
		
		
	}

}
