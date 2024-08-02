package testng2;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShoesBrand5 {
	@Test
	public void Bata() throws InterruptedException
	{
		WebDriver driver =new ChromeDriver() ;
		driver.manage().window().maximize();
		driver.manage() .timeouts().implicitlyWait(Duration.ofSeconds(20)) ;
		driver.get("https://www.bata.com/in/");
		Thread.sleep(2000);
		driver.close();
			
	}

}
