package report;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseDWS.DWSBaseListener;

@Listeners(com.crm.listner.MultipleTest.class)
public class DWSListnerTask extends DWSBaseListener {
	@Test
	public void GiftCart() throws InterruptedException
	{
		driver.findElement(By.partialLinkText("Gift Cards")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.id("giftcard_1_RecipientName")).sendKeys("Varsha");
		Thread.sleep(2000);
		
		driver.findElement(By.id("giftcard_1_RecipientEmail")).sendKeys("yadav23@gmail.com");
		Thread.sleep(2000);
		
		 WebElement sender_name = driver.findElement(By.id("giftcard_1_SenderName"));
		 sender_name.clear();
		 Thread.sleep(2000);
		 sender_name.sendKeys("Shrawani") ;
		 Thread.sleep(2000);
		 
		WebElement sender_email = driver.findElement(By.id("giftcard_1_SenderEmail"));
		sender_email.clear();
		Thread.sleep(2000);
		sender_email.sendKeys("Sharw12@gmail.com");
		Thread.sleep(2000);
		
		driver.findElement(By.id("giftcard_1_Message")).sendKeys("Congratulations!!");
		Thread.sleep(2000);
		
		
		String ct = "2";
		double val = Double.parseDouble(ct);
		int a =(int)val;
		String quant= String.valueOf(a);
		
		WebElement qty = driver.findElement(By.id("addtocart_1_EnteredQuantity"));
		qty.clear();
		qty.sendKeys(quant);
				
		Thread.sleep(2000);
		
		driver.findElement(By.id("add-to-cart-button-1")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Shopping cart")).click();
		//driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		Thread.sleep(2000);
		//verification
		//WebElement gift = driver.findElement(By.linkText("$25 Virtual Gift Card"));
		WebElement giftImg = driver.findElement(By.className("product-picture"));
		
		if(giftImg.isDisplayed())
		{
			System.out.println("Gift is added to the cart succesfully");
		}
		else
		{
			System.out.println("Gift is not added to the cart");
		}
		
	}
	@Test
	public void DigiDownload() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[contains(text(),'Digital downloads')]")).click();

		List<WebElement> add = driver.findElements(By.xpath("//input[@value='Add to cart']"));
		
		for (WebElement web : add) {
			web.click();
			Thread.sleep(2000);
		}
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		List<WebElement> products = driver.findElements(By.className("product-picture"));
	     for (WebElement webElement : products) {
	    	 if(webElement.isDisplayed())
	    	 {
	    		 System.out.println("Products are added to the cart");
	    	 }
	    	 else {
	    		 System.out.println("Products are not added to the cart");
	    	 }
			
		}
	}
	
	@Test
	public void AllLinks() throws InterruptedException
	{
		WebElement followus = driver.findElement(By.xpath("//h3[text()='Follow us']"));
		 String rssUrl = "https://demowebshop.tricentis.com/news/rss/1";
		Actions act =new Actions(driver) ;
		act.scrollToElement(followus) ;
		String home = driver.getWindowHandle();
		 List<WebElement> follow = driver.findElements(By.xpath("//div[@class='column follow-us']/ul/li/a"));
	
		 
		 for (WebElement web : follow) {
			 Thread.sleep(2000);
			 web.click();
			
			String url = driver.getCurrentUrl();
 			if(rssUrl.equals(url))
 			{
 			driver.navigate().back();
 			Thread.sleep(2000);
 			}
		}
		 driver.switchTo().window(home);
	}
	@Test
	public void Twitter() throws InterruptedException
	{
		WebElement twitt = driver.findElement(By.linkText("Twitter"));
		
		Actions act =new Actions(driver) ;
		
		act.keyDown(twitt, Keys.PAGE_DOWN).perform() ;
	    
	   String home = driver.getWindowHandle();
	   Set<String> ids = driver.getWindowHandles();
	   for (String str : ids) {
			  String current_url = driver.switchTo().window(str).getCurrentUrl();
			  String twPage = "https://x.com/nopCommerce";
			  
			  if(twPage.contains(current_url))
			  {
				 Thread.sleep(2000);
				  driver.findElement(By.xpath("//span[text()='Create account']")).click();
				  Thread.sleep(2000);
				  driver.findElement(By.name("name"))
			      .sendKeys("Varsha");		 
				  driver.findElement(By.name("phone_number"))
				  .sendKeys("8796451230");
				  
				  WebElement month = driver.findElement(By.cssSelector("select[id='SELECTOR_1']"));
				  Select ref1 =new Select(month);
				  ref1.selectByValue("12");
				  
				  WebElement day = driver.findElement(By.cssSelector("select[id='SELECTOR_2']"));
				  Select ref2 =new Select(day);
				  ref2.selectByValue("22");
				  
				  WebElement year = driver.findElement(By.cssSelector("select[id='SELECTOR_3']"));
				  Select ref3 =new Select(year);
				  Thread.sleep(2000);
				  ref3.selectByValue("2020");
				  
				  }				
				  
			  }
			  
	   driver.switchTo().window(home);
			  
		}
	
	
	@Test
	public void Facebook() throws InterruptedException
	{
		//JavascriptExecutor js= (JavascriptExecutor) driver;
		WebElement fb = driver.findElement(By.linkText("Facebook"));
		//js.executeScript("arguments[0].scrollIntoView(true);",fb) ;
		Actions act =new Actions(driver) ;
		
		act.keyDown(fb, Keys.PAGE_DOWN).perform() ;
	    
	   String home = driver.getWindowHandle();
	   Set<String> ids = driver.getWindowHandles();
	   
	   for (String str : ids) {
		  String current_url = driver.switchTo().window(str).getCurrentUrl();
		  String fbPage = "https://www.facebook.com/nopCommerce";
		  
		  if(fbPage.contains(current_url))
		  {
			 // Thread.sleep(2000);
			  driver.findElement(By.xpath("//span[text()='Create new account']")).click();
			  
			  Set<String> ids2 = driver.getWindowHandles();
			  for (String string : ids2) {
				 driver.switchTo().window(string);
				//String createAcc = "https://www.facebook.com/reg/?next=%2FnopCommerce";
				
			  }
			  Thread.sleep(2000);
			  driver.findElement(By.name("firstname"))
		      .sendKeys("Varsha");		 
			  driver.findElement(By.name("lastname"))
			  .sendKeys("Yadav");
			  
			  driver.findElement(By.name("reg_email__")).sendKeys("Vyd1122@gmail.com");
			  driver.findElement(By.name("reg_email_confirmation__")).sendKeys("Vyd1122@gmail.com");
			   driver.findElement(By.name("reg_passwd__")).sendKeys("Vyd@1122");
			   
			    Thread.sleep(2000);
				WebElement bday_DropDown = driver.findElement(By.name("birthday_day"));
			    Select ref=new Select(bday_DropDown);
				ref.selectByVisibleText("22");
				WebElement birthMonth = driver.findElement(By.id("month"));
			     Select ref2=new Select(birthMonth);
				ref2.selectByIndex(11);
				WebElement birthYear = driver.findElement(By.id("year"));
				Select ref3=new Select(birthYear);
				ref3.selectByValue("2003");
				
				Thread.sleep(2000);
				driver.findElement(By.xpath("//label[text()='Female']")).click();
				
				
				
			  
		  }
		  
		
		  
	}
	   driver.switchTo().window(home);
 
		
	}

}
