package miscellaneous_tasks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Redbus_calendar {

	@Test
	public void redbus_calendar() {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		
//		Date dobj= new Date();
//		System.out.println(dobj);
//		SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
//		String date = sdf.format(dobj);
//		System.out.println(date);
		driver.findElement(By.xpath("//span[text()='Date']")).click();
		driver.findElement(By.xpath("//span[text()='19']")).click();	
	}
	@Test
	public void irctc() {
		ChromeOptions opt= new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver= new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(22));
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElement(By.xpath("//p-calendar[@id='jDate']")).click();
		driver.findElement(By.xpath("//a[text()='18']")).click();
//		Date dobj=new Date();
//		SimpleDateFormat sobj= new SimpleDateFormat("dd/MM/yyyy");
//		sobj.format(dobj);
//		Calendar cal= sobj.getCalendar();
//		cal.add(Calendar.DAY_OF_MONTH, 2);
//		String reqdate=sobj.format(cal.getTime());
//		System.out.println(reqdate);
//		driver.findElement(By.xpath("//p-calendar[@id='jDate']")).clear();
//		driver.findElement(By.xpath("//p-calendar[@id='jDate']")).sendKeys(reqdate);
		
	}
	
	@Test
	public void makemytrip() {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		String monthadnYear="March 2025";
		int date=20;
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		WebElement ele = driver.findElement(By.xpath("//div[text()='"+monthadnYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']"));
		ele.click();
//		Actions act= new Actions(driver);
//		act.doubleClick(ele).perform();
	}
	@Test
	public void makemytrip_august() {
		ChromeOptions opt= new ChromeOptions();
		opt.addArguments("--disabled-notifications");
		String monthadnYear="August 2025";
		int date=20;
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		WebElement nextele=driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']"));
		while(true) {
		try {
			WebElement ele = driver.findElement(By.xpath("//div[text()='"+monthadnYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']"));
			ele.click();
		} catch (Exception e) {
			nextele.click();
		}
		driver.quit();
		}	
	}
	@Test
	public void airindia() {
		ChromeOptions opt= new ChromeOptions();
		opt.addArguments("--disable-notifications");
		String month =" March 2025 ";
		String date="Wednesday, March 19, 2025";
		String returndate ="Thursday, March 27, 2025";
		WebDriver driver= new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.airindia.com/");
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		driver.findElement(By.name("dpFrom")).click();
		WebElement ele = driver.findElement(By.xpath("//div[text()='"+month+"']/ancestor::div[@class='ngb-dp-month']/descendant::div[@aria-label='"+date+"']"));
		WebElement ele1 = driver.findElement(By.xpath("//div[text()='"+month+"']/ancestor::div[@class='ngb-dp-month']/descendant::div[@aria-label='"+returndate+"']"));
		ele.click();
		ele1.click();
		driver.findElement(By.xpath("//button[text()=' Confirm ']")).click();
	}
	
	@Test
	public void airindia_oneway() {
		ChromeOptions opt= new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver= new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.airindia.com/");
	}}

