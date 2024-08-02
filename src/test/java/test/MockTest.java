package test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MockTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://todomvc.com/");
		//String tab = Keys.chord(Keys.CONTROL,Keys.ENTER) ;
		 WebElement angular = driver.findElement(By.xpath("//span[text()='Angular']"));
		 
		 Actions act =new Actions(driver);
		// act.moveToElement(angular).keyDown(Keys.CONTROL).keyDown(Keys.ENTER).perform();
		//act.contextClick(angular).build().perform();
		 //act.keyDown(angular, Keys.TAB);
		 //act.keyDown(Keys.TAB).perform();
		 act.keyDown(Keys.CONTROL).click(angular).build().perform();
		 
		 Robot robot = new Robot();
		 

		 Thread.sleep(2000);

		 JavascriptExecutor js =(JavascriptExecutor) driver;
		 Set<String> ids = driver.getWindowHandles();
		 
		 for (String str : ids) {
			 String url = driver.switchTo().window(str).getCurrentUrl();
			 String todo_URl = "https://todomvc.com/examples/angular/dist/browser/#/all";
			Thread.sleep(2000);
			 if(url.equals(todo_URl))
			 {
				 WebElement text = driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']"));
				 Thread.sleep(2000);
				  js.executeScript("arguments[0].value='Reading';", text) ;
				  Thread.sleep(2000);
				  act.keyDown(Keys.SPACE).perform();
				  Thread.sleep(2000);			  
				  robot.keyPress(KeyEvent.VK_ENTER) ;
				  robot.keyRelease(KeyEvent.VK_ENTER);
				  Thread.sleep(2000);
				  
				  js.executeScript("arguments[0].value='Singing';", text) ;
				  Thread.sleep(2000);
				  act.keyDown(Keys.SPACE).perform();
				  Thread.sleep(2000);
				 // act.keyDown(Keys.ENTER).perform();
				  
				  robot.keyPress(KeyEvent.VK_ENTER) ;
				  robot.keyRelease(KeyEvent.VK_ENTER);
				  
				  driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
				  Thread.sleep(2000);
				 WebElement logo = driver.findElement(By.xpath("//li[@class='completed']"));
				if (logo.isDisplayed()) {
					System.out.println("You have completed the task");
				}
			 }
		}
		
		
		
	}

}
