package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	public WebDriver driver;
	
	By signin =By.cssSelector("a[href='http://qaclickacademy.usefedora.com/sign_in']"); 
	
	public LandingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}

}
