package dwsPom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DWSRegister {
	
	@Test
	public void register() throws InterruptedException  {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.navigate().to("https://demowebshop.tricentis.com/");
		
		DWS_Register ref = new DWS_Register(driver);
		ref.register_link();
		Thread.sleep(2000);
		ref.gender();
		ref.firstname("Varsha");
		ref.lastName("Yadav");
		ref.email("vaari503@gmail.com");
		Thread.sleep(2000);
		ref.password("Vaari@503");
		ref.confirm_password("Vaari@503");
		Thread.sleep(2000);
		ref.register_button();
		Thread.sleep(2000);
		driver.close();
	}

}
