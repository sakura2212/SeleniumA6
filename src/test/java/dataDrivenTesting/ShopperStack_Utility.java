package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ShopperStack_Utility {
	
	public static String LoginShopper(String key) throws IOException 
	{
		FileInputStream fis =new FileInputStream(".\\Configure\\ShopperstackLogin.properties");
		Properties prop =new Properties();
		prop.load(fis);
		String data = prop.getProperty(key);
		return data;
		
	}

}
