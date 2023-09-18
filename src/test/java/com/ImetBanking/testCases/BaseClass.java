package com.ImetBanking.testCases;


import org.apache.logging.log4j.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseClass {
	
/*
 * User ID : 	mngr524555
Password : 	rErupun 	
 */
	public static Logger logger;
	public String BaseURL="https://demo.guru99.com/V4/index.php";
	public String username="mngr524555";
	public String password="rErupun";
	public static FirefoxDriver driver;
	
	@BeforeClass
	public void setup()
	{
		logger=LogManager.getLogger(this);
		
		logger.debug("Driver instantiated");
		driver=new FirefoxDriver();
		driver.get(BaseURL);
		logger.debug("Navigated to URL");
		
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
