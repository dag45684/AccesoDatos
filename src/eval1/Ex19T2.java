package eval1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex19T2 {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		File f = new File("rndData\\contacts.txt");
		int MS= 30;
		if (f.exists() || f.createNewFile()) {
			ArrayList<String> c = new ArrayList<>();
			Scanner s = new Scanner(f);
			while(s.hasNext()) {
				c.add(s.next());
			}
			System.out.println("Type Add for Creating a new entry. Type Show for printing all your entries.");
			boolean ok = false;
			while (!ok) {
				String console = br.readLine();	
				switch (console) {
				case "Add":
					addentry(br, c, f);
					break;
				case "Show":
					c.forEach(e -> {
						try {
							System.out.println(byteToStr(f));
						} catch (Exception err) {}
					});
					break;
				}
			}
		}
	}
	
	static void addentry(BufferedReader br, ArrayList<String> c, File f) throws IOException {
		if (c.size() < 50) {
			System.out.println("Provide Name:");
			String s = br.readLine();
			if (checkreg(s,c)) {
				System.err.println("Already exists");
				return;
			}
			String reg = s;
			System.out.println("Provide DNI:");
			s = br.readLine();
			if (checkreg(s,c)) {
				System.err.println("Already exists");
				return;
			}
			reg += s;
			System.out.println("Provide Phone:");
			s = br.readLine();
			if (checkreg(s,c)) {
				System.err.println("Already exists");
				return;
			}
			reg += s;
			byte[] b = reg.getBytes();
			try {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f, true));
				oos.write(b);
				oos.close();
			}catch (Exception e) {
				System.err.println("Couldnt write file.");
			}
		}else System.err.println("Too many entries (max. 30)");
	}
	
	static boolean checkreg (String s, ArrayList<String> c) {
		for(String x : c) {
			if (x.contains(s)) {
				return true;
			}
		}
	return false;
	}
	
	static String byteToStr(File f) throws FileNotFoundException, IOException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
		StringBuilder sb = new StringBuilder();
		int c = ois.read();
		while(c != -1) {
			sb.append((char)c);
			c = ois.read();
		}
		ois.close();
		return sb.toString();
	}
	


}
