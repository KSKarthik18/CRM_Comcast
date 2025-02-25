package practice.testng;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Sample_screenshot{
	
	@Test
	public void screenshot() throws Exception {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		//step 1
		TakesScreenshot ts= (TakesScreenshot) driver;
		//step2
		File src = ts.getScreenshotAs(OutputType.FILE);
		//step3
		FileUtils.copyFile(src, new File("./screenshot/test1.jpeg"));
	}
}
