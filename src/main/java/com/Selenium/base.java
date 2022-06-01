package com.Selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	public static  Logger	log = LogManager.getLogger(base.class.getName());
	public  static WebDriver driver;
	
	public WebDriver BrowserInt() throws IOException
	{
		String path = System.getProperty("user.dir")+"\\resources\\data.properties";
		
		Properties pr = new Properties();
		
		FileInputStream fi = new FileInputStream(path);
		
		pr.load(fi);
		
		
		
		//String br =System.getProperty("browser"); // from cmd: mvn test -Dbrowser=chrome
		
		String br = pr.getProperty("browser"); // from properties file
		String url = pr.getProperty("url");
		log.info( br + " Browser Strated ");
		//System.out.println(br);
		//System.out.println(url);
		
		
		if(br.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
			ChromeOptions choptions = new ChromeOptions();
			if(br.contains("headless"))
			{
			choptions.addArguments("--headless");
			}
			driver  = new ChromeDriver(choptions);
			
		}
		else if(br.equals("msedge"))
			{
			System.setProperty("webdriver.edge.driver", "resources/msedgedriver.exe");
			 driver  = new EdgeDriver();
			
			
		}
		else if(br.equals("firefox"))
		{
		System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
		
		
		 driver = new FirefoxDriver();
		
		
	}
		
		driver.get(url);
		
		log.info("Navigated to: "+url);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	return driver;
		
		
	}
	
	public String getScreenShotOnFail(String testcasename, WebDriver driver) throws IOException
	{
		
	TakesScreenshot	ts = (TakesScreenshot) driver;
	
	File source = ts.getScreenshotAs(OutputType.FILE);
	
	String destfile = System.getProperty("user.dir")+"//reports//"+testcasename+".png";
	
	FileUtils.copyFile(source,new File(destfile));
	
	return destfile;
	}
	
}
