package taskBase;

import java.io.IOException;
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

import BaseDWS.JavaUtility;
import dwsTaskPOM.Task1_DWSRegistered;
import dwsTaskPOM.Task2_DWSLogin;

public class DWSTask_BaseClass  {
	
	public  WebDriver driver;

	public Task1_DWSRegistered t1;
	 Task2_DWSLogin t2;

	
	
	@BeforeClass
	public void preCondition() throws IOException
	{
		//JavaUtility is a static method => called classname as ref
		String browser = JavaUtility.login("browser");
		String url = JavaUtility.login("url");
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
		t1= new Task1_DWSRegistered(driver) ;
		t2 =new Task2_DWSLogin(this.driver);
		
	}
	@BeforeMethod
	public void login()  throws IOException
	{
	
		String username = JavaUtility.login("email");
		String password = JavaUtility.login("password");
//		driver.findElement(By.className("ico-login")).click();
//		driver.findElement(By.cssSelector("input[class='email']")).
//		sendKeys(email);
//		driver.findElement(By.cssSelector("input[class='password']")).
//		sendKeys(password);
		t2.getLogin_link();
		t2.getUsername(username);
		t2.getPassword(password) ;
		driver.findElement(By.cssSelector("input[id ='RememberMe']")).click();
		t2.getLogin_button();
		//input[value='Log in']
//		driver.findElement(By.cssSelector("input[value='Log in']")).
//		click();
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
