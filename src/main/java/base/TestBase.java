package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import utility.ReadData;
import utility.Screenshot;
public class TestBase {

	
	
public static WebDriver driver;
	
	public void initialization() throws InterruptedException, IOException
	{
		//reading data from property file
		String browser = ReadData.readPropertyFile("Browser");
		
		if(browser.equalsIgnoreCase("Chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Safari")) {
			driver=new SafariDriver();
		}
		if(browser.equalsIgnoreCase("Edge")) {
			driver=new EdgeDriver();
		}
		if(browser.equalsIgnoreCase("Firefox")) {
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(ReadData.readPropertyFile("Url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
	}
	
}
