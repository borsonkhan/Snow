package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties  {
	
	
	public  String getProperty(String key) {
		
		String value = " ";
		
		Properties prop = loadProperty("testRun");
		
		value = prop.getProperty(key);
		
		if (value == null) {
			
			
			String testEnv = prop.getProperty("testEnv");
			
			prop = loadProperty(testEnv);
			
			value = prop.getProperty(key);
		}
		
		return value;
	}
	
	public  String getsaucelabsProperty(String key) {
		String value = null;
		

		Properties prop = new Properties();
		
		value = prop.getProperty(key);
		
		return value ;
		
	}
	
	
	public  Properties loadProperty (String prodFileName) {
		Properties prop = new Properties();
		
		String filePath = ".\\src\\main\\resources\\properties\\"+ prodFileName+ ".properties";
		
		
		try {
			
			File file = new File(filePath);
			FileInputStream fileInputStream = new FileInputStream(file);
			prop.load(fileInputStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			
			
		
		
		
		return prop;
		
	}
	

}
