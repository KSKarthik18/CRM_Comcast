package dataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.Excelutility;

public class Getproductinfo_Test {
	
	@Test(dataProvider = "getdata")
	public void getProductinfoTest(String brandname, String productname) {
		WebDriver driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandname,Keys.ENTER);
		String x="//span[text()='"+productname+"']/../../../../../../div/div/div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span/span[2]/span[2]";
		String price= driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
	}


	@DataProvider
	public Object[][] getdata() throws Exception{
		
			Excelutility elib= new Excelutility();
			int rowcount=elib.getRowcoutn("Sheet2");
		
			Object[][] objarr=new Object[rowcount][2];
			for(int i=0; i<rowcount;i++) {
			objarr[i][0]=elib.getDataFromExcel("Sheet2", i+1, 0);
			objarr[i][1]=elib.getDataFromExcel("Sheet2", i+1, 1);
//			
//			objarr[i][0]=elib.getDataFromExcel("Sheet2", i+1, 0);
//			objarr[i][1]=elib.getDataFromExcel("Sheet2", i+1, 1);
//			
//			objarr[i][0]=elib.getDataFromExcel("Sheet2", i+1, 0);
//			objarr[i][1]=elib.getDataFromExcel("Sheet2", i+1, 1);
			
			}
			return objarr;
			
}
}