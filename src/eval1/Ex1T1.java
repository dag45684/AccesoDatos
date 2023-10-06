package eval1;

import java.io.File;
import java.util.Arrays;

public class Ex1T1 {

	public static void main(String[] args) {
		if(args[0].equals("")) {
			System.err.println("Must provide a directory");
		}else {
			File f = new File(args[0]);
			System.out.println(f.exists() ? Arrays.toString(f.listFiles()) : "El directorio no existe");
		}
	}
}