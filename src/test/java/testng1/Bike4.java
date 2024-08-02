package testng1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Bike4 {

	@Test(groups="smoke")
	public void yamaha() throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver =new ChromeDriver() ;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.jawamotorcycles.com/");
		Thread.sleep(2000) ;
		driver.close();

	}
}
