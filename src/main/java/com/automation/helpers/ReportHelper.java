package com.automation.helpers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportHelper {
	
	public static ExtentReports extent;
	public static ExtentHtmlReporter htmlrporter;
	public static ExtentTest extenttest;
	
	
	public static void startExtentReport(String projectpath) {
		htmlrporter = new ExtentHtmlReporter(projectpath);
		extent = new ExtentReports();
		extent.attachReporter(htmlrporter);
	}
	
	public static void closeExtentReport() {
		extent.flush();
	}
	
	public static ExtentTest addTestCasename(String testcasename , String description) {
		return extent.createTest(testcasename, description);
	}

}
