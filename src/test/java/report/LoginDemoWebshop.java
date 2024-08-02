package report;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class LoginDemoWebshop {
	@Test
	public void Login()
	{
		ExtentSparkReporter spark =new ExtentSparkReporter("./Reports/LoginDemoWeb.html");
		//configuration
		spark.config().setDocumentTitle("sample");
		spark.config().setReportName("Varsha");
		spark.config().setTheme(Theme.DARK);
		
		//create extent report
		ExtentReports report =new ExtentReports();
		report.setSystemInfo("os", "Window") ;
		report.setSystemInfo("browser", "Chrome") ;
		
		//attached spark report to the extent report
		report.attachReporter(spark);
		ExtentTest test = report.createTest("Login");
		
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.linkText("Log in")).click();
		
		driver.findElement(By.cssSelector("input[class='email']")).
		sendKeys("varshay@gmail.com");
		
		driver.findElement(By.cssSelector("input[class='password']")).
		sendKeys("varshay123");
		
		driver.findElement(By.cssSelector("input[value='Log in']")).
		click();
		
		
		
		
	}

}
