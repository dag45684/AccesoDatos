package examenEv1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Ejercicio3Examen {

	public static void main(String[] args) {
		
		File f = new File("paExamen\\Ejer2\\refrane.txt"); //Creamos el file
		Scanner s = new Scanner(System.in);
		boolean ok = false;
		char c = '\0';
		while(!ok) { //obligamos a que sea un solo caracter
			System.out.print("Introduce una vocal: ");
			String temp = s.nextLine();
			if (temp.length() == 1) ok = true;
			else System.err.println("Por fvor introduce solo una vocal.");
			c = temp.charAt(0);
		}
		try {
			//creamos los buffers
			BufferedReader br = new BufferedReader (new FileReader(f));
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File ("paExamen\\Ejer2\\refranesCON" + c + ".txt")));
			try {
				while(true) { //durante todo el fichero:
					String linea = br.readLine(); //leemos
					if (linea != null) {
						bw.write(linea.replaceAll("[aeiou]", ""+c));//reemplazamos y escribimos
					}else throw new Exception(); //al finalizar lanzamos una exception que cerrara los buffers
				}
			}catch (Exception e) {
				System.out.println("Final del proceso. Cerrando buffers...");
				br.close();
				bw.close();
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
		

	}

}
