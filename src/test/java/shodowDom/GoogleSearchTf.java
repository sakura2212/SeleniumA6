package shodowDom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleSearchTf {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions opt =new ChromeOptions();
		opt.addArguments("disable-notifications");
		
		WebDriver driver =new ChromeDriver(opt) ;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.google.com/");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@aria-label='Sign in']")).click();
		
		driver.findElement(By.cssSelector("input[type='email']")).
		sendKeys("varshay2212@gmail.com");
		
		Thread.sleep(3000);
		driver.findElement(By.id("identifierNext")).click();
		//driver.findElement(By.cssSelector("(//button[@type=\"button\"])[3]")).click();
		

	}

}
