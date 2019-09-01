package com.nopcommerce.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddcustomerPage
{

	WebDriver ldriver;
	
	public AddcustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	By lnkCustomers_menu = By.xpath("/html/body/div[3]/div[2]/div/ul/li[4]/a");
	By lnkCustomer_menuitem = By.xpath("/html/body/div[3]/div[2]/div/ul/li[4]/ul/li[1]/a");
	
	By btnAddnew = By.xpath("/html/body/div[3]/div[3]/div/form[1]/div[1]/div/a");
	
	By txtEmail = By.xpath("//*[@id=\"Email\"]");
	By txtPassword = By.xpath("//*[@id=\"Password\"]");
	By txtFirstname = By.xpath("//*[@id=\"FirstName\"]");
	By txtLastname =By.xpath("//*[@id=\"LastName\"]");
	
	By rdMaleGender = By.xpath("//*[@id=\"Gender_Male\"]");
	By rdFemaleGender = By.xpath("//*[@id=\"Gender_Female\"]");
	
	By txtDob = By.xpath("//*[@id=\"DateOfBirth\"]");
	By txtCompanyName = By.xpath("//input[@id='Company']");
	
	
	By txtCustomerRoles = By.xpath("//*[@id=\"customer-info\"]/div[2]/div[1]/div[10]/div[2]/div/div[1]/div");
	By listitemAdministarators =By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[1]");
	By listitemRegistered = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[4]");
	By listitemGuests = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[3]");
	By listitemForumModerators = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[2]");
	By listitemVendors = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[5]");
	
	By txtmgrofVendor = By.xpath("//*[@id='VendorId']");
	
	
	
	By txtAdminComment = By.xpath("//textarea[@id='AdminComment']");
	By btnSaveandEdit = By.xpath("/html/body/div[3]/div[3]/div/form/div[1]/div/button[2]");
	
	
	public void clickOnCustomersMenu()
	{
		ldriver.findElement(lnkCustomers_menu).click();
	}
	
	public void clickOnCustomersMenuItem()
	{
		ldriver.findElement(lnkCustomer_menuitem).click();
	}
	
	public void clickOnAddnew()
	{
		ldriver.findElement(btnAddnew).click();
	}
	
	public void setEmail(String email)
	{
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	public void setPassword(String password)
	{
		ldriver.findElement(txtPassword).sendKeys(password);
	}
	public void setFirstName(String fname)
	{
		ldriver.findElement(txtFirstname).sendKeys(fname);
	}
	public void setLastName(String lname)
	{
		ldriver.findElement(txtLastname).sendKeys(lname);
	}
	
	public void setGender(String gender)
	{
		if(gender.equals("Male"))
		{
			ldriver.findElement(rdMaleGender).click();
		}
		else
		{
			ldriver.findElement(rdFemaleGender).click();
		}
	}
	public void setDob(String dob)
	{
		ldriver.findElement(txtDob).sendKeys(dob);
	}
	public void setCompanyName(String comname)
	{
		ldriver.findElement(txtCompanyName).click();
	}
	
	public void setCustomerRoles(String role)
	{
		ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();
		
		ldriver.findElement(txtCustomerRoles).click();
		
		WebElement listitem;
		
		switch(role)
		{
		case "Administrators":
			listitem = ldriver.findElement(listitemAdministarators);break;
		case "Forum Moderators":
			listitem = ldriver.findElement(listitemForumModerators);break;
		case "Registered":
			listitem = ldriver.findElement(listitemRegistered);break;
		case "Vendors":
			listitem = ldriver.findElement(listitemVendors);break;
		default:
			listitem = ldriver.findElement(listitemGuests);break;
		
		}
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();",listitem);
		
	}
	
	
	
	public void setManagerOfVendor(String value)
	{
	     Select drp = new Select(ldriver.findElement(txtmgrofVendor));
	     drp.selectByVisibleText(value);
	}
	public void setAdminComment(String content)
	{
		ldriver.findElement(txtAdminComment).sendKeys(content);
	}
	public void clickOnSave()
	{
		ldriver.findElement(btnSaveandEdit).click();
	}
}
