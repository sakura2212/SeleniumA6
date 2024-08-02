package shopperDDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Shopper_Register {
	public static ArrayList<String> readData_Excel() throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\Desktop\\Automation\\TestData\\shopper.xlsx");
		Workbook wb = WorkbookFactory.create(fis) ;
		
		 Sheet sheetName = wb.getSheet("Sheet1") ;
		int row = sheetName.getPhysicalNumberOfRows();
		 ArrayList<String> arr =new ArrayList<String>();
		 for ( int i = 0; i < row; i++) {
			 arr.add( sheetName.getRow(i).getCell(0).toString());
			 
		}
		return arr;
	}

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.shoppersstack.com/");
		
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(30)) ;
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginBtn")));	
		driver.findElement(By.id("loginBtn")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Create Account']")));
		driver.findElement(By.xpath("//span[text()='Create Account']")).click();
		
		ArrayList<String> data = readData_Excel();
		
		List<WebElement> text = driver.findElements(By.xpath("//form[@class='signup_signupForm__zYAG9']/div/div/div/input"));

		int i=0; 
		for (WebElement web : text) {
			web.sendKeys(data.get(i++));
			Thread.sleep(2000);	
			
		}
		driver.findElement(By.id("Female")).click();
		Thread.sleep(2000);	
		
		driver.findElement(By.xpath("//input[@id='Terms and Conditions']")).click();
		Thread.sleep(2000);	
		
		driver.findElement(By.xpath("//button[text()='Register']")).click();
		
	}

}
