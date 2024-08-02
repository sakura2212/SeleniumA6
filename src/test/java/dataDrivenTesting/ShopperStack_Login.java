package dataDrivenTesting;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopperStack_Login {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		String email = ShopperStack_Utility.LoginShopper("email");
		String password = ShopperStack_Utility.LoginShopper("password");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.shoppersstack.com/");
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(30)) ;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginBtn")));
		
	     driver.findElement(By.id("loginBtn")).click();
	     Thread.sleep(2000);
	     driver.findElement(By.id("Email")).sendKeys(email);
	     Thread.sleep(2000);
	     driver.findElement(By.id("Password")).sendKeys(password);
	     driver.findElement(By.xpath("//span[text()='Login']")).click();

	}

}
