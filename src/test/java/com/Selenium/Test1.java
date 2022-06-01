package com.Selenium;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginElements;
import utilities.ReadXLSData;


public class Test1 extends base
{
	
public WebDriver driver;
	 public  Logger	log = LogManager.getLogger(base.class.getName());
	 
	@BeforeMethod
	public void pagetitle() throws IOException
	{
		driver = BrowserInt();
	
		//System.out.println(le.gettitle().getText());
	
		
	}
	
	@Test(dataProvider = "logindata")
	public void setup(String user,String pass) throws IOException, Exception 
	{
		
		LoginElements le = new LoginElements(driver);
		le.login().click();
		//Thread.sleep(1000);
		le.enterEmail().sendKeys(user);
		log.info(user + " Email Entered..");
		le.enterPass().sendKeys(pass);
		log.info(pass +" Password Entered..");
		le.clickSubmit().click();
		
		log.info("Submit Button clicked");
		
	
	}
	
	@DataProvider(name = "logindata")
	public String[][] getdata() throws IOException 
	{
		ReadXLSData xl = new ReadXLSData();
		return xl.getData("Sheet1");
	}
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	
}
