package Project;

//Importing Java Packages
import java.io.IOException;
import java.time.Duration;

//importing Selenium Packages
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignIn {
//Declaring variables
	public static WebDriver driver;
	public static String baseUrl;
	
//Method for Driver Setup 
	public WebDriver Driver(String browser) {
		driver = DriverSetup.getWebDriver(browser);
		
//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
//Method for url(Launch browser)
	public void getUrl() {
		baseUrl= "https://www.quora.com/profile/Quora";
		driver.get(baseUrl);
	}
	
	public void maxWindow() {
//Maximizing Window
		driver.manage().window().maximize();
	}
	 
//Actions performed to Signin
	public void Signin() {
		driver.findElement(By.xpath("//div[starts-with(text(),'Sign')]/ancestor::button")).click();
		
		driver.findElement(By.xpath("//div[starts-with(text(),'Sign up')]")).click();
	}
	
//Entering data in text box for validation 	
	public void textBox() throws InvalidFormatException, IOException {
		
//Values from Excel
		driver.findElement(By.name("profile-name")).sendKeys(ExcelUsage.getValue(1, 0));
		driver.findElement(By.id("email")).sendKeys(ExcelUsage.getValue(1, 1));
		}
	
//Capture the error message 
	public String captureText() {
		String ct=driver.findElement(By.xpath("//div[@class = 'q-text qu-dynamicFontSize--small qu-color--red_error']")).getText();
		return ct;
	}
//Checks whether the button is enabled or not
	public boolean getValue() {
	boolean d = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[2]/div/div/button")).isEnabled();
    return d;
	}

//Closing the X button
	public void closebutton() {
	driver.findElement(By.xpath("//div[@class=\"q-flex qu-pt--small qu-pb--small qu-pl--tiny qu-pr--small qu-alignItems--center\"]/button")).click();
	}
	
//Logging with id and password
	public void login() throws InvalidFormatException, IOException {
		
//Explicit wait
		WebDriverWait myWait=new WebDriverWait(driver,Duration.ofSeconds(15));
		driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
		
//Getting data from excel
		driver.findElement(By.id("email")).sendKeys(ExcelUsage.getValue(2, 1));
		driver.findElement(By.name("password")).sendKeys(ExcelUsage.getValue(1, 2));
		
//Waits until login button is enabled and then it will be clicked
		WebElement Lb=myWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[1]/div[2]/div/div[4]/button")));
		Lb.click();
	}

//Entering data in search box
	public void searchBox() throws InvalidFormatException, IOException {
		WebElement sb=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div/div[1]/div/div/form/div/div/div/div/div/input"));
		
//Getting data from Excel
		sb.sendKeys(ExcelUsage.getValue(1, 3));
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
	
			e.printStackTrace();
		}
		sb.sendKeys(Keys.ENTER);
	}
	
//Capturing the result page
	public String result() {
		WebElement e=driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div/div[1]/div/div[1]/div"));
		
//Verifying act_res with the exp_res
		String exp_res=("Results for Testing");
		String act_res=e.getText();
		System.out.println(e.getText());
	
			if(exp_res.equals(act_res))
			{
				System.out.println("Valid");
				return "Results for Testing "+"\n"+"Valid";
			}
			else
			{
				System.out.println("Invalid");
				return "Results for Testing "+"\n"+"Invalid";
			}		
	}
	
//To close the browser 
	public void closebrowser() {
		driver.quit();
	}
	
	
}
