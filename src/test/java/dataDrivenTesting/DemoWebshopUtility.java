package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DemoWebshopUtility {

	public static String loginFunctionOperation(String key) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(".\\Configure\\login.properties");
		prop.load(fis);
		String data = prop.getProperty(key);
		return data;
	}

}
