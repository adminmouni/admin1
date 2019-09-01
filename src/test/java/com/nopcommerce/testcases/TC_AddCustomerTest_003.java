package com.nopcommerce.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddcustomerPage;
import com.nopcommerce.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{
	@Test
	public void addNewCustomer() throws IOException, InterruptedException
	{
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("URL opened");
		
		LoginPage lp = new LoginPage(driver);
		
		
		lp.setusername(UserName);
		logger.info("username provided");
		
		lp.setpassword(PassWord);
		logger.info("Password provided");
		
		lp.clickLogin();
		logger.info("Logged in");
		
		logger.info("providing customer details....");
		
		AddcustomerPage addcust = new AddcustomerPage(driver);
		
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
		addcust.clickOnAddnew();
		
		String email = randomestring()+"@gmail.com";
		addcust.setEmail(email);
		
		addcust.setPassword("test123");
		addcust.setFirstName("Mounika");
		addcust.setLastName("Bolisetty");
		addcust.setGender("Female");
		addcust.setDob("7/07/2018");
		Thread.sleep(2000);
		//addcust.setCompanyName("IBM");
		
		addcust.setCustomerRoles("Guests");
		
		//addcust.setManagerOfVendor("Vendor2");
		
		//addcust.setAdminComment("I Love KannaBangaram");
		
		addcust.clickOnSave();
		
		Thread.sleep(2000);
		logger.info("Validation Started");
		
		String msg = driver.findElement(By.tagName("body")).getText();
		
		if(msg.contains("The new customer has been added successfully"))
		{
			Assert.assertTrue(true);
			logger.info("Test Case Passed");
		}
		else
		{
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
			logger.info("Test Case Failed");
		}	
				
		
	}
	
	

}
