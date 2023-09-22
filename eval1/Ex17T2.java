package AccesoDatos.eval1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Ex17T2 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Write a sentence:");
		String sentence = s.nextLine();
		byte[] b = sentence.getBytes();
		File f = new File("rndData\\bistr.txt");
		if(f.exists() || f.createNewFile()) {
			try {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f, true));
				oos.write(b);
//				oos.write((byte)-1); //Aqui estaba intentando romper java. Tehee
				oos.close();
			}catch (Exception e) {
				System.err.println("Couldnt write file.");
			}
			System.out.println("Writing done\nNow retrieving string:");
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				StringBuilder sb = new StringBuilder();
//				StringBuilder sub = new StringBuilder(); //Idem
				int c = ois.read();
				while(c != -1) {
					sb.append((char)c);
//					sub.append(c + " "); //Idem
					c = ois.read();
				}
				System.out.println(sb);
//				System.out.println(sub); //Idem
				ois.close();
			}catch (Exception e) {
				System.err.println("Couldnt write file.");
			}
		}
	}
}
