package practice.testng;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.baseclass.Baseclass;
import com.comcast.crm.generic.webdriverutility.UtilityClass;
import com.comcast.crm.objecctrepositaryutilirity.Homepage;
@Listeners(com.comcast.crm.generic.listener_Utility.Listener.class)
public class Sample_listener extends Baseclass {
			
	
	@Test//(retryAnalyzer = com.comcast.crm.generic.listener_Utility.Retry_analyser.class)
	public void listener() {
//		WebDriver driver= new ChromeDriver();
//		driver.get("https://www.flipkart.com");
		Homepage hp = new Homepage(driver);
		hp.getOrglnk().click();
		UtilityClass.getTest().log(Status.INFO,"Step1");
		String titl = driver.getTitle();
		Assert.assertEquals(titl, "CRM");
		System.out.println("Step 2");
	}
	
	@Test
	public void listener_1() {
		Homepage hp = new Homepage(driver);
		hp.getCntlnk().click();
		UtilityClass.getTest().log(Status.INFO, "Step1");
		String title=driver.getTitle();
		Assert.assertEquals(title, "Contacts");
		UtilityClass.getTest().log(Status.INFO, "Step 2");
	}
}
