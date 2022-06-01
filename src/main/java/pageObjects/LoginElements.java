package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginElements {
	
	public static  Logger	log = LogManager.getLogger(LoginElements.class.getName());
	public  WebDriver driver;
	 
	 //date in private accessible to public methods--encapsulation
	private By title = By.xpath("//div[@class=\"pull-left\"]");
	
	private By loginclick = By.xpath("//a[@class='theme-btn register-btn']");
			
		
	@FindBy(id="email")
	 private WebElement email;
	
	@FindBy(id="password")
	private WebElement pass;
	
	@FindBy(xpath ="//input[@type=\"submit\"]")
	private WebElement submitbutton;
	
	
	
	public LoginElements(WebDriver driver) 
	{
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
		log.info("finding Web Elements");
	
	}
	public WebElement gettitle() 
	{
		return driver.findElement(title);
		
		
		
	}

	public WebElement login() 
	{
		return driver.findElement(loginclick);
		
	}
	public WebElement enterEmail() 
	{
		return email;
		
	}
	public WebElement enterPass() 
	{
		return pass;
		
	}
	public WebElement clickSubmit() 
	{
		return submitbutton;
		
	}
	
}
