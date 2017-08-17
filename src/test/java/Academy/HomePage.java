package Academy;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobject.LandingPage;
import pageobject.LoginPage;
import resources.BaseClass;

public class HomePage extends BaseClass {
	
	@BeforeTest
	public void basePagenavigation() throws IOException
	{
		String urlbrowser=prop.getProperty("url");
		driver=initializeBrowser();
		driver.get(urlbrowser);
	}
	
	@Test
	public void clickLoginbtn()
	{
		LandingPage lp= new LandingPage(driver);
		lp.getLogin().click();
	}
	
	@Test(dependsOnMethods={"clickLoginbtn"})
	public void loginElements()
	{
		LoginPage login= new LoginPage(driver);
		login.getEmail().sendKeys("");
		login.getPassword().sendKeys("");
		login.getsigninbtn().click();
		
	}

}
