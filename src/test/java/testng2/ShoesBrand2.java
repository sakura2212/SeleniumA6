package testng2;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShoesBrand2 {
	
		
		@Test
		public void Puma() throws InterruptedException
		{
			WebDriver driver =new ChromeDriver() ;
			driver.manage().window().maximize();
			driver.manage() .timeouts().implicitlyWait(Duration.ofSeconds(20)) ;
			driver.get("https://in.puma.com/in/en");
			Thread.sleep(2000);
			driver.close();
				
		}
		

	}

