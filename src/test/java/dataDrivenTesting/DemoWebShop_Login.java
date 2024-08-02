package dataDrivenTesting;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWebShop_Login {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
//		Properties prop=new Properties();
//		FileInputStream fis=new FileInputStream(".\\ConfigureFile\\LoginFunction.properties");
//		prop.load(fis);
//		String email=prop.getProperty("email");
//		String password=prop.getProperty("password");
		
		String email = DemoWebshopUtility.loginFunctionOperation("email");
		String password=DemoWebshopUtility.loginFunctionOperation("password");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.cssSelector("a[class='ico-login']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name='Email']")).sendKeys(email);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name='Password']")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
	

	}

}
