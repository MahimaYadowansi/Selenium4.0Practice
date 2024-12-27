package chromeDevTool;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v127.console.Console;
import org.openqa.selenium.devtools.v129.log.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestConsoleLog {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		
		//access to devtool
		DevTools devtool= ((HasDevTools) driver).getDevTools();
		devtool.createSession();
		devtool.send(Log.enable());
		//extract console
		devtool.send(Console.enable());
		devtool.addListener(Log.entryAdded(), entry ->{
			System.out.println("Text is: "+entry.getText());
			System.out.println("TimeStamp is: "+entry.getTimestamp());
			System.out.println("Level is: "+entry.getLevel());
		});
		
		devtool.addListener(Console.messageAdded(), message ->{
			System.out.println(" The Console Text is: "+message.getText());
			
		});
		
		driver.get("https://www.flipkart.com/");
		//add log in console using javascript
		((JavascriptExecutor) driver).executeScript("console.log('This is sample log')");
	}

}
