package com.nopcommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{

	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="Email")
	WebElement txtEmail;
	
	@FindBy(id="Password")
	WebElement txtPassword;
	
	@FindBy(xpath="/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/input")
	WebElement btnLogin;
	
	@FindBy(xpath="/html/body/div[3]/div[1]/div/div/ul/li[3]/a")
	WebElement lnklogout;
	
	public void setusername(String uname )
	{
		txtEmail.sendKeys(uname);
	}
	
	public void setpassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	public void clickLogout()
	{
		lnklogout.click();
	}
}
