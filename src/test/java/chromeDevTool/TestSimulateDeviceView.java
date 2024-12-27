package chromeDevTool;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSimulateDeviceView {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		// Set mobile emulation options/parameter
		Map<String, Object> deviceMetrics = new HashMap<>();
		deviceMetrics.put("width", 390); //412
		deviceMetrics.put("height", 844); //915
		deviceMetrics.put("pixelRatio", 3.0);

		Map<String, Object> mobileEmulation = new HashMap<>();
		mobileEmulation.put("deviceMetrics", deviceMetrics);
		//Samsung Galaxy S20 running Android 10 
	//	mobileEmulation.put("userAgent","Mozilla/5.0 (Linux; Android 10; SAMSUNG SM-G980F Build/QP1A.190711.020) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36");
		
		//iPhone 12 Pro with iOS 14 and Safari.
		 mobileEmulation.put("userAgent","Mozilla/5.0 (iPhone; CPU iPhone OS 14_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.0 Mobile/15E148 Safari/604.1");

		
		Map<String, Object> clientHints = new HashMap<>();

		clientHints.put("platform", "Android");
		clientHints.put("mobile", true);

		mobileEmulation.put("clientHints", clientHints);

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

		// Launch Chrome with mobile emulation
		WebDriver driver = new ChromeDriver(chromeOptions);

		// Open the website
		driver.get("https://www.selenium.dev/");

	}

}
