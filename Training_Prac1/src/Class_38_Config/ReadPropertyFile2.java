package Class_38_Config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadPropertyFile2 {
	
	@Test
	public void readProp() throws IOException {
		
		Properties prop = new Properties(); 
		
		prop.load( new FileInputStream(new File(System.getProperty("user.dir")+"/Config/Config.properties")));
		
		
		System.out.println("url is:"+ prop.getProperty("url"));
		System.out.println("url is:"+ prop.getProperty("browser"));
		System.out.println("url is:"+ prop.getProperty("timeout"));
		System.out.println("url is:"+ prop.getProperty("BT_AccessToken"));
		
	}
}
