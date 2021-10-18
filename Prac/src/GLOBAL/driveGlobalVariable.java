package GLOBAL;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class driveGlobalVariable {

	public static void main(String[] args) throws IOException {
		
		Properties prop = new Properties();
		
		FileInputStream fis = new FileInputStream("D:\\Users\\SKourav\\copy\\Prac\\src\\GLOBAL\\data.properties");
		prop.load(fis);
		prop.getProperty("url");
		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("url"));
		
		prop.setProperty("browser", "FireFox");
		System.out.println(prop.getProperty("browser"));
		
		System.out.println("updating **");
		FileOutputStream fos = new FileOutputStream("D:\\Users\\SKourav\\copy\\Prac\\src\\GLOBAL\\data.properties");
		prop.store(fos, null);
		System.out.println(prop.getProperty("browser"));
	}

}
