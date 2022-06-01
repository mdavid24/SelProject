package com.Selenium;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginElements;


public class validateTitle extends base {
	
	public WebDriver driver;
	public static  Logger	log = LogManager.getLogger(validateTitle.class.getName());
	@BeforeTest
	public void Initialize() throws IOException
	{
		driver = BrowserInt();
			
		
		
		
	}
	@Test
	public void basepagetitle()	
	{
		LoginElements le = new LoginElements(driver);
		//System.out.println(le.gettitle().getText());
		String Actualtitle = le.gettitle().getText();
		Assert.assertEquals(Actualtitle, "Featured Courses");
		log.info("Succesfully validated title :"+Actualtitle);
		
	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
}
