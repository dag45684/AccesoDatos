package AccesoDatos.eval1;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Ex16T2 {
	public static void main(String[] args) {
		
		File f = new File("C:\\Users\\Tarde\\IdeaProjects\\AccesoDatos\\rndData\\binaryDouble.txt");
		if(f.exists()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\Tarde\\IdeaProjects\\AccesoDatos\\rndData\\binaryDouble.txt"));
//				DataInputStream ois = new DataInputStream(new FileInputStream("C:\\Users\\Tarde\\IdeaProjects\\AccesoDatos\\rndData\\binaryDouble.txt"));
				try {
					while(true) System.out.println(ois.readDouble());
				}catch (Exception e) {
					ois.close();
				}
			}catch (Exception e) {
				System.err.println("Unknown error, " + e);
			}
				
		}else System.err.println("no such file");

	}

}
