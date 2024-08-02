package dwsTask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import taskBase.DWSTask_BaseClass;
import taskBase.Registered_ExcelUtility;

public class Task1 extends DWSTask_BaseClass {
	
	////div[@class='inputs']/input
	@Test
	public void registered() throws InterruptedException, EncryptedDocumentException, IOException {
		int i=0;
		ArrayList<String> data = Registered_ExcelUtility.ExcelUtility();
		
		List<WebElement> input = driver.findElements(By.xpath("//div[@class='inputs']/input"));
		for (WebElement web : input) {
			web.sendKeys(data.get(i++));
		}
//      t1.register_link();
//	Thread.sleep(2000);
//	 t1.gender();
//	 t1.firstname("Varsha");
//	 t1.lastName("Yadav");
//	 t1.email("vaari503@gmail.com");
//	Thread.sleep(2000);
//	 t1.password("Vaari@503");
//	 t1.confirm_password("Vaari@503");
//	Thread.sleep(2000);
//	 t1.register_button();
//	Thread.sleep(2000);
//	driver.close();
	}
}
