package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.SearchContext;

public class Test72
{
	public static void main(String[] args) throws Exception
	{
		//open browser and maximize
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("http://www.efuma.com");
		Thread.sleep(10000);
		//close cookies banner if exists
		try
		{
			driver.findElement(By.xpath("//button[text()='Accept Cookies']")).click();
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			System.out.println("No cookies banner");
		}
		//close banner if exists
		Thread.sleep(5000); //wait for Banner
		try
		{
			//Step-1: locate shadow host
			WebElement shadowhost=driver.findElement(By.xpath(
					                      "//div[contains(@id,'popupsmart-container')]"));
			//Step-2: move to shadow root(open) from shadow host
			SearchContext shadowroot=shadowhost.getShadowRoot();
			//Step-3: Goto target element using any locator except XPath
			WebElement targetelement=
					 shadowroot.findElement(By.id("close-button-cqwl1eh44e80"));
			//step-3: operate target element
			targetelement.click();
			Thread.sleep(5000);
			//no separate code for exit from Shadow DOM, directly automate elements in rest of the page
		}
		catch(Exception e)
		{
			//do nothing
			System.out.println("No banner");
		}
		//close site
		//driver.quit();	
	}
}
