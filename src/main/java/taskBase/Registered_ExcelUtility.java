package taskBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Registered_ExcelUtility {
	
	public static ArrayList<String> ExcelUtility() throws EncryptedDocumentException, IOException
	{
	FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\Desktop\\Automation\\TestData\\DWSRegistered.xlsx");
	Workbook wb = WorkbookFactory.create(fis) ;
	
	 Sheet sheetName = wb.getSheet("Sheet1") ;
	 ArrayList<String> arr =new ArrayList<String>();
	 for ( int i = 0; i < 6; i++) {
		 arr.add( sheetName.getRow(i).getCell(0).toString());
		 
	}
	return arr;
	}
}
