package AccesoDatos.eval1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ex09T2 {

	public static void main(String[] args) throws IOException {
		
		ArrayList<String> names = new ArrayList<>();
		for (String s : args) {
			names.add(s);
		}
		File f = new File("rndData\\classlist.txt");
		if(f.createNewFile() || f.exists()){
			BufferedWriter br = new BufferedWriter(new FileWriter(f, true));
			names.forEach(e -> {
				try {
					br.write(e);
				} catch (IOException err) {
					System.err.println("Write error -->" + err);
				}
			});
			br.close();
		}else {
			System.err.println("File was not created successfully");
		}
	}
}
