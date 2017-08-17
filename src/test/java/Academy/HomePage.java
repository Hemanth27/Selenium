package Academy;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;


import pageobject.LandingPage;
import pageobject.LoginPage;
import resources.BaseClass;

public class HomePage extends BaseClass {
	public static Logger log=LogManager.getLogger(BaseClass.class.getName());
	
	@BeforeTest
	public void basePagenavigation() throws IOException
	{
		Properties prop= new Properties();
		FileInputStream fip=new FileInputStream("/home/pace/Music/ReSelenium-Webdriver/Project/src/main/java/resources/data.properties");
		prop.load(fip);
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
	
	@Test(dataProvider="getdata")
	public void loginElements(String username,String password,String text)
	{
		
		LoginPage login= new LoginPage(driver);
		
		login.getEmail().sendKeys(username);
		
		login.getPassword().sendKeys(password);
		log.info(text);
		login.getsigninbtn().click();
	}
	// For invalid input in login
	@Test(enabled=false)
	public void invaliddata()
	{
		String expected="Invalid email or password";
		LoginPage log=new LoginPage(driver);
		String error=log.geterrormessage().getText();
		
		if(error.equalsIgnoreCase(expected))
		{
			System.out.println("True");
			log.getcreateacc().click();
		}
		else{
			System.out.println("No error message : Test failed");
		}
	}

	@DataProvider
	public  Object[][]  getdata()
	{
		Object[][] data= new Object[1][3];
		data[0][0]="hemanth.sks@gmail.com";
		data[0][1]="Test123@";
		data[0][2]="Valid user";
		return data;

}
	@AfterTest
	public void closebrowser()
	{
		//System.out.println("Closing the Browser");
		driver.close();
		driver=null;
	}

}
