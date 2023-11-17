package examenEv1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class Ejercicio4_BExamen {

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
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			try {
				raf.seek(index * 10); //accedemos al indice que nos interesa
			} catch (IOException e) {
				System.err.println("Id demasiado grande.");
				return;
			}
			try {
				int id = raf.readInt(); //almacenamos el int
				if (id < 1) throw new Exception();
				raf.writeInt(-1); //le damos valor -1
				raf.seek((index * 10)+4);//movemos el puntero
				String apellidos = raf.readLine();
				raf.writeChars("-1" +apellidos.replaceAll(".", " ").substring(2)); //introducimos el id guardado y espacios para llenar el size de bytes
				raf.seek((index * 10)+6);
				raf.writeInt(0);//movemos el puntero y sobreescribimos
				System.out.println("Fichero borrado correctamente");
				raf.close();
			}catch (Exception e) {
				System.out.println("No existe emlpeado en el id especificado...");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		mostrarEliminados();//mostramos los eliminados
	}
	
	public static void mostrarEliminados() {
		//creamos el mismo sistema para el fichero que arriba
		File f = new File("paExamen\\Ejer3\\AleatorioEmple.dat"); 
		int index = 0;
		StringBuilder sb = new StringBuilder();
			try {
				RandomAccessFile raf = new RandomAccessFile(f, "rw");
				while(true) {
					try {
						int id = raf.readInt();
						if (id == -1) { // si nos encontramos con el id-1 ha sido borrado, movemos el puntero, leemos y seguimos
							raf.seek((index * 10)+4);
							String apellidos = raf.readLine();
							sb.append(apellidos.trim()+ " ");
						}
					}catch (Exception e) {
						raf.close();
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				System.out.println("Los ID eliminados corresponden a: "+sb); //imprimimos los ids borrados almacenados en el stringbuilder
			}
		
	}

}
