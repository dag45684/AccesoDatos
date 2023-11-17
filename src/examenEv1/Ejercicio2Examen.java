package examenEv1;
import java.io.File;

public class Ejercicio2Examen {

	public static void main(String[] args) {

		//Si args no es null
		if (args[0] != null) {
			System.out.println("Directorio a eliminar: " + args[0]);
			File f = new File(args[0]); //creamos el file 
			if (f.exists()){
				borrarFiles(f.listFiles(), f); //lo borramos de forma recursiva
			}else System.err.println("El fichero no existe");
			
		}
		else if (args.length > 1 || args.length == 0) System.err.println("Se han introducido demasiados argumentos");
		else System.err.println("Ruta no especificada");
	}

	//si se encuentra una carpeta accede a ella borra sus contenidos
	//y continua borrando en la carpeta padre (recursivo)
	public static void borrarFiles(File[] l, File file) { 
		for(int i=0; i<l.length; i++) {
			if (l[i].isDirectory()) borrarFiles(l[i].listFiles(), l[i]);
			else {
				System.out.println("Archivo eliminado: " + l[i].getName());
				l[i].delete();
			}
		}
		System.out.println("Carpeta eliminada: " + file.getName());
		file.delete();
	}
}
