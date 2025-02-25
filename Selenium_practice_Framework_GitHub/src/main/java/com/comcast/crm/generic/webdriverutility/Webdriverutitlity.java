package com.comcast.crm.generic.webdriverutility;

import java.io.File;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdriverutitlity {
	
	public void implicitwait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void expliwait(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void expliwaitusingurl(WebDriver driver,String url)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.urlContains(url));
	}
	
	public void expliwaittitle(WebDriver driver,String title)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	public void explicitelementclickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	
	}
	public void expliwaitelementtobeselected(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	public void expliwaitinvisiblityofallelements(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOfAllElements(element));
	}
//	public void explicitwaittexttobepresentinelement(WebDriver driver,String text)
//	{
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
//		
//	}
	//select class
	
		public void handledropdownvisibletext(WebElement element,String text)
		{
			Select sel=new Select(element);
					sel.selectByVisibleText(text);
		}
		public void handledropdownpartialtext(WebElement element,String partialtext)
		{
			Select sel=new Select(element);
			sel.selectByContainsVisibleText(partialtext);
		}

		public void handledropdownbyindex(WebElement element,int index)
		{
			Select sel=new Select(element);
			sel.selectByIndex(index);
		}
		public boolean handledropdownismultiple(WebElement element)
		{
			Select sel=new Select(element);
			return sel.isMultiple();
		}
		public void handledropdowndeselectall(WebElement element)
		{
			Select sel=new Select(element);
			sel.deselectAll();
		}
		public void handledropdowndeselectcontainsvisibletext(WebElement element,String text)
		{
			Select sel=new Select(element);
			sel.deSelectByContainsVisibleText(text);
		}
		public void handledropdowndeselect(WebElement element,int index)
		{
			Select sel=new Select(element);
			sel.deselectByIndex(index);
			
		}
		public void handledropdowngetoptions(WebElement element)
		{
			
			Select sel=new Select(element);
			sel.getOptions();
		}
		public void handledropdowngetfirstoption(WebElement element)
		{
			Select sel=new Select(element);
			sel.getFirstSelectedOption();
		}
		
		
		
		//actions class
		public void actionsmovetoelement(WebDriver driver,WebElement element)
		{
			Actions act=new Actions(driver);
			act.moveToElement(element).perform();
		}
		public void actions(WebDriver driver)
		{
			Actions act=new Actions(driver);
			act.clickAndHold().perform();
		}
		public void actionsclickhold(WebDriver driver,WebElement element)
		{
			Actions act=new Actions(driver);
			act.clickAndHold(element).perform();
		}
		public void actionsrightclick(WebDriver driver)
		{
			Actions act=new Actions(driver);
			act.contextClick().perform();
		}
		public void actionsdoubleclick(WebDriver driver)
		{
			Actions act=new Actions(driver);
			act.doubleClick().perform();
		}
		public void actionsdraganddrop(WebDriver driver,WebElement source,WebElement destination)
		{
			Actions act=new Actions(driver);
			act.dragAndDrop(source, destination).perform();
		}
		public void actionscrolltoelement(WebDriver driver,WebElement element)
		{
			Actions act=new Actions(driver);
			act.scrollToElement(element).perform();
		}
		
		public void actionscrollbyamount(WebDriver driver,int x,int y)
		{
			Actions act=new Actions(driver);
			act.scrollByAmount(x, y).perform();
		}
		
		//takescreenshot
		
		public void screenshot(WebDriver driver) throws Throwable
		{
			Date date= new Date();
			String d = date.toString();
			String d1 = d.replaceAll(":", "_");
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dst=new File("./screenshot/"+d1+".jpeg");
			FileHandler.copy(src, dst);
		}
		public void screenshotonelement(WebDriver driver,WebElement element) throws Throwable
		{
			Date date= new Date();
			String d = date.toString();
			String d1 = d.replaceAll(":", "_");
			//TakesScreenshot ts=(TakesScreenshot)driver;
			File src = element.getScreenshotAs(OutputType.FILE);
			File dst=new File("./screenshot/"+d1+".jpeg");
			FileHandler.copy(src, dst);
		}
		
		//java script executor
		
		public void javascriptscroll(WebDriver driver,int x,int y)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy("+x+","+y+")");
			
		}
		public void javascriptdisableelemnet(WebDriver driver,String id,String text)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("document.getElementById("+id+").value="+text+"");
			
		}
		public void javascriptoelement(WebDriver driver,WebElement element)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();",element);
		}
		
		

		//alert
		public void alertok(WebDriver driver)
		{
			Alert alt=driver.switchTo().alert();
			alt.accept();
		}
		public void alertcancel(WebDriver driver)
		{
			Alert alt=driver.switchTo().alert();
			alt.dismiss();
		}	
		public void alertbothokandcancel(WebDriver driver,String text)
		{
			Alert alt=driver.switchTo().alert();
			alt.sendKeys(text);
		}
		public void alerttext(WebDriver driver)
		{
			Alert alt=driver.switchTo().alert();
			alt.getText();
		}
		
		public void minimize(WebDriver driver)
		{
			driver.manage().window().minimize();
		}
		//maximize the browser
		public void maximize(WebDriver driver) 
		{
			driver.manage().window().maximize();
		}
		
		//frames
		public void framesbyindex(WebDriver driver,int index)
		{
			driver.switchTo().frame(index);
		}
		public void framesbynameorid(WebDriver driver,String value)
		{
			driver.switchTo().frame(value);
		}
		public void parentframe(WebDriver driver)
		{
			driver.switchTo().parentFrame();
		}
		public void framedefaultcontent(WebDriver driver)
		{
			driver.switchTo().defaultContent();
		}
		public void framebyelement(WebDriver driver,WebElement element)
		{
			driver.switchTo().frame(element);
		}
		
		//switch between windows
		
		public void windowhandlebyurl(WebDriver driver,String url)
		{
			Set<String> allwh = driver.getWindowHandles();
			for (String wh : allwh) 
			{
				driver.switchTo().window(wh);
				
				String actualurl = driver.getCurrentUrl();
				if(actualurl.contains(url))
				{
					break;
				}
			}
		}
		public void windowhandletitle(WebDriver driver,String title)
		{
			Set<String> allwh = driver.getWindowHandles();
			for (String wh : allwh)
			{
				driver.switchTo().window(wh);
				String actualtitle = driver.getTitle();
				if(actualtitle.contains(title))
				{
					break;
				}
			}
		} 

		
//	public void switchNewBrowser(WebDriver driver) {
//		Set<String> allwh = driver.getWindowHandles();
//		for (String wh : allwh) {
//			driver.switchTo().window(wh);	
//		}	
//	}
	
	
}
