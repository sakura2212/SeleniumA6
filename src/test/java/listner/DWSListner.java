package listner;

import static org.testng.Assert.assertEquals;

import org.testng.ITestListener;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseDWS.DWSBaseListener;

@Listeners(com.crm.listner.Basic.class)

public class DWSListner extends DWSBaseListener {
	
	@Test
	public void Base1()
	{
		String actual = driver.getCurrentUrl();
		String expected = "https://demowebshop.tricentis.com/" ;		
		assertEquals(expected, actual);
	}
	
	@Test
	public void Base2()
	{
		String actual = driver.getCurrentUrl();
		String expected = "https://demowebshop.tricentis.com" ;		
		assertEquals(expected, actual);
	}
	
//IMP Notes
//1.main/java => create base class of DWS with testng annotation (pkg => BaseDWS)	
//2. in base class(DWSBaseListner )used ddt approach => fetch property data from JavaUtility(pkg => BaseDWS)
//3. in listner pkg =>Basic.java => extends DWSBaseListener implements ITestListener 
//4.onTestStart => write 
	//String name = result.getMethod().getMethodName();
	//Reporter.log("onTestStart"+" "+name,true);
//5. onTestFailure => typecast screenshot
//6.in test/java => extends DWSBaseListner (which is base class)
//7. write test script using @Test 

}
