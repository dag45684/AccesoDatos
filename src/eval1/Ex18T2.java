package eval1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Ex18T2 {

	public static void main(String[] args) throws IOException {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Write a sentence:");
		File f = new File("rndData\\bimstrs.txt");
		String sentence = s.nextLine();
		while(!sentence.equals("")) {
			byte[] b = sentence.getBytes();
			if(f.exists() || f.createNewFile()) {
				try {
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f, true));
					oos.write(b);
					oos.write((byte)'\n');
					oos.close();
				}catch (Exception e) {
					System.err.println("Couldnt write file.");
				}
			}
			sentence = s.nextLine();
		}
	}
}
