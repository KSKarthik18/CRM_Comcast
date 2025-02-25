package com.comcast.crm.objecctrepositaryutilirity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganizationPage {
	
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//step2
	@FindBy(name = "accountname")
	private WebElement name;
	
	@FindBy(name = "industry")
	private WebElement industryDD;
	
	@FindBy(name = "accounttype")
	private WebElement typeDD;
	
	@FindBy(name = "phone")
	private WebElement phone;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;

	public WebElement getName() {
		return name;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public WebElement getIndustryDD() {
		return industryDD;
	}
	public WebElement getTypeDD() {
		return typeDD;
	}

	public WebElement getPhone() {
		return phone;
	}

	//step5
	public void writedata(String orgname, String Indutry) {
		name.sendKeys(orgname);
		Select sel=new Select(industryDD);
		sel.selectByVisibleText(Indutry);	
		savebtn.click(); 
	}
	public void writedata(String orgname) {
		name.sendKeys(orgname);	
		savebtn.click(); 
	}
	public void writedata(String orgname, String Indutry,String Type) {
		name.sendKeys(orgname);
		Select sel=new Select(industryDD);
		Select sel1= new Select(typeDD);
		sel.selectByVisibleText(Indutry);	
		sel1.selectByVisibleText(Type);
		savebtn.click(); 	
	}
	
	public void writedata(String orgname, String Indutry,String Type, String phones) {
		name.sendKeys(orgname);
		Select sel=new Select(industryDD);
		Select sel1= new Select(typeDD);
		sel.selectByVisibleText(Indutry);	
		sel1.selectByVisibleText(Type);
		phone.sendKeys(phones);
		savebtn.click(); 	
	}
	

}
