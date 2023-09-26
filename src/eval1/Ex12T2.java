package eval1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex12T2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		File f = new File("rndData\\contacts.txt");
		if(!f.exists()) f.createNewFile();
		ArrayList<String> c = new ArrayList<>();
		populate(f, c);
		System.out.println("Type Add for Creating a new entry. Type Show for printing all your entries. Type Search for looking for an entry.");
		boolean ok = false;
		while (!ok) {
			String console = br.readLine();	
			switch (console) {
			case "Add":
				addentry(br, c, f);
				populate(f, c);
				break;
			case "Show":
				c.forEach(System.out::println);
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
			if (p.contains("["+s+"]")) {
				System.out.println(p);
				return;
			}
		}
		System.out.println("No such entry");
	}
	
	static void addentry(BufferedReader br, ArrayList<String> c, File f) throws IOException {
		if (c.size() < 50) {
			BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
			System.out.println("Provide Name:");
			String s = br.readLine();
			if (checkreg(s,c)) {
				System.err.println("Already exists");
				bw.close();
				return;
			}
			String reg = "Name:" + s;
			System.out.println("Provide DNI:");
			s = br.readLine();
			if (checkreg(s,c)) {
				System.err.println("Already exists");
				bw.close();
				return;
			}
			reg += " DNI:" + s;
			System.out.println("Provide Phone:");
			s = br.readLine();
			if (checkreg(s,c)) {
				System.err.println("Already exists");
				bw.close();
				return;
			}
			reg += " Phone:" + s + "\n";
			bw.write(reg);
			bw.flush();
			bw.close();
			
		}else System.err.println("Too many entries (max. 30)");
	}
	
	static boolean checkreg (String s, ArrayList<String> c) {
		for(String x : c) {
			if (x.contains("["+s+"]")) {
				return true;
			}
		}
	return false;
	}
	
	static void populate(File f, ArrayList<String> c) throws FileNotFoundException {
		Scanner s = new Scanner(f);
		while(s.hasNext()) {
			c.add(s.next());
		}
		s.close();
	}
	

}
