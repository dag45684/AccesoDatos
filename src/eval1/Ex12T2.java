package eval1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex12T2 {

	public static void main(String[] args) throws IOException {
		
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
					c.forEach(e -> System.out.println(e));
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
			BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
			bw.write(reg);
			bw.close();
			
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
	

}
