package dwsDDT;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DwsBase {

	public static WebDriver driver;
	
	public static void preCondition() throws IOException
	{
		String browser = JavaUtility.login("browser") ;
		String url=JavaUtility.login("url");
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
	}
	public static void login() throws IOException, InterruptedException
	{
		String email = JavaUtility.login("email");
		String password = JavaUtility.login("password");
		driver.findElement(By.cssSelector("a[class='ico-login']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name='Email']")).sendKeys(email);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name='Password']")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}
	public static void logout()
	{
		driver.findElement(By.cssSelector("a[class='ico-logout']")).click();
		driver.quit();
	}
}
