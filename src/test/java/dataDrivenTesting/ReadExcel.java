package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		// TODO Auto-generated method stub

		FileInputStream fis =new FileInputStream("C:\\Users\\DELL\\Desktop\\Automation\\TestData\\DWSLogin.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet("Sheet1");
		String username = sheetName.getRow(0).getCell(0).toString();
		String password = sheetName.getRow(0).getCell(1).toString();
		
		System.out.println(username);
		System.out.println(password);
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.cssSelector("a[class='ico-login']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name='Email']")).sendKeys(username);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name='Password']")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}

}
