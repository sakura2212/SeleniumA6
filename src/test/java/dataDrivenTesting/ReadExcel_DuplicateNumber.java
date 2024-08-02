package dataDrivenTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel_DuplicateNumber {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		

		//workbook factory present in apache poi
		File path=new File("C:\\Users\\DELL\\Desktop\\Automation\\TestData\\NumberTest.xlsx") ;
		FileInputStream fis =new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis) ;
	
		 Sheet sheetName = wb.getSheet("Sheet2") ; //targeted sheet
		 
		 //dynamic way to get no of row and colm
		int row = sheetName.getPhysicalNumberOfRows() ;
			
		int count=0;
		List<String> arr =new ArrayList<String>();
		 for (int i = 0; i < row; i++) {
			 arr.add( sheetName.getRow(i).getCell(0).toString());
			 
		}
		
		 System.out.println(arr);
       Set<String> h1= new HashSet<String>(arr);
       System.out.println(h1);
       
       for (String str : h1) {
    	System.out.println(str +" : " +Collections.frequency(arr,str));
		
	}
       
       
	}

	}
