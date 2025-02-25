package com.comcast.crm.orgtest;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.Fileutility;

public class Working_with_Org_TC03 {

	@Test
	public void Organization_03() throws Exception {
		Random ran=new Random();
		int rannum = ran.nextInt(1000);
		
		Fileutility flib= new Fileutility();
		String URL = flib.getDatafromPropertiesFile("url");
		String BROWSER = flib.getDatafromPropertiesFile("browser");
		String USERNAME = flib.getDatafromPropertiesFile("username");
		String PASSWORD = flib.getDatafromPropertiesFile("password");
		
		
		Excelutility elib= new Excelutility();
		String orgname = elib.getDataFromExcel("Sheet1", 7, 2) +rannum;
		String Industries = elib.getDataFromExcel("Sheet1", 7, 3);
		String Type = elib.getDataFromExcel("Sheet1", 7, 4);
		String Phones = elib.getDataFromExcel("Sheet1", 7, 5);
		
		
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
		WebElement drop = driver.findElement(By.name("industry"));
		Select s= new Select(drop);
		s.selectByVisibleText(Industries);
		
		WebElement drop1 = driver.findElement(By.name("accounttype"));
		Select s1= new Select(drop1);
		s1.selectByVisibleText(Type);
		
		driver.findElement(By.id("phone")).sendKeys(Phones);
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		
	
		//verify
		String heading = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(heading.contains(orgname)) {
			System.out.println(orgname+ " created");
		}else {
			System.out.println(orgname+ " Not created");
		}
		
		String actualname = driver.findElement(By.id("mouseArea_Organization Name")).getText();

		if(actualname.trim().equals(orgname)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
		
		String actual_num = driver.findElement(By.id("mouseArea_Phone")).getText();
		if(actual_num.trim().equals(Phones)) {
			System.out.println("Number added sucessfulyy"+ Phones);
		}else {
			System.out.println("failed to add");
		}
		driver.quit();
	}
}
