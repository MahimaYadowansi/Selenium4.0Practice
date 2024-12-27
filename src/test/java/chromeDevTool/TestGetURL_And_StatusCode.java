package chromeDevTool;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v129.network.Network;
import org.openqa.selenium.devtools.v129.network.model.Headers;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestGetURL_And_StatusCode {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		
		//access to devtool
		DevTools devtool= ((HasDevTools) driver).getDevTools();
		devtool.createSession();
		devtool.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devtool.addListener(Network.requestWillBeSent(), request ->{
			Headers header=request.getRequest().getHeaders();
			if(!header.isEmpty())
			{
				System.out.println("Request headers: ");
				header.forEach((Key,value) ->{
					System.out.println(" "+Key+" "+value);
					
				});
			}
			
		
		});
		//extract response header
		
		devtool.addListener(Network.responseReceived(), response ->{
			Headers header=response.getResponse().getHeaders();
			if(!header.isEmpty())
			{
				System.out.println("Response headers: ");
				header.forEach((Key,value) ->{
					System.out.println(" "+Key+" "+value);
					
					System.out.println("The response url is: "+response.getResponse().getUrl());
					System.out.println("The response status code is: "+response.getResponse().getStatus());
					
				});
			}
			
		
		});
		
		driver.get("https://flipkart.com");
		
	}

}
