package chromeDevTool;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_LocalPDF_ViewINDevices {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		 // Define device metrics for iPhone 12 Pro
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 390); // Screen width in pixels
        deviceMetrics.put("height", 844); // Screen height in pixels
        deviceMetrics.put("pixelRatio", 3.0); // Pixel density for iPhone 12 Pro

        // Define the user agent for iPhone 12 Pro
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        mobileEmulation.put("userAgent",
            "Mozilla/5.0 (iPhone; CPU iPhone OS 14_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.0 Mobile/15E148 Safari/604.1");

	        // Configure ChromeOptions for mobile emulation
	        ChromeOptions chromeOptions = new ChromeOptions();
	        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

	        // Launch Chrome in mobile emulation mode
	        WebDriver driver = new ChromeDriver(chromeOptions);

	        try {
	        	String pdfPath = System.getProperty("user.dir") + "/src/test/resources/Mahima Kumari_Values_Identifier_Report (2).pdf";
	        	String fileURL = "file:///" + pdfPath.replace("\\", "/"); // Ensure proper URL format

	        	// Open the file in the browser
	        	driver.get(fileURL);

	            // Wait for a few seconds to view the PDF
	           // Thread.sleep(5000); // Adjust time as needed

	            System.out.println("Local PDF opened successfully in iPhone 12 Pro emulation!");

	        } catch (Exception e) {
	            System.err.println("Error opening local PDF: " + e.getMessage());
	        } /*finally {
	            // Close the browser
	            driver.quit();
	        }*/
		
		

	}

}
