package eval1;

import java.io.File;
import java.util.Scanner;

public class Ex3T1 {

	public static void main(String[] args) {
		String dir = "//newdir/";
		File f = new File(dir);
		if(f.listFiles().length == 0) f.delete();
		else {
			System.out.println("Following files within the directory. Delete anyways? Type Y to proceed");
			for(File file : f.listFiles()) System.out.println(file.getName());
			Scanner sc = new Scanner(System.in);
			if(sc.next().equals("Y")) {
				for(File file : f.listFiles()) {
					file.delete();
				}
				f.delete();
			}
			sc.close();
		}
	}

}