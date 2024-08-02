package listner;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.crm.listner.Basic.class)

public class BasicTestCase {
	@Test
	public void Basic()
	{
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demowebshop.tricentis.com/");
		String actual = driver.getCurrentUrl();
		String expected = "https://demowebshop.tricentis.com/" ;
		
		assertEquals(expected, actual);
//		onStart
//		onTestStart
		//@Test Basic
//		onTestSuccess
//		onTestStart
		//@Test Basic1
//		onTestSuccess
//		onFinish
	}
	
	@Test
	public void Basic2()
	{
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demowebshop.tricentis.com/");
		String actual = driver.getCurrentUrl();
		String expected = "https://demowebshop.tricentis.com" ;
		
		assertEquals(expected, actual);
//		onStart
//		onTestStart
		//@Test Basic
//		onTestSuccess
//		onTestStart
		//@Test Basic1
//		onTestFailure
//		onFinish
	}


	
}
