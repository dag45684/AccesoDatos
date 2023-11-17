package Examen20231106;

import java.io.File;

public class Ejercicio2Examen {

	public static void main(String[] args) {

		if (args[0] != null) {
			File f = new File(args[0]);
			
			
		}
		else System.err.println("No se ha podido encontrar la ruta especificada");
	}

}
