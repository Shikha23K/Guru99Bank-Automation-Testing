package com.ImetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.*;

import com.ImetBanking.pageObjects.LoginPage;
import com.ImetBanking.utilities.ExcelDataProv;

public class TC_Login_DDT_002 extends BaseClassForConfig{
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String uname,String pwd) throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUId(uname);
		logger.info("username provided");
		lp.setPwd(pwd);
		logger.info("Password provided");
		lp.login();
		
		Thread.sleep(4000);
		
		if(isAlertPresent()==true)//means login was not successful
		{
			
			driver.switchTo().alert().accept();
			captureScreen(driver,"loginDDT");
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
	
	//whether alert window is presnt or not
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
	
	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path="D:/corizo/software testing/AutomationBankProject/src/test/java/com/ImetBanking/testData/loginData.xlsx";
		int rNum=ExcelDataProv.getRowCount(path,"ss");
		int cNum=ExcelDataProv.getCellCount(path, "ss",1);
		String loginData[][]=new String[rNum][cNum];
		for(int i=1;i<=rNum;i++)
			for(int j=0;j<cNum;j++)
				{
				loginData[i-1][j]=ExcelDataProv.getCellData(path, "ss", i, j);
			
				}
		
		
		return loginData;
					
	}
	

}
