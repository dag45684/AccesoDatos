package eval1;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Ex14T2 {

	public static void main(String[] args) {
		
		File f = new File("rndData\\doub.txt");
		if(f.exists()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("rndData\\doub.txt"));
				Double d = ois.readDouble();
				System.out.println(d);
			}catch (Exception e) {
				System.err.println("Unknown error, " + e);
			}
				
		}else System.err.println("no such file");

	}

}
