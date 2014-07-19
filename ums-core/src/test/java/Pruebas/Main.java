package Pruebas;

public class Main {

	public static void main(String[] args) {
		Vista vista = new Vista();
		Modelo modelo = new Modelo(vista);
		
		vista.setModelo(modelo);
		

	}

}
