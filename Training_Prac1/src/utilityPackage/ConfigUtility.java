package utilityPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtility {

	static Properties pro;
	public static String getProperty(String key) throws FileNotFoundException, IOException {
		
		createInstance();
		return pro.getProperty(key);
	}
	
	public static Properties createInstance() {
			
		if(pro==null) {
			System.out.println("Creating new object of properties");
			pro = new Properties(); 
			try {
				pro.load( new FileInputStream(new File(System.getProperty("user.dir")+"/Config/Config.properties")));
			} 
			catch (IOException e) {
				System.out.println("could not load file");
			}
			return pro;
		}
		else
		{
			System.out.println("Existing object found -->reusing");
			return pro;
		}
	}
}
