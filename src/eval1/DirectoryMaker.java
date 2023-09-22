package eval1;

import java.io.File;

public class DirectoryMaker {

	public static void main(String[] args) {
		
		File dir = new File(".\\test");
		if(dir.mkdir()) {
			System.out.println("Directorio creado.");
		}else {
			System.err.println("Directorio no creado.");
			if(dir.exists()) {
				System.err.println("--> El directorio ya existe.");
			}else {
				System.err.println("No se ha podido ejecutar el comando.");
			}
		}
	}
}
