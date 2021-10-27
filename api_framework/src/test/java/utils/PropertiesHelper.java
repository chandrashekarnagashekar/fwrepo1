package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {

	public static String getGlobalProperty(String fileName, String key) {
		
		FileInputStream fis;
		String propertyValue = null;
		try {
			fis = new FileInputStream("src/test/resources/"+fileName+".properties");
			Properties prop = new Properties();
			prop.load(fis);
			propertyValue = prop.getProperty(key);			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return propertyValue;		
	}
}
