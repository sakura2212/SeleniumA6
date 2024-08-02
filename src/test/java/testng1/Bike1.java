package testng1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Bike1 {

	@Test
	public void yamaha() throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver =new ChromeDriver() ;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.yamaha-motor-india.com/");
		Thread.sleep(2000) ;
		driver.close();

	}

}
