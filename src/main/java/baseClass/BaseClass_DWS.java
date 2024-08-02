package baseClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass_DWS {
	public WebDriver driver;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void preCondition(String browser,String url)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
	       driver =new ChromeDriver() ;
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			 driver =new EdgeDriver() ;
		}
		else {
			driver =new FirefoxDriver() ;
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)) ;
		driver.get(url); 
	}
	@BeforeMethod
	public void login()
	{
		driver.findElement(By.className("ico-login")).click();
		driver.findElement(By.cssSelector("input[class='email']")).
		sendKeys("varshay@gmail.com");
		driver.findElement(By.cssSelector("input[class='password']")).
		sendKeys("varshay123");
		driver.findElement(By.cssSelector("input[id ='RememberMe']")).click();
		//input[value='Log in']
		driver.findElement(By.cssSelector("input[value='Log in']")).
		click();
	}
	@AfterMethod
	public void logout()
	{
		driver.findElement(By.className("ico-logout")).click();
	}
	@AfterClass
	public void postCondition()
	{
		driver.quit();
	}

}
