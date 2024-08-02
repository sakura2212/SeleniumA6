package dwsPom;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DWSDigiDownloads {
	
	@Test
	public void Downloads() throws InterruptedException
	{
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demowebshop.tricentis.com/");
		
		DWS_DigitalDownload ref =new DWS_DigitalDownload(driver);
		ref.getDigiDownload();
		Thread.sleep(2000);
		ref.getSortby();
		Thread.sleep(2000);
		ref.getDisplay();
		Thread.sleep(2000);
		ref.getView();
		Thread.sleep(2000);
		
		List<WebElement> add = ref.getAddToCart();
		for (WebElement web: add) {
			web.click();
			Thread.sleep(2000);
			
		}
		
		driver.findElement(By.className("ico-cart")).click();
		
		WebElement product = driver.findElement(By.xpath("//tr[@class='cart-item-row']"));
//		if(product.isDisplayed())
//		{
//			System.out.println("Products are added to the cart");
//		}
//		else {
//			System.out.println("Not added to the cart");
//		}
		
		assertEquals(product.isDisplayed(),true);
		
		
	}

}
