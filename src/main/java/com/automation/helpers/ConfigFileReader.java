package com.automation.helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath= System.getProperty("user.dir")+"/src/main/java/com/automation/config/configFile.properties";

	
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("configFIle.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getBaseURI() {
		String URI = properties.getProperty("URI");
		if(URI != null) return URI;
		else throw new RuntimeException("URI not specified in the configFIle.properties file.");
	}
	
	public String getResourcePath() {
		String ResourcePath = properties.getProperty("ResourcePath");
		if(ResourcePath != null) return ResourcePath;
		else throw new RuntimeException("ResourcePath not specified in the configFIle.properties file.");
	}
	
	public String getInvalidURIResourcePath() {
		String InvalidURIResourcePath = properties.getProperty("InvalidURIResourcePath");
		if(InvalidURIResourcePath != null) return InvalidURIResourcePath;
		else throw new RuntimeException("InvalidURIResourcePath not specified in the configFIle.properties file.");
	}
	
	public String getExtentReportPath(){
		String extentReportPath = properties.getProperty("extentPath");
		if(extentReportPath!= null) return extentReportPath;
		else throw new RuntimeException("extent report path is  not specified in the configFIle.properties file.");		
	}
	
	public String getExtentconfigPath(){
		String extentConfigPath = properties.getProperty("extentconfigPath");
		if(extentConfigPath!= null) return extentConfigPath;
		else throw new RuntimeException("extent config path is not specified in the configFIle.properties file.");		
	}
	
	
}
