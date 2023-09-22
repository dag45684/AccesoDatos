package AccesoDatos.eval1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Ex11T2 {

	public static void main(String[] args) throws IOException {

		File f = new File("rndData\\test.txt");
		if(f.exists()){
			BufferedWriter br = new BufferedWriter(new FileWriter(f, true));
			br.write("\nNew line!");
			br.close();
		}else System.err.println("No such file");
	}
}
