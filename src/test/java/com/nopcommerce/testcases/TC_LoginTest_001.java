package com.nopcommerce.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.utilities.XLUtils;


public class TC_LoginTest_001 extends BaseClass
{
	

@Test
public void LoginTest() throws InterruptedException, IOException
{
	driver.get(baseURL);
	logger.info("URL opened");
	
	LoginPage lp = new LoginPage(driver);
	
	
	lp.setusername(UserName);
	logger.info("username provided");
	
	lp.setpassword(PassWord);
	logger.info("Password provided");
	
	lp.clickLogin();
	logger.info("Logged in");
	
	Thread.sleep(3000);
	System.out.println(driver.getTitle());
	if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
	{
		Thread.sleep(3000);
		lp.clickLogout();
		logger.info("Logged out");
		Assert.assertTrue(true);
	}
	else
	{
		captureScreen(driver,"LoginTest");
		logger.info("Login Failed");
		Assert.assertTrue(false);
	}
}
     
}
