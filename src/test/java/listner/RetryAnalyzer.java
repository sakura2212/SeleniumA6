package listner;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RetryAnalyzer {
	
	@Test(retryAnalyzer = com.crm.listner.RetryNetwork.class)
	public void demo()
	{
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		String expected ="https://demowebshop.tricentis.com" ;
		String actual = driver.getCurrentUrl();
		assertEquals(expected, actual);
		
		
	}
//if failes => will execute 4 times
//if passes => will execute 1 time
}
