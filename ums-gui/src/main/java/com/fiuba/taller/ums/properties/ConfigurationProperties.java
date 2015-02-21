package com.fiuba.taller.ums.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationProperties  {
	
	private static ConfigurationProperties instance;
	private Properties prop;
	
	private ConfigurationProperties(){
		InputStream input = null;
	 
		try {
			prop = new Properties();
			input = new FileInputStream(getClass().getResource("/properties/config.properties").getPath());
	 
			// load a properties file
			prop.load(input);
	 	 
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static ConfigurationProperties getInstance(){
		if (instance == null){
			instance = new ConfigurationProperties();
		}
		return instance;
	}
	
	public String getProperty(String name){
		 return prop.getProperty(name);
	}
	
}
