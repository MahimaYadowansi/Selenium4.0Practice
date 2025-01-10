package chromeDevTool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v129.security.Security;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBadSSL {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		//access to devtool
		DevTools devtool= ((HasDevTools) driver).getDevTools();
		devtool.createSession();
		
		//enable security
		devtool.send(Security.enable());
		devtool.send(Security.setIgnoreCertificateErrors(true));
		
		driver.get("https://expired.badssl.com");

	}

}
