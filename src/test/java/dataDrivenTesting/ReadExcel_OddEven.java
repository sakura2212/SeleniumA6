package dataDrivenTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel_OddEven {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		

		//workbook factory present in apache poi
		File path=new File("C:\\Users\\DELL\\Desktop\\Automation\\TestData\\NumberTest.xlsx") ;
		FileInputStream fis =new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis) ;
	
		 Sheet sheet = wb.getSheet("Sheet1") ; //targeted sheet
		 
		 //dynamic way to get no of row and colm
		int row = sheet.getPhysicalNumberOfRows() ;
		
		
		// int row=5,col=2;   // static way
		
		
		for (int i = 0; i < row; i++) {
			 
				 String data = sheet.getRow(i).getCell(0).toString();
				 //int num =Integer.parseInt(data) ;
				 //System.out.println(data);
				double num = Double.parseDouble(data) ;
				
				 if(num%2==0)
				 {
					 System.out.println("Even No => "+num);
				 }
				 else {
					 System.out.println("Odd No => "+num);
				 }
				
			
		 }

	}

}
