package com.ImetBanking.utilities;

import java.text.SimpleDateFormat;
import com.ImetBanking.testCases.*;
import java.util.Date;

//Listener class used to generate extent reports
import java.io.*;


import org.testng.*;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;




public class Reporting implements ITestListener{

	public ExtentReports extent;
	public ExtentSparkReporter Reporter;
	public ExtentTest logger;
	
	public void onStart(ITestContext testContext)
	{
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Test-Report-"+timeStamp+".html";
		Reporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		try {
			Reporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extent=new ExtentReports();
		extent.attachReporter(Reporter);
		extent.setSystemInfo("Host name", "local Host");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("USer", "Shikha");
		
		Reporter.config().setDocumentTitle("InetBanking Test Project ");
		Reporter.config().setReportName("Functional Test Automation Report");
		
		Reporter.config().setTheme(Theme.DARK);		
		
	}

	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN ) );
		System.out.println("Report generated  /....");
	}
	
	//@SuppressWarnings("deprecation")
	public void onTestFailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());//create a new entry in report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String imagePath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+(BaseClassForConfig.i)+".png";
		
		File f=new File(imagePath);
		if(f.exists())
		{
			logger.fail("Screenshot is below : "+logger.addScreenCaptureFromPath(imagePath));
			
		}
	}
			
			
	
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext tr)
	{
		extent.flush();
	}
}
