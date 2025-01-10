package chromeDevTool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v129.emulation.Emulation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestOverrideTimeZoneValue {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://whatismytimezone.com/");
		Thread.sleep(5000);
		
		//access to devtool
		DevTools devtool= ((HasDevTools) driver).getDevTools();
		devtool.createSession();
		devtool.send(Emulation.setTimezoneOverride("EST"));
		driver.get("https://whatismytimezone.com/");

	}

}
