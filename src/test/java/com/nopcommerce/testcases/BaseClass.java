package com.nopcommerce.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopcommerce.utilities.ReadConfig;

public class BaseClass 
{
	ReadConfig RC = new ReadConfig();
	public String baseURL = RC.getApplicationurl();
	public String UserName = RC.getUsername();
	public String PassWord = RC.getPassword();
	
	public WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
		public void setup(String br)
	{
		
		logger = Logger.getLogger("nopCommerceV2");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",RC.getChromePath());
		driver=new ChromeDriver();
		}
		
		else if(br.equals("firefox"))
		{
		System.setProperty("webdriver.gecko.driver",RC.getFireFoxPath());
		driver=new FirefoxDriver();
		}
		
		
		else if(br.equals("IE"))
		{
		System.setProperty("webdriver.ie.driver",RC.getIEPath());
		driver=new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/ScreenShots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.print("Screenshot taken");
	}
	public static String randomestring()
	{
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return(generatedString1);
	}
	public static String randomeNum()
	{
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return(generatedString2);
	}
}
