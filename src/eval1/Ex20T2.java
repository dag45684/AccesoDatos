package eval1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ex20T2 {

	public static void main(String[] args) throws IOException { //THIS PROGRAM IS NOT WORKING PROPERLY
		
		File f = new File("rndData\\rnd.txt");
		f.delete();
		f.createNewFile();
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		try {
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			int idx = 0;
			while(!str.equals("")) {
				raf.seek(idx);
				raf.writeChars(str);
				raf.writeChars("\n");
				idx += 100;
				str = s.nextLine();
			}
			raf.close();
			s.close();
		}catch (Exception e) {}
		System.out.println("Writing done. Now reading.......");
		try {
			RandomAccessFile raf = new RandomAccessFile(f, "r");
			raf.seek(0);
			StringBuilder sb = new StringBuilder();
			try {
				char temp = raf.readChar();
				while(true) {
					sb.append(temp);
					temp = raf.readChar();
				}
			}catch(Exception e){
				raf.close();
				System.out.println(sb.toString().trim().replaceAll(" +", ""));
			}
		}catch (Exception e) {}
		

	}

}
