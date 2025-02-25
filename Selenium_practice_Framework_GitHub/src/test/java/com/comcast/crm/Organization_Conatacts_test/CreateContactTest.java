package com.comcast.crm.Organization_Conatacts_test;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.generic.webdriverutility.Javautility;
import com.comcast.crm.objecctrepositaryutilirity.Contactsinfopage;
import com.comcast.crm.objecctrepositaryutilirity.Contactspage;
import com.comcast.crm.objecctrepositaryutilirity.CreateNewContactsPage;
import com.comcast.crm.objecctrepositaryutilirity.CreateNewOrganizationPage;
import com.comcast.crm.objecctrepositaryutilirity.Homepage;
import com.comcast.crm.objecctrepositaryutilirity.Loginpage;
import com.comcast.crm.objecctrepositaryutilirity.Organizationpage;

public class CreateContactTest {
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
		
		Loginpage lp=new Loginpage(driver);
		lp.logintoApp(URL, USERNAME, PASSWORD);
		
		
		Homepage hp= new Homepage(driver);
		hp.getCntlnk().click();
	
		Contactspage cp= new Contactspage(driver);
		cp.getCreatecontact().click();
		
		CreateNewContactsPage cnp= new CreateNewContactsPage(driver);
		cnp.writedata(contname);
	
		//verify
		String heading = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(heading.contains(contname)) {
			System.out.println(contname+ " created");
		}else {
			System.out.println(contname+ " Not created");
		}
		
		Contactsinfopage cip= new Contactsinfopage(driver);
		String actualheader=cip.getHeader().getText();
		System.out.println(actualheader);
		if(actualheader.contains(contname)) {
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}
		
		hp.getSignout().click();
		Actions act= new Actions(driver);
		act.moveToElement(hp.getOut()).click().perform();
	}
	
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
		String actualdate = jlib.getsystemdateYYYYDDMM();
		
		//to get 30days date
		String datereq = jlib.getsystemdateYYYYDDMM(30);
	
		
		WebDriver driver= null;
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}else if (BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}else {
			driver= new ChromeDriver();
		}
		
		Loginpage lp= new Loginpage(driver);
		lp.logintoApp(URL, USERNAME, PASSWORD);
		
		Homepage hp= new Homepage(driver);
		hp.getCntlnk().click();

		Contactspage cp= new Contactspage(driver);
		cp.getCreatecontact().click();
		
		CreateNewContactsPage cnp= new CreateNewContactsPage(driver);
		cnp.writedata(contname, actualdate, datereq);
		
	
		//verify
		String date = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		String date30 = driver.findElement(By.id("mouseArea_Support End Date")).getText();
		if(date.equals(actualdate)) {
			System.out.println("Pass");
		}else {
			System.out.println("Failed");
		}
		//String date30 = driver.findElement(By.id("mouseArea_Support End Date")).getText();
		if (date30.equals(datereq)) {
			System.out.println("Verifed 30 days date");
		}
		else {
			System.out.println("NOT Correct- please Verify");
		}

		
		hp.getSignout().click();
		Actions act= new Actions(driver);
		act.moveToElement(hp.getOut()).click().perform();
		driver.quit();
	}
	
	@Test
	public void Contacts_06() throws Exception {
		
		Javautility jlib= new Javautility();
				
		
		Fileutility flib= new Fileutility();
		String URL =flib.getDatafromPropertiesFile("url");
		String BROWSER =flib.getDatafromPropertiesFile("browser");
		String USERNAME =flib.getDatafromPropertiesFile("username");
		String PASSWORD =flib.getDatafromPropertiesFile("password");
		
		Excelutility elib= new Excelutility();
		String contname = elib.getDataFromExcel("Sheet1", 10, 2);
		String orgname = elib.getDataFromExcel("Sheet1", 1, 2)+ jlib.getrandomnumber();
		
		//to get current date
		String actualdate = jlib.getsystemdateYYYYDDMM();
		//to get 30days date
		String datereq = jlib.getsystemdateYYYYDDMM(30);
		
		WebDriver driver= null;
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}else if (BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}else {
			driver= new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Loginpage lp= new Loginpage(driver);
		lp.logintoApp(URL, USERNAME, PASSWORD);
		
		Homepage hp= new Homepage(driver);
		hp.getOrglnk().click();
		
		Organizationpage op= new Organizationpage(driver);
		op.getCreatbtn().click();
		
		CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
		cop.writedata(orgname);
		
		WebElement ele = hp.getCntlnk();
		System.out.println(ele);
		Thread.sleep(2000);
		ele.click();
       
		Contactspage cp= new Contactspage(driver);
		cp.getCreatecontact().click();
	
		CreateNewContactsPage cnp= new CreateNewContactsPage(driver);
		cnp.newdata(contname, actualdate, datereq);		
		cnp.getAddorganization().click();

		Set<String> allwh = driver.getWindowHandles();
		//System.out.println(allwh.size());
		String wh = driver.getWindowHandle();
		for (String we : allwh) {
			driver.switchTo().window(we);
		}
		driver.findElement(By.id("search_txt")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		driver.switchTo().window(wh);

		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
	
		//organization name verify
		String Actualorgname = driver.findElement(By.xpath("(//a[text()='"+orgname+"'])[2]")).getText();
		if(Actualorgname.equals(orgname)) {
			System.out.println("Verified");
		}else {
			System.out.println("Organization not verified");
		}


		hp.getSignout().click();
		Actions act= new Actions(driver);
		act.moveToElement(hp.getOut()).click();
		driver.quit();
	}

}
