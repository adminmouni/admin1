package com.nopcommerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{

	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/Config.properties");
		try
		{
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}catch(Exception e)
		{
			System.out.println("Exception is e"+e.getMessage());
		}
	}
	
	public String getApplicationurl()
	{
		String URL = pro.getProperty("url");
		return URL;
	}
	public String getUsername()
	{
		String Username = pro.getProperty("username");
		return Username;
	}
	public String getPassword()
	{
		String Password = pro.getProperty("password");
		return Password;
	}
	public String getChromePath()
	{
		String ChromePath = pro.getProperty("chromePath");
		return ChromePath;
	}
	public String getFireFoxPath()
	{
		String FireFoxPath = pro.getProperty("firefoxPath");
		return FireFoxPath;
	}
	public String getIEPath()
	{
		String IEpath = pro.getProperty("IEPath");
		return IEpath;
	}
}
