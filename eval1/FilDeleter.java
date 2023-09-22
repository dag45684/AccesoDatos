package AccesoDatos.eval1;

import java.io.File;

public class FilDeleter {

	public static void main(String[] args) {
		
		File f = new File(".\\test\\data.txt");
		if(f.delete()) {
			System.out.println("Fichero eliminado");
		}else {
			System.err.println("Fichero no eliminado");
			if(!f.exists()) {
				System.err.println("--> Fichero no existente");
			}else System.err.println(". Razon desconocida");
		}
		
		File d = new File(".\\manouver");
		if(f.delete()) {
			System.out.println("Directorio eliminado");
		}else {
			System.err.println("Directorio no eliminado");
			if(!f.exists()) {
				System.err.println("--> Directorio no existente");
			}else System.err.println(". Razon desconocida");
		}
	}
}
