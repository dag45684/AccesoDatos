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
			while(!str.equals("")) {
					raf.seek(100);
					raf.writeChars(str);
				str = s.nextLine();
			}
			raf.close();
			s.close();
		}catch (Exception e) {}
		System.out.println("Writing done. Now reading.......");
		try {
			RandomAccessFile raf = new RandomAccessFile(f, "r");
			raf.seek(0);
			try {
				StringBuilder sb = new StringBuilder();
				String temp = raf.readLine();
				while(temp!=null) {
					sb.append(temp);
					temp = raf.readLine();
				}
				System.out.println(sb);
			}catch(Exception e){
				raf.close();
			}
		}catch (Exception e) {}
		

	}

}
