package report;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.crm.listner.MultipleTest.class)

public class ReportWithListners {
	
	@Test
	public void domino()
	{
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));		
		driver.get("https://pizzaonline.dominos.co.in/");
		Reporter.log("i'm hungry",true);
	}

	@Test(timeOut = 1000)
	public void rcb() throws InterruptedException
	{
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));		
		driver.get("https://www.royalchallengers.com/");
		Reporter.log("i'm hungry for win",true);
		Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods = "rcb")
	public void csk()
	{
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));		
		driver.get("https://www.chennaisuperkings.com/");
		Reporter.log("Thala rock",true);
	}

}
