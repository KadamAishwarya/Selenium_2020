package com.visionIt.freeCrm.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	public Properties prop;
	
	public ConfigDataProvider() 
	{
		try {
			FileInputStream fins=new FileInputStream(new File(".//Config//config.properties"));
			prop=new Properties();
			prop.load(fins);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getBrowser(String browserName) {

		return prop.getProperty(browserName);
	}

	public String getUrl(String urlName) {

		return prop.getProperty(urlName);
	}

	public String getKey(String keyName) {

		return prop.getProperty(keyName);
	}
}
