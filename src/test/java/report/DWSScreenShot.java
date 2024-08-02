package report;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseDWS.BaseDWSScreenshot;
@Listeners(com.crm.listner.ScreenShotListner.class)
public class DWSScreenShot extends BaseDWSScreenshot {
	
	@Test
	
	public void dwsScreenshot()
	{
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.cssSelector("input[class='email']")).
		sendKeys("varshay@gmail.com");
		driver.findElement(By.cssSelector("input[class='password']")).
		sendKeys("varsha");
		
		driver.findElement(By.cssSelector("input[value='Log in']")).
		click();
		driver.findElement(By.xpath("//input[@id='pollanswers-1']")).click() ;
	}

}
