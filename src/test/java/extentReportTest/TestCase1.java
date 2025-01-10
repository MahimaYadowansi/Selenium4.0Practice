package extentReportTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class TestCase1 {
	
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeTest
	public void setReport()
	{
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./ExtentReport/extent.html");
		sparkReporter.config().setEncoding("UTF-8");
		sparkReporter.config().setDocumentTitle("Automation report");
		sparkReporter.config().setReportName("ExtentReport result");
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		
		extent.setSystemInfo("Automation tester", "Mahima kumari");
		extent.setSystemInfo("Organization", "Catalyst group");
		extent.setSystemInfo("Build number", "AU_04");
		
		
		
	}
	@AfterTest
	public void endReport()
	{
		extent.flush();
	}

}
