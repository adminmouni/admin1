package com.nopcommerce.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.utilities.XLUtils;



public class TC_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider="LoginData")
	public void loginTest(String User, String pswd) throws InterruptedException, IOException
	{
		driver.get(baseURL);
		logger.info("URL opened");
		
		LoginPage lp = new LoginPage(driver);
		
		
		lp.setusername(User);
		logger.info("username provided");
		
		lp.setpassword(pswd);
		logger.info("Password provided");
		
		lp.clickLogin();
		logger.info("Logged in");
		
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		if(driver.getTitle().equals("nopCommerce demo store"))
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
	     
		
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/nopcommerce/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);
			}
		}
		
		return logindata;
		
	}
	

}
