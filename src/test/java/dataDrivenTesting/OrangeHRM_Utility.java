package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class OrangeHRM_Utility {

	public static String OrangeHrm(String key) throws IOException
	
	{
		FileInputStream fis =new FileInputStream(".\\Configure\\OrangeHRM.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String data = prop.getProperty(key);
		return data;
	}
}
