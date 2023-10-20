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
		if(!f.exists()) f.createNewFile();
		ArrayList<String> c = new ArrayList<>();
		populate(f, c);
		System.out.println("Type Add for Creating a new entry. Type Show for printing all your entries.");
		boolean ok = false;
		while (!ok) {
			String console = br.readLine();	
			switch (console) {
			case "Add":
				addentry(br, c, f);
				populate(f, c);
				break;
			case "Show":
				c.forEach(e -> {
					try {
						System.out.println(byteToStr(e));
					} catch (Exception err) {}
				});
				break;
			case "Search":
				searchentry(br, c, f);
				break;
			default:
				System.out.println(console.toLowerCase().equals("quit") ? "Program has stopped." : "Wrong command. Program has stopped.");
				ok=true;
			}
		if(!ok) System.out.println("Type Add for Creating a new entry. Type Show for printing all your entries. Type Search for looking for an entry.");
		}
		br.close();
	}
	
	static void searchentry(BufferedReader br, ArrayList<String> c, File f) throws IOException {
		System.out.println("Provide Name, DNI or Phone number:");
		String s = br.readLine();
		for(String p : c) {
			if (byteToStr(p).contains("["+s+"]")) {
				System.out.println(byteToStr(p));
				return;
			}
		}
		System.out.println("No such entry");
	}
	static void addentry(BufferedReader br, ArrayList<String> c, File f) throws IOException {
		if (c.size() < 30) {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f, true));
			System.out.println("Provide Name:");
			String s = br.readLine();
			if (checkreg(s,c)) {
				System.err.println("Already exists");
				oos.close();
				return;
			}
			String reg = "Name:" + s;
			System.out.println("Provide DNI:");
			s = br.readLine();
			if (checkreg(s,c)) {
				System.err.println("Already exists");
				oos.close();
				return;
			}
			reg += " DNI:" + s;
			System.out.println("Provide Phone:");
			s = br.readLine();
			if (checkreg(s,c)) {
				System.err.println("Already exists");
				oos.close();
				return;
			}
			reg += " Phone:" + s;
			byte[] b = reg.getBytes();
			try {
				oos.write(b);
			}catch (Exception e) {
				System.err.println("Couldnt write file.");
			}
			oos.flush();
			oos.close();
		}else System.err.println("Too many entries (max. 30)");
	}
	
	static boolean checkreg (String s, ArrayList<String> c) throws FileNotFoundException, IOException {
		for(String x : c) {
			if (byteToStr(x).contains(s)) {
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

	static String byteToStr(String f) throws FileNotFoundException, IOException {
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

	static void populate(File f, ArrayList<String> c) throws FileNotFoundException {
		Scanner s = new Scanner(f);
		while(s.hasNext()) {
			c.add(s.next());
		}
		s.close();
	}
	


}
