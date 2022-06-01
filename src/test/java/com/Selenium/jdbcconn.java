package com.Selenium;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pageObjects.LoginElements;

public class jdbcconn extends base {
	public WebDriver driver;
	
	

	
	@Test
	public void retrieve() throws SQLException, IOException, Exception
	{
		String host = "localhost";
		String port = "3306";
		
	Connection con =	DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/seldb", "root","david");
	
	Statement st = con.createStatement();
	
	ResultSet rs = st.executeQuery("select * from Empinfo");
		
		//Thread.sleep(1000);
		while(rs.next())
		{
			driver = BrowserInt();
			Thread.sleep(1000);
			LoginElements le = new LoginElements(driver);
			le.login().click();
			Thread.sleep(1000);
		le.enterEmail().sendKeys(rs.getString("name"));
		le.enterPass().sendKeys(rs.getString("pass"));
		
		le.clickSubmit().click();
		driver.quit();
		}
	}
	
	
	
}
