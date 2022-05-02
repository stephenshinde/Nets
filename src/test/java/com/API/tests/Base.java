package com.API.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.automation.helpers.ReportHelper;

import io.restassured.RestAssured;

public class Base {
	String projectpath=System.getProperty("user.dir");
	
	@BeforeClass
	public void initializeSetting() {
		// start extent report methood
		ReportHelper.startExtentReport(projectpath+ "/Reports/APIreport.html");

	}
	@BeforeTest
	public void init() {
		
		RestAssured.baseURI = "https://relay-candidate.proxy.beeceptor.com/";
	}
	
	@AfterClass
	public void endSetting() {
	ReportHelper.closeExtentReport();
	}
	

}
