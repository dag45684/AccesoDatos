package AccesoDatos.eval1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Ex13T2 {

	public static void main(String[] args) throws IOException {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Write a double:");
		Double n = s.nextDouble();
		File f = new File("rndData\\doub.txt");
			if(f.exists() || f.createNewFile()) {
			try {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f, true));
				oos.writeDouble(n);
				oos.close();
			}catch (Exception e) {
				System.err.println("Couldnt write file.");
			}
		}
	}

}
