package dataDrivenTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel_PrimeNo {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		//workbook factory present in apache poi
				File path=new File("C:\\\\Users\\\\DELL\\\\Desktop\\\\Automation\\\\TestData\\\\NumberTest.xlsx") ;
				FileInputStream fis =new FileInputStream(path);
				Workbook wb = WorkbookFactory.create(fis) ;
			
				 Sheet sheet = wb.getSheet("Sheet1") ; //targeted sheet
				 
				 //dynamic way to get no of row and colm
				int row = sheet.getPhysicalNumberOfRows() ;
				
				double num=0;
				int i;
				 for ( i = 0; i < row; i++) {
					 
						 String data = sheet.getRow(i).getCell(0).toString();
						  num = Double.parseDouble(data) ;
						  //int n1=(int)num;
						  //System.out.println(n1);
						  if(isPrime(num) && num!=1)
						  {
							  System.out.println("Prime Number " +num);
						  }
						  else {
							  System.out.println("Not prime number " +num);
						  }
						 
					
					 
				 }
				
				
			}

public static boolean isPrime(double num)
{
	
	for (int i=2; i<num; i++)
	{
		if(num%i==0)
		{
			return false ;
		}
	}
	return true;
}

}
