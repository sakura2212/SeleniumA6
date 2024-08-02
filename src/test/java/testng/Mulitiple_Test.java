package testng;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Mulitiple_Test {
	@Test
	public void agoda()
	{
		WebDriver driver =new ChromeDriver() ;
		driver.manage().window().maximize();
		driver.manage() .timeouts().implicitlyWait(Duration.ofSeconds(15)) ;
		driver.get("https://www.agoda.com/");
		driver.close();
			
	}
	
	@Test
	public void csk()
	{
		WebDriver driver =new ChromeDriver() ;
		driver.manage().window().maximize();
		driver.manage() .timeouts().implicitlyWait(Duration.ofSeconds(15)) ;
		driver.get("https://www.chennaisuperkings.com/");
		driver.close();
			
	}
	
	@Test
	public void Rcb()
	{
		WebDriver driver =new ChromeDriver() ;
		driver.manage().window().maximize();
		driver.manage() .timeouts().implicitlyWait(Duration.ofSeconds(15)) ;
		driver.get("https://www.royalchallengers.com/");
		driver.close();
			
	}

}
