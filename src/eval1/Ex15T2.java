package eval1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Ex15T2 {

	public static void main(String[] args) throws IOException {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Write a double:");
		Double n = s.nextDouble();
		File f = new File("rndData\\doubd.txt");
			if(f.exists() || f.createNewFile()) {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f, true));
				while(n != -1) {
					try {
						oos.writeDouble(n);
						n = s.nextDouble();
					}catch (Exception e) {
						System.err.println("Couldnt write file.");
					}
				}
				oos.close();
		}
	}

}
