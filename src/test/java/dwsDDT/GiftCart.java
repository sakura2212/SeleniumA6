package dwsDDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GiftCart extends DwsBase {
//	static String rName;
//	static String rEmail;
//	static String yName;
//	static String yEmai;
//	static String message;
//	static String count;
//	
//	public static void readData_Excel() throws EncryptedDocumentException, IOException
//	{
//		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\Desktop\\Automation\\TestData\\GiftCartTestCase.xlsx");
//		Workbook wb = WorkbookFactory.create(fis) ;
//		
//		 Sheet sheetName = wb.getSheet("Sheet1") ;
//		 rName=sheetName.getRow(0).getCell(0).toString();
//		 rEmail=sheetName.getRow(1).getCell(0).toString();
//		 yName = sheetName.getRow(2).getCell(0).toString();
//		 yEmai =sheetName.getRow(3).getCell(0).toString();
//		 message=sheetName.getRow(4).getCell(0).toString();
//		 count=sheetName.getRow(5).getCell(0).toString();
//	}
	
	public static ArrayList<String> readData_Excel2() throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\Desktop\\Automation\\TestData\\GiftCartTestCase.xlsx");
		Workbook wb = WorkbookFactory.create(fis) ;
		
		 Sheet sheetName = wb.getSheet("Sheet1") ;
		 ArrayList<String> arr =new ArrayList<String>();
		 for (int i = 0; i < 6; i++) {
			 arr.add( sheetName.getRow(i).getCell(0).toString());
			 
		}
		return arr;
	}
	

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		preCondition();
		Thread.sleep(2000);
		login();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
		
		
		
		//after clicking on gift cart rea data from arraylist
		
		ArrayList<String> data = readData_Excel2();
		//sendkeys(data.get(0))  => get(index) method
		Thread.sleep(2000);
		
		driver.findElement(By.id("giftcard_2_RecipientName")).sendKeys(data.get(0));
		Thread.sleep(2000);
		
		driver.findElement(By.id("giftcard_2_RecipientEmail")).sendKeys(data.get(1));
		Thread.sleep(2000);
		
		 WebElement sender_name = driver.findElement(By.id("giftcard_2_SenderName"));
		 sender_name.clear();
		 Thread.sleep(2000);
		 sender_name.sendKeys(data.get(2)) ;
		 Thread.sleep(2000);
		 
		WebElement sender_email = driver.findElement(By.id("giftcard_2_SenderEmail"));
		sender_email.clear();
		Thread.sleep(2000);
		sender_email.sendKeys(data.get(3));
		Thread.sleep(2000);
		
		driver.findElement(By.id("giftcard_2_Message")).sendKeys(data.get(4));
		Thread.sleep(2000);
		
		String ct = data.get(5);
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
		WebElement gift = driver.findElement(By.linkText("$25 Virtual Gift Card"));
		
		if(gift.isDisplayed())
		{
			System.out.println("Gift is added to the cart succesfully");
		}
		else
		{
			System.out.println("Gift is not added to the cart");
		}
		
		
	}

}
