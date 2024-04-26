package Project;
//Selenium Packages for webdriver
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverSetup {
	
		public static WebDriver driver;
		
		public static WebDriver getWebDriver(String browser) {
			
			try {
				if(browser.equalsIgnoreCase("chrome")){
					driver= new ChromeDriver();
				}
				else if(browser.equalsIgnoreCase("edge")){
					driver= new EdgeDriver();
				}
				else if(browser.equalsIgnoreCase("firefox"))
				{
					driver= new FirefoxDriver();
				}
				
			}catch(Exception e) {
				System.out.println("Invalid driver setup");
				System.out.println(e);
			}
			return driver;
			
		}
		

		



	

}
