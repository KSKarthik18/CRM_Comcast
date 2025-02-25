package com.comcast.crm.objecctrepositaryutilirity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement header;
	
	@FindBy(xpath = "(//a[text()='Contacts'])[1]")
	private WebElement contacts;

	public WebElement getHeader() {
		return header;
	}

	public WebElement getContacts() {
		return contacts;
	}
	
	
	
	
}
