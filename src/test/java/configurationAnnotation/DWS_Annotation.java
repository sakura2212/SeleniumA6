package configurationAnnotation;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import baseClass.BaseClass_DWS;


public class DWS_Annotation extends BaseClass_DWS{
	@Test
	public void DWSFooter() throws InterruptedException
	{
		 Actions act =new Actions(driver);
		 act.keyDown(Keys.PAGE_DOWN).build().perform();
		 act.keyDown(Keys.PAGE_DOWN).build().perform();
		 List<WebElement> follow = driver.findElements(By.xpath("//div[@class='column follow-us']/ul/li/a"));
		 String rssUrl = "https://demowebshop.tricentis.com/news/rss/1";
		 
		 for (WebElement web : follow) {
			 //Thread.sleep(2000);
	 		
	 			String url = driver.getCurrentUrl();
	 			if(rssUrl.equals(url))
	 			{
	 			  driver.navigate().back();
	 			  Thread.sleep(2000);
	 			}
	 			web.click();
		}
		 
		
	}

}
