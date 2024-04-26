package Project;
//Java Packages
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//To store result in txt file format
public class TxtFile {
	public static void Output(String out) throws IOException {
		File f=new File("./src/output.txt");
			f.createNewFile();
			FileWriter fw=new FileWriter(f);
			fw.write(out);
			fw.close();
		
	}

}
