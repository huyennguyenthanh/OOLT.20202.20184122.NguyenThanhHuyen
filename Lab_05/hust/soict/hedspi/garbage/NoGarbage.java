package hust.soict.hedspi.garbage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NoGarbage {


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String url = "F:\\vanban.txt";
		FileInputStream file = null;
		BufferedReader buffer = null;

		String s = "";
		StringBuilder sb = new StringBuilder();
		try {
			file = new FileInputStream(url);
			buffer = new BufferedReader(new InputStreamReader(file));

			
			long start =  System.currentTimeMillis();
			String line = buffer.readLine();
			while (line != null) {
				System.out.println(line);
				sb.append(line);
				line = buffer.readLine();
			}
			s = sb.toString();
			System.out.println(System.currentTimeMillis() - start);
			
			
			
		} catch (FileNotFoundException ex) {
			Logger.getLogger(GarbageCreator.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(GarbageCreator.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				buffer.close();
				file.close();
			} catch (IOException ex) {
				Logger.getLogger(GarbageCreator.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		

}
}
