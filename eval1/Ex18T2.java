package AccesoDatos.eval1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Ex18T2 {

	public static void main(String[] args) throws IOException {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Write a sentence:");
		File f = new File("rndData\\bimstrs.txt");
		f.delete();
		f.createNewFile();
		String sentence = s.nextLine();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f, true));
		while(!sentence.equals("")) {
			byte[] b = sentence.getBytes();
			if(f.exists()) {
				try {
					oos.write(b);
					oos.write((byte)'\n');
				}catch (Exception e) {
					System.err.println("Couldnt write file.");
				}
			}
			sentence = s.nextLine();
		}
		oos.close();
		System.out.println("Now Printing....");
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			StringBuilder sb = new StringBuilder();
			int c = ois.readByte();
			try {
				while(true) {
					sb.append((char)c);
					c = ois.readByte();
				}
			} catch (Exception e) {
				System.err.println(e);
				ois.close();
			}
			System.out.println(sb);
		}catch (Exception e) {
			System.err.println("Couldnt write file.");
		}
	}
}
