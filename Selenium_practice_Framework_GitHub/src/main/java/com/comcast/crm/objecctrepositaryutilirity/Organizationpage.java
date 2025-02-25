package com.comcast.crm.objecctrepositaryutilirity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizationpage {
	//step3 
	public Organizationpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//step2 
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement creatbtn;

	//step4
	public WebElement getCreatbtn() {
		return creatbtn;
	}
	
	//step5
	//not required as there is no much steps to execute
	
	

}
