package chromeDevTool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenPDF {

	public static void main(String[] args) {
		 // Set up the ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Launch Chrome without mobile emulation
        WebDriver driver = new ChromeDriver();  // No mobile emulation options

        try {
            // Path to your local PDF file
            String pdfPath = System.getProperty("user.dir") + "/src/test/resources/Mahima Kumari_Values_Identifier_Report (2).pdf";
            String fileURL = "file:///" + pdfPath.replace("\\", "/");  // Ensure proper URL format

            // Open the PDF file in the browser
            driver.get(fileURL);

            // Wait for a few seconds to view the PDF
            //Thread.sleep(5000); // Adjust time as needed

            System.out.println("Local PDF opened successfully in desktop mode!");

        } catch (Exception e) {
            System.err.println("Error opening local PDF: " + e.getMessage());
        } /*finally {
            // Close the browser
            driver.quit();
        }*/

	}

}
