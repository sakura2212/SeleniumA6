package dataDrivenTesting;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM_Login {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String username = OrangeHRM_Utility.OrangeHrm("Username");
		String password = OrangeHRM_Utility.OrangeHrm("Password");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//username
		//driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		

	}

}
