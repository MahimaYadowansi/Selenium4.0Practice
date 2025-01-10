package chromeDevTool;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v129.emulation.Emulation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMockGEOLocation {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//access to devtool
		DevTools devtool= ((HasDevTools) driver).getDevTools();
		devtool.createSession();
		
	
		devtool.send(Emulation.setGeolocationOverride(Optional.of(51.509865), Optional.of(-0.118092), Optional.of(100)));
		driver.get("https://www.gps-coordinates.net/");

	}

}
