package Class_38_Config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import utilityPackage.ConfigUtility;

public class ReadPropertyFileUsingUtility {
	
	@Test
	public void readProp() throws IOException {
		System.out.println("url is:"+ ConfigUtility.getProperty("url"));
		System.out.println("url is:"+ ConfigUtility.getProperty("browser"));
		
	}
}
