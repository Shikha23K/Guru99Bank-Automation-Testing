package com.ImetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ImetBanking.pageObjects.*;

public class TC_LoginTest_001 extends BaseClassForConfig{

	@Test
	public void loginTest() throws IOException
	{
		driver.get(BaseURL);
		logger.info("URL is Opened");
		LoginPage lp=new LoginPage(driver);
		lp.setUId(username);
		logger.info("username Entered");
		
		lp.setPwd(password);
		logger.info("Password entered");
		
		lp.login();
		logger.info("login button clicked");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
			{
			Assert.assertTrue(true);
			logger.info("Test passed");
			}
		else
			{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Test failed");
			}
	}
	 
	
}