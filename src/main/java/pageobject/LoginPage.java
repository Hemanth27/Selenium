package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	
	By email=By.cssSelector("input[id='user_email']");
	By pwd=By.cssSelector("input[id='user_password']");
	By signinbtn=By.cssSelector("input[type='submit']");
	By forgotpwd=By.xpath(".//*[contains(text(),'Forgot Password?')]");
	By createacc= By.xpath(".//*[contains(text(),'Create an Account')]");
	
	By invalidinput=By.xpath(".//*[@class='alert alert-danger']");
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(pwd);
	}
	
	public WebElement getsigninbtn()
	{
		return driver.findElement(signinbtn);
	}
	
	public WebElement getforgotpwd()
	{
		return driver.findElement(forgotpwd);
		
	}
	
	public WebElement getcreateacc()
	{
		return driver.findElement(createacc);
		
	}
	
	public WebElement geterrormessage(){
		return driver.findElement(invalidinput);
	}
}
