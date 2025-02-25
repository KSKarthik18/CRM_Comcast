package com.comcast.crm.orgtest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.generic.webdriverutility.Javautility;

public class Working_with_Org_TC01 {

	@Test(invocationCount = 3, threadPoolSize = 3)
	public void organization_01() throws Exception {
		
		Javautility jlib= new Javautility();
		int rannum =jlib.getrandomnumber();		

		Fileutility flib=new Fileutility();
		String URL = flib.getDatafromPropertiesFile("url");
		String BROWSER = flib.getDatafromPropertiesFile("browser");
		String USERNAME = flib.getDatafromPropertiesFile("username");
		String PASSWORD =flib.getDatafromPropertiesFile("password");
		
		Excelutility elib=new Excelutility();
		elib.getDataFromExcel("Sheet1", 1, 2);
		String orgname = elib.getDataFromExcel("Sheet1", 1, 2)+ rannum;
		
		
		
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
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@nAME='accountname']")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		
		
		
		//verify
		String heading = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(heading.contains(orgname)) {
			System.out.println(orgname + "\t" +"created");
		}else {
			System.out.println(orgname+ "Not created");
		}
		
		String actualname = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if(actualname.trim().equals(orgname)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
		driver.quit();
	}
}
