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
	
	public String getDriverPath(){
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the configFIle.properties file.");		
	}
	
	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait not specified in the configFIle.properties file.");		
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("URL");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the configFIle.properties file.");
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
	
	public String getSaucePageTitle() {
		String saucePageTitle = properties.getProperty("saucePageTitle");
		if(saucePageTitle != null) return saucePageTitle;
		else throw new RuntimeException("saucePageTitle not specified in the configFIle.properties file.");
	}
	
	public String getFirstName() {
		String firstName = properties.getProperty("firstName");
		if(firstName != null) return firstName;
		else throw new RuntimeException("firstName not specified in the configFIle.properties file.");
	}
	
	public String getloginPassword() {
		String loginPassword = properties.getProperty("loginPassword");
		if(loginPassword != null) return loginPassword;
		else throw new RuntimeException("loginPassword not specified in the configFIle.properties file.");
	}
	
	public String getlastName() {
		String lastName = properties.getProperty("lastName");
		if(lastName != null) return lastName;
		else throw new RuntimeException("lastName not specified in the configFIle.properties file.");
	}
	
	public String getZip() {
		String Zip = properties.getProperty("Zip");
		if(Zip != null) return Zip;
		else throw new RuntimeException("Zip not specified in the configFIle.properties file.");
	}
	
	public String getstandardUsername() {
		String standardUsername = properties.getProperty("standardUsername");
		if(standardUsername != null) return standardUsername;
		else throw new RuntimeException("standardUsername not specified in the configFIle.properties file.");
	}
	
	public String getlockedUsername() {
		String lockedUsername = properties.getProperty("lockedUsername");
		if(lockedUsername != null) return lockedUsername;
		else throw new RuntimeException("lockedUsername not specified in the configFIle.properties file.");
	}

	public String getLockedUserError() {
		String lockedUserError = properties.getProperty("lockedUserError");
		if(lockedUserError != null) return lockedUserError;
		else throw new RuntimeException("lockedUserError not specified in the configFIle.properties file.");
	}

}
