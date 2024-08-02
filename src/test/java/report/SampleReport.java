package report;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReport {
	
	@Test
	public void BasicReport()
	{
		
		ExtentSparkReporter spark =new ExtentSparkReporter("./Reports/sampl.html");
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
		ExtentTest test = report.createTest("Basic");
		test.log(Status.INFO, "report is successfully created");
		report.flush();
	}

}
