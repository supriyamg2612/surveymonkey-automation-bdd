package com.supriya.surveymonkey.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	
	public static String readProperty(String key) throws Exception {

		Properties property = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/Properties/config.properties");
		property.load(fis);
		return property.getProperty(key);
		
		
}
}
