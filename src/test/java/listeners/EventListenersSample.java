package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

public class EventListenersSample {

	public static void main(String[] args) {
		WebDriver webdriver=new ChromeDriver();
		
		//add this two line so that driver can add listeners.
		WebDriverListener listeners=new MyListener();
		WebDriver driver=new EventFiringDecorator<WebDriver>(listeners).decorate(webdriver);
		
		driver.get("https://practicetestautomation.com/practice-test-login/");
		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys("student");
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("Password123");
		WebElement submitbtn=driver.findElement(By.xpath("//button[@id='submit']"));
		submitbtn.click();

	}

}
