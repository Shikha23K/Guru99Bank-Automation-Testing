package com.ImetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.*;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	

	@FindBy(how=How.NAME,using="uid")
	@CacheLookup
	WebElement userID;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement pwd;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement login;
	
	@FindBy(name="btnReset")
	@CacheLookup
	WebElement reset;
	
	@FindBy(xpath="//html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement logout;
	
	public void setUId(String u)
	{
		userID.sendKeys(u);
	}

	public void setPwd(String u)
	{
		pwd.sendKeys(u);
	}
	public void login()
	{
		login.click();
	}

	public void reset()
	{
		reset.click();
	}
	public void logoutM()
	{
		logout.click();
	}
}
