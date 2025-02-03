package Utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Class_A {

	WebDriver driver;
	public static String getScreenshot(WebDriver driver, String testName) throws IOException
	{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    String path=testName+".png";
		//File Dest=new File("C:\\Users\\sakshib\\Pictures\\Screenshot");
		File dest= new File(path);
		FileHandler.copy(source, dest);
		return path;
	}
	
	public static WebElement expliciteWait(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement element1=wait.until(ExpectedConditions.visibilityOf(element));
		return element1;
	}
	
//	public static WebElement impliciteWait(WebDriver driver, WebElement element)
//	{
//		WebElement element1=driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
//		return element;
//	}
	
}
