package eval1;

import java.io.File;
import java.io.IOException;

public class Ex2T1 {

	public static void main(String[] args) {
		String dir = "//newdir/";
		File f = new File(dir);
		f.mkdir();
		try {
			new File(f, "finalfile").createNewFile();
			File rename = new File(f, "file2");
			rename.createNewFile();
			File newname = new File("finalrenamedfile");
			rename.renameTo(newname);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
