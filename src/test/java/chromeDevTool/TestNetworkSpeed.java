package chromeDevTool;



import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v129.network.Network;
import org.openqa.selenium.devtools.v129.network.model.ConnectionType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNetworkSpeed {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//access to devtool
		DevTools devtool= ((HasDevTools) driver).getDevTools();
		devtool.createSession();
		devtool.send(Network.emulateNetworkConditions(false, 100, 20000, 10000, Optional.of(ConnectionType.CELLULAR2G), java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty()));
		driver.get("https://www.makemytrip.com/");
	}

}
