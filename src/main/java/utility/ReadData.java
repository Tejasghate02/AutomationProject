package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadData {

	
	//to read all the important data 
			public static String readPropertyFile(String value) throws IOException {
				
				Properties prop = new Properties();
				FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/testData/config.properties");
				prop.load(file);
				return prop.getProperty(value);
			}
}
