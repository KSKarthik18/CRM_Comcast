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

public class Working_with_Cnt_TC04 {
	@Test
	public void contacts_01() throws Exception {
		Javautility jlib= new Javautility();
		
		
		Fileutility flib= new Fileutility();
		String URL =flib.getDatafromPropertiesFile("url");
		String BROWSER =flib.getDatafromPropertiesFile("browser");
		String USERNAME =flib.getDatafromPropertiesFile("username");
		String PASSWORD =flib.getDatafromPropertiesFile("password");
		
		
		Excelutility elib= new Excelutility();
		String contname = elib.getDataFromExcel("Sheet1", 10, 2) +jlib.getrandomnumber();
		
		
		
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
		

		driver.quit();
	}

}
