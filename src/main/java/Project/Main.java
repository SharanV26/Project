package Project;
//Java packages
import java.io.IOException;

//Selenium packages
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;


public class Main {
	public static WebDriver driver;
	
	public static void main(String[] args) throws IOException, InvalidFormatException  {

//Creating Object of Signin  to access the methods			
			SignIn s=new SignIn();
			driver = s.Driver("chrome");
//Empty string for storing values in excel
			String output="";
			s.getUrl();
			s.maxWindow();
			s.Signin();
			s.textBox();
	        System.out.println("The Text  captured is - "+s.captureText());
	        output=output+"The Text  captured is - "+s.captureText()+"\n";
	        Screenshot.screenshot("mid",driver);
			System.out.println("Checking whether the button is enabled - "+s.getValue());
			output=output+"Checking whether the button is enabled -  "+s.getValue()+"\n";
			s.closebutton();
			s.login();
			s.searchBox();
			output=output+s.result();
			Screenshot.screenshot("last",driver);
			ExcelUsage.Output(output);
			TxtFile.Output(output);
			s.closebrowser();
		}

	}


