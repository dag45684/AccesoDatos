package AccesoDatos.eval1;

import java.io.File;

import javax.sound.midi.SysexMessage;

public class DirectoryParse {

	public static void main(String[] args) {
		String path = ".";
		if (args.length>1) path=args[0];
		File f = new File(path);
		if(!f.exists()) {
			System.err.println("No existe el fichero o directorio " + path);
		}else {
			System.out.println(path + " contains:");
			File[] files = f.listFiles();

			for (File x : files) System.out.println(x.isDirectory() ? "(file)"+x.getName() : "/"+x.getName());
		}
	}

}
