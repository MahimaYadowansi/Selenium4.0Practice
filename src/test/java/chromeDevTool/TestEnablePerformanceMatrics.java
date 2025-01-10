package chromeDevTool;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v129.performance.Performance;
import org.openqa.selenium.devtools.v129.performance.model.Metric;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestEnablePerformanceMatrics {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		
		//access to devtool
		DevTools devtool= ((HasDevTools) driver).getDevTools();
		devtool.createSession();
		devtool.send(Performance.enable(Optional.of(Performance.EnableTimeDomain.TIMETICKS)));
		driver.get("https://flipkart.com");
List<Metric> metrics = devtool.send(Performance.getMetrics());
		
		metrics.forEach(metric ->System.out.println(metric.getName()+" : "+metric.getValue()));
		
	}

}
