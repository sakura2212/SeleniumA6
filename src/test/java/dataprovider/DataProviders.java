package dataprovider;

import java.io.File;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {
	
	@DataProvider(name="data")
	public Object[][] sender() throws EncryptedDocumentException, IOException
	{
//		workbook factory present in apache poi
		File path=new File("C:\\Users\\DELL\\Desktop\\Automation\\TestData\\LoginShopper.xlsx") ;
		FileInputStream fis =new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis) ;
		//		sheet obj is created
		Sheet sheet = wb.getSheet("Sheet1") ;
		int row = sheet.getPhysicalNumberOfRows();
		int col = sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][]obj=new Object[2][2];
		for(int i=0;i<row;i++)
			for(int j=0;j<col;j++)
			{
				obj[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		
		return obj;
	}
	
	
	@Test(dataProvider="data")
	public void receiver(String data1,String data2) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.shoppersstack.com/");
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(30)) ;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginBtn")));
		
	     driver.findElement(By.id("loginBtn")).click();
	     Thread.sleep(2000);
	     driver.findElement(By.id("Email")).sendKeys(data1);
	     Thread.sleep(2000);
	     driver.findElement(By.id("Password")).sendKeys(data2);
	     driver.findElement(By.xpath("//span[text()='Login']")).click();
		driver.close();
	}

}