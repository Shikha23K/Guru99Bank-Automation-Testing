package com.ImetBanking.testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.ImetBanking.pageObjects.*;
import com.ImetBanking.utilities.ExcelDataProv;

public class TC_AddCustomerTest_003 extends BaseClassForConfig {
	
	@Test(dataProvider="CustInfo")
	public void addCustomerTest(String arg[]) throws InterruptedException
	{
		
		logger.info("URL loaded");
		LoginPage lp=new LoginPage(driver);
		lp.setUId(username);
		lp.setPwd(password);
		lp.login();
		
		Thread.sleep(3000);
		CustomerPage cp=new CustomerPage(driver);
		cp.newCust();
		//driver.navigate().to("https://demo.guru99.com/V4/manager/Managerhomepage.php#google_vignette");
		
//		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
//		
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("/html/body/iframe[1]")));
//		driver.findElement(By.xpath("//*[@id=\"dismiss-button\"]")).click();
		driver.navigate().to("https://demo.guru99.com/V4/manager/addcustomerpage.php");
		Thread.sleep(5000);
		System.out.println(driver.getCurrentUrl());
		if(!arg[0].isEmpty())
		{
			cp.getName(arg[0]);
			cp.assertNameValidation();
		}
		
	//	cp.getDOB(arg[2],arg[3],arg[4]);
		
		if(!arg[5].isEmpty())
		{
			cp.getAddress(arg[5]);
			cp.assertAddressValidation();
		}
		
		if(!arg[6].isEmpty())
		{
			cp.getCity(arg[6]);
			cp.assertCityValidation();
		}
		
		if(!arg[7].isEmpty())
		{
			cp.getState(arg[7]);
			cp.assertStateValidation();
		}
		if(!arg[8].isEmpty())
		{
			cp.getPin(arg[8]);
			cp.assertPINValidation();
		}
		if(!arg[9].isEmpty())
		{
			cp.getMobile(arg[9]);
			cp.assertMobValidation();
		}
		if(!arg[10].isEmpty())
		{
			cp.getEmail(arg[10]);
			cp.assertEmailValidation();
		}
		if(!arg[11].isEmpty())
		{
			cp.getPwd(arg[11]);
			cp.assertPwdValidation();
		}
		
		cp.Submit();
		
		Thread.sleep(4000);
		
		if(isAlertPresent()==true)//means login was not successful
		{
			
			driver.switchTo().alert().accept();
			driver.navigate().to(BaseURL);
			//driver.switchTo().parentFrame();
			//driver.switchTo().frame(0);
			Assert.assertTrue(false);//login failed
			logger.info("Login Failed");
			logger.warn("Login Failed");
		
		}
		else
		{
			Assert.assertTrue(true);
			lp.logoutM();
			
			Thread.sleep(4000);
			
			driver.switchTo().alert().accept();
			driver.navigate().to(BaseURL);
			//driver.switchTo().frame(0);
//			driver.switchTo().parentFrame();
			logger.info("Login Successfully");
		}

	}	
		public boolean isAlertPresent()
		{
			try {
				driver.switchTo().alert();
				return true;
			}
			catch(NoAlertPresentException e)
			{
				return false;
			}
		}
		
	
	
	@DataProvider(name="CustInfo")
	String[][] getData() throws IOException
	{
		String path="D:/corizo/software testing/AutomationBankProject/src/test/java/com/ImetBanking/testData/newCustomerData.xlsx";
		int rNum=ExcelDataProv.getRowCount(path,"Sheet1");
		System.out.println(rNum);
		int cNum=ExcelDataProv.getCellCount(path, "Sheet1", 1);
		System.out.println(cNum);
		String CInfo[][]=new String[rNum][cNum];
		for(int i=1;i<=rNum;i++)
			for(int j=0;j<cNum;j++)
				CInfo[i-1][j]=ExcelDataProv.getCellData(path, "Sheet1", i, j);
			
		
		return CInfo;
	}
	
	
	

}
