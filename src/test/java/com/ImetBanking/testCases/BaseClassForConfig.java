package com.ImetBanking.testCases;
import java.io.File;
import java.io.IOException;



import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.ImetBanking.utilities.*;

public class BaseClassForConfig {
	ReadConfig rc=new ReadConfig();
	
	public static Logger logger;
	
	public String BaseURL=rc.getURL();
	public String username=rc.userName();
	public String password=rc.getPwd();
	public  WebDriver driver;
	public String cs;
	static public int i=0;
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br) throws InterruptedException
	{
		logger=LogManager.getLogger(this);
		
		logger.debug("Driver instantiated");
		if(br.equals("firefox"))
			driver=new FirefoxDriver();
		else
			if(br.equals("chrome"))
			driver=new ChromeDriver();
		else
			if(br.equals("edge"))
			driver=new EdgeDriver();
		
		Thread.sleep(10000);
		
	    driver.get(BaseURL);
		driver.manage().window().maximize();
		logger.debug("Navigated to URL");
		
	}
	
	
	public void captureScreen(WebDriver driver, String tname) 
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+(i++)+".png");
		try {
			FileUtils.copyFile(source,target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(target.getAbsolutePath());
		
	}
	@AfterClass
	public void tearDown()
	{
		//driver.quit();
	}
	 

}
