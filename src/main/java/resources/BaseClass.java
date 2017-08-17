package resources;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public static WebDriver driver;
	public Properties prop;
	public WebDriver initializeBrowser() throws IOException
	{
	
		prop= new Properties();
		FileInputStream fis= new FileInputStream("/home/pace/Music/ReSelenium-Webdriver/Project/src/main/java/resources/data.properties");
		prop.load(fis);
		
		String browsername=prop.getProperty("browser");
		if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","/home/pace/Downloads/geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else if(browsername.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "/home/pace/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else
		{
			System.out.println("Not Defined");
		}
		
		driver.manage().window().maximize();
			
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	public void getTakescreenshot(String result) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/home/pace/Music/ReSelenium-Webdriver/Screenshot/"+result+"screen.png"));
		
	}
}
