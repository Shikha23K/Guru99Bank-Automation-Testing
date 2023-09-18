package com.ImetBanking.utilities;

import java.io.*;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig()
	{
		File src=new File("D:/corizo/software testing/AutomationBankProject/Configuration/config.properties");
		try {
		FileInputStream f=new FileInputStream(src);
		pro=new Properties();
		pro.load(f);
		
		}
		catch(Exception e) {
			System.out.println("Exception is " +e.getMessage());
		}
	}
	
	public String getURL()
	{
		String url=pro.getProperty("BaseURL");
		return url;
	}
	public String userName()
	{
		String uname=pro.getProperty("username");
		return uname;
	}
	public String getPwd()
	{
		String p=pro.getProperty("password");
		return p;
	}
}
