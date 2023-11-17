package examenEv1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio4_AExamen {

	public static void main(String[] args) {
		
		File f = new File("paExamen\\Ejer3\\AleatorioEmple.dat");
		int index = 0;
		if(args[0] != null) { //si tenemos argumentos
			index = Integer.parseInt(args[0]);
		} else {
			System.err.println("Argumentos invalidos o no encontrados. Finalizando programa...");
			return;
		}

		try {
			RandomAccessFile raf = new RandomAccessFile(f, "r");
			try {
				raf.seek(index * 10); //accedemos al punto en el cual queremos leer el id
			} catch (IOException e) {
				System.err.println("Id demasiado grande.");
				return;
			}
			try { //realizamos las lecturas y movemos el puntero el tamano que tengan los componentes leidos
				int id = raf.readInt();
				raf.seek((index * 10)+4);
				String apellidos = raf.readLine();
				raf.seek((index * 10)+6);
				int dept = raf.readInt();
				System.out.printf("Id: %d, Apellido: %s, Departamento: %d", id, apellidos, dept);
				raf.close(); //cerramos el fichero
			}catch (Exception e) {
				System.out.println("Id: "+index+", no existe emlpeado...");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
