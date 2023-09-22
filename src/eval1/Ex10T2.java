package eval1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex10T2 {

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("rndData\\classlist.txt");
		Scanner s = new Scanner(f);
		int lines = 0;
		int words = 0;
		int chars = 0;
		while (s.hasNext()) {
			String a = s.nextLine();
			lines++;
			words += a.split(" ").length;
			chars += a.length();
			System.out.println(a);
			if(lines == 20) {
				System.out.println("-------------------------");
				System.out.println(lines+" lines | "+words+" words | "+chars+" characters.");
				System.out.println("Type Q to quit, or any other key to continue");
				Scanner sc = new Scanner(System.in);
				if (sc.nextLine().toLowerCase() == "q") break;
			}
		}
	}

}
