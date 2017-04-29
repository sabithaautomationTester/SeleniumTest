package module1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendSms {

	public WebDriver  driver;
	
	// launching the site
	public void launch()
	{

		
		System.setProperty("webdriver.chrome.driver", "E:\\shiva\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://site24.way2sms.com/content/index.html?");
		
	}
	
	
	// login in to the site
	
	public void login()
	{
		driver.findElement(By.id("username")).sendKeys("9553317154");
		driver.findElement(By.id("password")).sendKeys("2955");
		driver.findElement(By.id("loginBTN")).click();
		
		
	}
	
	// send the sms
	
	public void sendSms()
	{
		driver.findElement(By.xpath("//input[@value='Send Free SMS']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//div[@id='smsMENU']/descendant::a[1])")).click();
		
		// counting frames
		
		List<WebElement> l=driver.findElements(By.tagName("iframe"));
		int x = l.size();
		System.out.print(x);
	
		
		
		
		driver.switchTo().frame("frame");
		driver.findElement(By.id("mobile")).sendKeys("8297939229");
		driver.findElement(By.id("message")).sendKeys("its raining");
		
		
		driver.findElement(By.id("Send")).click();
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		SendSms sms = new SendSms();
		
		sms.launch();
		Thread.sleep(5000);
		
		sms.login();
		
		Thread.sleep(5000);

		sms.sendSms();
	}

}
