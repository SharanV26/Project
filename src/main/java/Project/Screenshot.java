package Project;
//Java Packages
import java.io.File;
import java.io.IOException;
//Selenium Packages
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
//To take the screenshot of the project
	public static void screenshot(String img, WebDriver driver){
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("C:\\Users\\2318694\\eclipse-workspace\\Sharan\\src\\Screenshots\\"+img+".png");
		try {
			FileUtils.copyFile(src, trg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
