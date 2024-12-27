package chromeDevTool;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDeviceView {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//access to devtool
		DevTools devtool= ((HasDevTools) driver).getDevTools();
		devtool.createSession();
		Map<String, Object> deviceMetrics = new HashMap<String, Object>() {
			 
			{
 
				put("width", 375);
				put("height", 812);
				put("mobile", true);
				put("deviceScaleFactor", 50);
			}
 
		};
 
		((ChromeDriver) driver).executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
		
		driver.get("https://selenium.dev/");

	}

}
