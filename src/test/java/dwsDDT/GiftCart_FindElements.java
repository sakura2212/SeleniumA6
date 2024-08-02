package dwsDDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GiftCart_FindElements extends DwsBase {

	public static ArrayList<String> readData_Excel2() throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\Desktop\\Automation\\TestData\\GiftCartTestCase.xlsx");
		Workbook wb = WorkbookFactory.create(fis) ;
		
		 Sheet sheetName = wb.getSheet("Sheet1") ;
		 ArrayList<String> arr =new ArrayList<String>();
		 for ( int i = 0; i < 6; i++) {
			 arr.add( sheetName.getRow(i).getCell(0).toString());
			 
		}
		return arr;
	}
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
	int i=0;	
		
		preCondition();
		Thread.sleep(2000);
		login();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
		
		ArrayList<String> data = readData_Excel2();
		Thread.sleep(2000);
		
		List<WebElement> gift = driver.findElements(By.xpath("//div[@class='giftcard']/div/input"));
		//int size = gift.size();
		Thread.sleep(4000);
		
		for (WebElement web : gift) {
	      web.clear();
		web.sendKeys(data.get(i++));
			Thread.sleep(2000);		
		}
		driver.findElement(By.id("giftcard_2_Message")).sendKeys(data.get(i++));
		Thread.sleep(2000);
		
		String ct = data.get(i++);
		double val = Double.parseDouble(ct);
		int a =(int)val;
		String quant= String.valueOf(a);
		
		WebElement qty = driver.findElement(By.id("addtocart_2_EnteredQuantity"));
		qty.clear();
		qty.sendKeys(quant);		
		Thread.sleep(2000);

		driver.findElement(By.id("add-to-cart-button-2")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Shopping cart")).click();
		Thread.sleep(2000);
		//verification
		WebElement gift1 = driver.findElement(By.linkText("$25 Virtual Gift Card"));
		
		if(gift1.isDisplayed())
		{
			System.out.println("Gift is added to the cart succesfully");
		}
		else
		{
			System.out.println("Gift is not added to the cart");
		}
		
		logout();
	}

}
