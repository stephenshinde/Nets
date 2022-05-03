package com.API.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.automation.helpers.ConfigFileReader;
import com.automation.helpers.ReportHelper;

import io.restassured.RestAssured;

public class Base {
	String projectpath=System.getProperty("user.dir");
	public ConfigFileReader reader = new ConfigFileReader();
	
	@BeforeClass
	public void initializeSetting() {
		// start extent report methood
		ReportHelper.startExtentReport(projectpath+ "/Reports/APIreport.html");

	}
	@BeforeMethod
	public void init() {
		
		RestAssured.baseURI = reader.getBaseURI();
	}
	
	@AfterClass
	public void endSetting() {
	ReportHelper.closeExtentReport();
	}
	

}
