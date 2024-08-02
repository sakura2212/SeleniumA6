package assertions;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Dws_SoftAssert {
	@Test
	public void Dws() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com");
		
		String expected_Url = "https://demowebshop.tricentis.com/";
		String actual_Url = driver.getCurrentUrl();
		
		SoftAssert soft =new SoftAssert();
		//assertEquals(expected_Url, actual_Url) ; 
		//if return true, control will go to next line
		
		//assertNotEquals(expected_Url, actual_Url) ;
		//if return true, control will go to next line
		//if return false, control will go to next line
		
		//assertNotEquals(expected_Url, actual_Url,"Url matched") ;
		soft.assertNotEquals(expected_Url, actual_Url,"Url is not matched") ;
		Reporter.log("Welcome in DWs Homepage",true) ;
		WebElement searchTf = driver.findElement(By.id("small-searchterms")) ;
		searchTf.sendKeys("Mobile",Keys.ENTER); //in selenium 4 => we can write Enter inside sendkeys
	
		WebElement advSearch = driver.findElement(By.id("As")) ;
		//advSearch.click();
		soft.assertTrue(advSearch.isSelected());
		soft.assertAll();
		
		WebElement autoSearch = driver.findElement(By.id("Isc")) ;
		autoSearch.click();
		//assertTrue(autoSearch.isSelected());
		//assertFalse(autoSearch.isSelected()); //true
	
	}
	

}
