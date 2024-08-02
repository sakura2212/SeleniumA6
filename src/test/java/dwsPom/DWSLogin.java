package dwsPom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class DWSLogin {
	
	@Test
	public void Login()
	{
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demowebshop.tricentis.com/");
		
		DWS_Login ref =new DWS_Login(driver);
//		ref.login_link.click();
//		ref.username.sendKeys("varshay@gmail.com");
//		ref.password.sendKeys("varshay123");
//		ref.login_button.click();
		
		ref.login_link();
		ref.username("varshay@gmail.com");
		ref.password("varshay123");
		ref.login_button();
	}

}
