package hust.soict.hedspi.garbage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GarbageCreator {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String url = "F:\\vanban.txt";
		FileInputStream file = null;
		BufferedReader buffer = null;

		
		String s = "";
		try {
			file = new FileInputStream(url);
			buffer = new BufferedReader(new InputStreamReader(file));

			
			long start =  System.currentTimeMillis();
			String line = buffer.readLine();
			while (line != null) {
				System.out.println(line);
				s += line;
				line = buffer.readLine();
			}
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
		
		
		
		
		// this prints roughly 45000
		
		

	}

}
