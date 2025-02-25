package com.comcast.crm.generic.listener_Utility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.webdriverutility.UtilityClass;

public class Listener implements ITestListener, ISuiteListener{
	
	ExtentReports report;
	public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		String dobj= new Date().toString().replace(" ","_").replace(":", "_");
		ExtentSparkReporter spark= new ExtentSparkReporter("./Advancereport/report+"+dobj+"+.html");
		spark.config().setDocumentTitle("Vtiger CRM Report");
		spark.config().setReportName("Vtiger");
		spark.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Browser", "Chrome");

		
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		report.flush();
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClass.setTest(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String method = result.getMethod().getMethodName();
		String dobj= new Date().toString().replace(" ","_").replace(":", "_");
		TakesScreenshot ts= (TakesScreenshot) UtilityClass.getDriver();
		String src = ts.getScreenshotAs(OutputType.BASE64);
		UtilityClass.getTest().addScreenCaptureFromBase64String(src, method+"_"+dobj);
		UtilityClass.getTest().log(Status.FAIL, "Failed");
		UtilityClass.getTest().log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
}
