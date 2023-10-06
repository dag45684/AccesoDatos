package eval1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WriteBinSerial {

	public static void main(String[] args) {
		
		//Writing the binary
		SerPerson person;
		String path = "rndData\\";
		File f = new File(path+"serial.dat");
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			String[] names = {"Ana", "Alicia", "Nuria", "Abel", "Pablo"}; 
			int[] ages = {14,54,25,32,12};
			for(int i=0; i<ages.length; i++) {
				person = new SerPerson(names[i], ages[i]);
				oos.writeObject(person);
			}
			oos.close();
		} catch (Exception e) {System.out.println(e);}
		
		//Reading the binary
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			while(true) {
				System.out.println((SerPerson)ois.readObject());
			}
		}catch (Exception e) {}
	}
}
