package com.ImetBanking.pageObjects;

import org.apache.poi.ss.formula.functions.DVar;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.testng.Assert;

import lombok.var;

public class CustomerPage {
	
	public WebDriver driver;
	public CustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(how=How.XPATH,using="//div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement newCustomer;
	
	
	@FindBy(xpath="//table/tbody/tr/td/table/tbody/tr[4]/td[2]/input[1]")
	@CacheLookup
	WebElement cName;
	
	@FindBy(xpath="//table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]")
	@CacheLookup
	WebElement gender;
		
	@FindBy(xpath="//table/tbody/tr/td/table/tbody/tr[6]/td[2]/input[1]")
	@CacheLookup
	WebElement dob;
	
	@FindBy(xpath="//table/tbody/tr/td/table/tbody/tr[7]/td[2]/textarea[1]")
	@CacheLookup
	WebElement adrs;
	
	@FindBy(xpath="//table/tbody/tr/td/table/tbody/tr[8]/td[2]/input[1]")
	@CacheLookup
	WebElement ct;
	
	@FindBy(xpath="//table/tbody/tr/td/table/tbody/tr[9]/td[2]/input[1]")
	@CacheLookup
	WebElement st;
	
	@FindBy(xpath="//table/tbody/tr/td/table/tbody/tr[10]/td[2]/input[1]")
	@CacheLookup
	WebElement pin;
	
	@FindBy(xpath="//table/tbody/tr/td/table/tbody/tr[11]/td[2]/input[1]")
	@CacheLookup
	WebElement mob;
	
	@FindBy(xpath="//table/tbody/tr/td/table/tbody/tr[12]/td[2]/input[1]")
	@CacheLookup
	WebElement email;
	
	@FindBy(xpath="//table/tbody/tr/td/table/tbody/tr[13]/td[2]/input[1]")
	@CacheLookup
	WebElement pwd;
	
	
	@FindBy(xpath="//table/tbody/tr/td/table/tbody/tr[14]/td[2]/input[1]")
	@CacheLookup
	WebElement sub;
	
	@FindBy(xpath="//table/tbody/tr/td/table/tbody/tr[14]/td[2]/input[2]")
	@CacheLookup
	WebElement res;
	
	@FindBy(xpath="//body/p/a")
	@CacheLookup
	WebElement home;
	

	
	public void newCust()
	{
		newCustomer.click();
	}
	public void getName(String n)
	{
		cName.sendKeys(n);
	}
	public void getGender(String cGender)
	{
		gender.click();
	}
	
	public void getDOB(String mm,String dd,String yy)
	{
		dob.sendKeys(mm);
		dob.sendKeys(dd);
		dob.sendKeys(yy);
	}
	public void getAddress(String a)
	{
		adrs.sendKeys(a);
	}
	public void getCity(String n)
	{
		ct.sendKeys(n);
	}
	public void getState(String n)
	{
		st.sendKeys(n);
	}
	public void getPin(String n)
	{
		pin.sendKeys(n);
	}
	
	public void getEmail(String n)
	{
		email.sendKeys(n);
	}
	public void getPwd(String n)
	{
		pwd.sendKeys(n);
	}
	
	
	
	public void getMobile(String n)
	{
		mob.sendKeys(n);
	}
	public void Submit()
	{
		sub.click();
		
	}
		
	public void assertNameValidation()
	{
		String actualError=getErrorMessage(cName);
		Assert.assertEquals("Numbers are not allowed",actualError);
				//"Special characters are not allowed""Customer name must not be blank")
	}
	public void assertAddressValidation()
	{
		String actualError=getErrorMessage(adrs);
		Assert.assertEquals("Address Field must not be blank",actualError);
				//"Special characters are not allowed""Customer name must not be blank")
	}
	
	public void assertCityValidation()
	{
		String actualError=getErrorMessage(ct);
		Assert.assertEquals("Numbers are not allowed",actualError);
				//"Special characters are not allowed""Customer name must not be blank")
	}
	public void assertStateValidation()
	{
		String actualError=getErrorMessage(st);
		Assert.assertEquals("Numbers are not allowed",actualError);
				//"Special characters are not allowed""Customer name must not be blank")
	}
	
	public void assertPINValidation()
	{
		String actualError=getErrorMessage(pin);
		Assert.assertEquals("Characters are not allowed",actualError);
				//"Special characters are not allowed""Customer name must not be blank")
	}
	public void assertMobValidation()
	{
		String actualError=getErrorMessage(mob);
		Assert.assertEquals("Characters are not allowed",actualError);
				//"Special characters are not allowed""Customer name must not be blank")
	}
	public void assertEmailValidation()
	{
		String actualError=getErrorMessage(email);
		Assert.assertEquals("Email-ID is not valid",actualError);
				//"Special characters are not allowed""Customer name must not be blank")
	}
	public void assertPwdValidation()
	{
		String actualError=getErrorMessage(pwd);
		Assert.assertEquals("Password must not be blank",actualError);
				//"Special characters are not allowed""Customer name must not be blank")
	}
	
	
	public String getErrorMessage(WebElement x) {
	return x.getText();
			
	}
}
