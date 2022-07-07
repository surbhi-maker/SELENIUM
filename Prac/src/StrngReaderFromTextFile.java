import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class StrngReaderFromTextFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

			
			// Documents\FilesToBeRead
		
		String buffer[];
		String line;
		int count = 0;
		
		File f = new File("D:\\Users\\SKourav\\OneDrive - Element Financial Corp\\Documents\\FilesToBeRead.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		Scanner sc = new Scanner(System.in);
		
		String text = sc.nextLine();
		
		
		while((line = br.readLine())!= null) {
			buffer = line.split(" ");
			
			for(String wrd : buffer) {
				if(wrd.trim().equals(text.replaceAll("\\s*", " ").trim())) {
					count++;
				}
			}
		}
		
		if(count == 0) {
			System.out.println("word not present in the page");
		}
		else {
			System.out.println("count of word present in the page:"+ count);
		}
		fr.close();
	}

}
