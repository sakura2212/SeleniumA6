package report;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CreateDependency {
	//dependsOnMethod
	//skip status
	@Test(priority=1,timeOut=1000)
	public void createAccount() throws InterruptedException
	{
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Thread.sleep(2000);
		driver.get("https://www.redbus.in/");
		Reporter.log("Account created" ,true);
	}
	
	@Test(priority=0, dependsOnMethods = "createAccount")
	public void deleteAccoutn()
	{
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.redbus.in/");
		Reporter.log("Account created" ,true);
	}

	
}
