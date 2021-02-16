package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonOtpautomation 
{
	@Test
	public void method() throws Exception
	{
		//open browset(SWD)
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("http://www.amazon.co.in");
		Thread.sleep(5000);
		//go to Registration(SWD)
		
		WebElement e=driver.findElement(By.xpath("//span[text()='Account & Lists']"));
		Actions a=new Actions(driver);
		a.moveToElement(e).perform();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Start here.")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("customerName")).sendKeys("sairam123");
		driver.findElement(By.className("a-dropdown-prompt")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("United States +1")).click();////iframe[contains(@title,'notification-frame')
		driver.findElement(By.id("ap_phone_number")).sendKeys("4049486555");
		driver.findElement(By.name("password")).sendKeys("Ressha");
		driver.findElement(By.id("continue")).click();
		Thread.sleep(50000);
		String suid="ACa5ae9f83835dc30173012e6588b69a1c";
		String auth="d18826fa0ae4df3c9235ea5b47d188ad";
		Twilio.init(suid,auth);
		ResourceSet<Message> ms=Message.reader().read();
		String temp=ms.iterator().next().getBody();
		String[] pieces=temp.split(" ");
		String otp=pieces[0];
		driver.findElement(By.id("auth-pv-enter-code")).sendKeys(otp);
	
		
	}

}
