package dwsPom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DWSHomepage {
	@Test
	public void Homepage() throws InterruptedException
	{
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demowebshop.tricentis.com/");
		
		DWS_HomePage ref= new DWS_HomePage(driver) ;
		
		ref.getNewsletter("Welcome");
		Thread.sleep(2000);
		ref.getSearchTf("watch");
		Thread.sleep(2000);
		ref.getSearchButton();
		Thread.sleep(2000);
		driver.navigate().back();
		
		List<WebElement> poll = ref.getPoll();
		for (WebElement web : poll) {
			web.click();
			Thread.sleep(2000);
			
		}
		
		List<WebElement> navBar = ref.getNavBar();
		for (WebElement web : navBar) {
			web.click();
			Thread.sleep(2000);
			driver.navigate().back();
			
		}
		
		
		
	}

}
