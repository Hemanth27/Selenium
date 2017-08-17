package Academy;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageobject.LandingPage;
import resources.BaseClass;

public class Validations extends BaseClass {
	
	public static Logger log=LogManager.getLogger(BaseClass.class.getName());
	@BeforeTest
	public void basePagenavigation() throws IOException
	{
		Properties prop= new Properties();
		FileInputStream fip=new FileInputStream("/home/pace/Music/ReSelenium-Webdriver/Project/src/main/java/resources/data.properties");
		prop.load(fip);
		String urlbrowser=prop.getProperty("url");
		driver=initializeBrowser();
		log.info("Driver is Initialized");
		driver.get(urlbrowser);
		log.info("Navigated to Home Page");
	}
	
	@Test
	public void validate()
	{
		LandingPage page= new LandingPage(driver);
		//page.getLogin().click();
		
		AssertJUnit.assertEquals(page.getTitle().getText(), "FEATURED Courses"); //FEATURED COURSES
		log.info("Validated the title");
		AssertJUnit.assertTrue(page.getnavTitle().isDisplayed());
		log.info("Navigation is Displayed");
	}
	
	@AfterTest
	public void closebrowser()
	{
		//System.out.println("Closing the Browser");
		driver.close();
		driver=null;
	}

}
