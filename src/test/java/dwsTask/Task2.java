package dwsTask;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import taskBase.DWSTask_BaseClass;

public class Task2 extends DWSTask_BaseClass {
	

	@Test
	public void DwsLogin() throws IOException, InterruptedException
	{
		List<WebElement> poll = driver.findElements(By.xpath("//ul[@class='poll-options']/li/input"));
		for (WebElement web : poll) {
			web.click();
			Thread.sleep(2000);
			
		}
	}

}
