package UtilityLayer;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import BaseLayer.BaseClass;

public class ExtentReportSetUp extends BaseClass {
	
	
	public static  ExtentReports setUp(String reportName) {
		
		ExtentReports extentReports= new ExtentReports();
	
		String destinationPath=System.getProperty("user.dir")+"\\ExtentReports\\"+DateAndTime.captureYear()+"\\"+DateAndTime.captureMonthAndYear()+"\\"+reportName+DateAndTime.caputreCurrentDatehAndTime()+".html";
	
		extentReports.attachReporter(new ExtentSparkReporter(destinationPath));
		return extentReports;
	}

}
