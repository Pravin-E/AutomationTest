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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	public Properties p;
	public WebDriver driver;

	public WebDriver initializeBrowser() throws IOException {

		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		p = new Properties();
		p.load(fis);
//		String browserName = p.getProperty("browser");
		
		//to pass browser parameter through maven command we can use system.getproperty
		// mvn test -Dbrowser = chrome
		
		String browserName = System.getProperty("browser");
		
		System.out.println(browserName);

		
		
		/*
		 * switch(browserName){ case1:
		 * 
		 * }
		 */

		if (browserName.contains("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"\\src\\main\\java\\resources\\driver\\chromedriver.exe");
			ChromeOptions co = new ChromeOptions();
			
			if(browserName.contains("chromeheadless"))
			{
				co.addArguments("--headless");
			}
			driver = new ChromeDriver(co);

		}

		else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir")+"\\src\\main\\java\\resources\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();

		}

		else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir")+"\\src\\main\\java\\resources\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return driver;

	}
	
	public  String getScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String des = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(des));
		
		return des;
	}
	
	

}
