package com.comcast.crm.contacttest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.generic.webdriverutility.Javautility;

public class Working_with_Cnt_TC05 {
	@Test
	public void contacs_02() throws Exception {

		Javautility jlib= new Javautility();
		
		Fileutility flib= new Fileutility();
		String URL = flib.getDatafromPropertiesFile("url");
		String BROWSER = flib.getDatafromPropertiesFile("browser");
		String USERNAME = flib.getDatafromPropertiesFile("username");
		String PASSWORD = flib.getDatafromPropertiesFile("password");
		
		Excelutility elib= new Excelutility();
		String contname = elib.getDataFromExcel("Sheet1", 10, 2) + jlib.getrandomnumber();
		
		
//		//to get current date
//		String actualdate = jlib.getsystemdaateYYYYDDMM();
//		
//		//to get 30days date
//		String datereq = jlib.getsystemdateYYYYDDMM(30);
	
		
		WebDriver driver= null;
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}else if (BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}else {
			driver= new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@nAME='lastname']")).sendKeys(contname);
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(jlib.getsystemdateYYYYDDMM());
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(jlib.getsystemdateYYYYDDMM(30));
		
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		
	
		//verify
		String heading = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(heading.contains(contname)) {
			System.out.println(contname+ " created");
		}else {
			System.out.println(contname+ " Not created");
		}
		
		String actualname = driver.findElement(By.id("mouseArea_Last Name")).getText();

		if(actualname.trim().equals(contname)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
		
		String date = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		String date30 = driver.findElement(By.id("mouseArea_Support End Date")).getText();
		if(jlib.getsystemdateYYYYDDMM().trim().equals(date)) {
			System.out.println("Verified");
		}else {
			System.out.println("Not Verified");
		}
		//String date30 = driver.findElement(By.id("mouseArea_Support End Date")).getText();
		if (date30.trim().equals(jlib.getsystemdateYYYYDDMM(30))) {
			System.out.println("Verifed 30 days date");
		}
		else {
			System.out.println("NOT Correct- please Verify");
		}

		
		driver.quit();
	}

}
