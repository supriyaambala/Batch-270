package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test74
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site and close banner
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(5000);
		try
		{
			driver.findElement(By.xpath("//img[@title='Close']")).click();
		}
		catch(Exception ex)
		{
			System.out.println("No banner");
		}
		//Move mouse pointer to page body to render target elements
		Actions act=new Actions(driver);
		act.moveToLocation(300,400).perform();
		//target UserID Element is inside a single shadow DOM(Open)
		WebElement host1=driver.findElement(By.id("userName"));
		SearchContext root1=host1.getShadowRoot();
		WebElement targetUid=root1.findElement(By.cssSelector("#kils"));
		targetUid.sendKeys("user123"); 
		Thread.sleep(5000);
		//target Password Element is inside a single shadow DOM(closed)
		//Use indirect automation using keyboard to fill target element under a "closed" Shadow DOM
		for(int i=1;i<=5;i++)
		{
			act.sendKeys(Keys.TAB).perform();
			Thread.sleep(2000);
		}
		act.sendKeys("kalam@sir").perform(); 
		//no separate code for exit from Shadow DOM, directly automate elements in rest of the page
	}
}
