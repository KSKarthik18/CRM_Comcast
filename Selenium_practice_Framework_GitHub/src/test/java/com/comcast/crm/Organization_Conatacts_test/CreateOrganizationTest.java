package com.comcast.crm.Organization_Conatacts_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.generic.webdriverutility.Javautility;
import com.comcast.crm.generic.webdriverutility.Webdriverutitlity;
import com.comcast.crm.objecctrepositaryutilirity.CreateNewOrganizationPage;
import com.comcast.crm.objecctrepositaryutilirity.Homepage;
import com.comcast.crm.objecctrepositaryutilirity.Loginpage;
import com.comcast.crm.objecctrepositaryutilirity.OrganizationInfoPage;
import com.comcast.crm.objecctrepositaryutilirity.Organizationpage;

public class CreateOrganizationTest {
	//login to app
	
	@Test
	public void org_01() throws Exception {
		Javautility rand=new Javautility();
		int ranum = rand.getrandomnumber();
		
		Fileutility flib= new Fileutility();
		String Browser = flib.getDatafromPropertiesFile("browser");
		String url = flib.getDatafromPropertiesFile("url");
		String Username=flib.getDatafromPropertiesFile("username");
		String Password = flib.getDatafromPropertiesFile("password");
		
		Excelutility elib= new Excelutility();
		String orgname = elib.getDataFromExcel("Sheet1", 1, 2)+ranum;
		
		WebDriver driver= null;
		if(Browser.equals("chrome")) {
			driver=new ChromeDriver();
		}else if (Browser.equals("firefox")) {
			driver= new FirefoxDriver();
		}else {
			driver= new ChromeDriver();
		}
		
		Webdriverutitlity wllib= new Webdriverutitlity();
		wllib.maximize(driver);
		wllib.implicitwait(driver);
		
		
		//rule 3
		Loginpage lp= new Loginpage(driver);
//		Loginpage lp = PageFactory.initElements(driver, Loginpage.class);
//		lp.getUsernameedt().sendKeys(Username);
//		lp.getPasswordedt().sendKeys(Password);
//		lp.getLoginbtn().click();
		lp.logintoApp(url, Username, Password);
		
		Homepage hp=new Homepage(driver);
		hp.getOrglnk().click();
		
		Organizationpage op=new Organizationpage(driver);
		op.getCreatbtn().click();
		
		CreateNewOrganizationPage cnp=new CreateNewOrganizationPage(driver);
		cnp.writedata(orgname, "Banking");
		
		OrganizationInfoPage oip= new OrganizationInfoPage(driver);
		String actheader=oip.getHeader().getText();
		if(actheader.contains(orgname)) {
			System.out.println("Verified");
		}else {
			System.out.println("Its not matching");
		}
		
		hp.getSignout().click();
		Actions act= new Actions(driver);
		act.moveToElement(hp.getOut()).click().perform();	
	}

}
