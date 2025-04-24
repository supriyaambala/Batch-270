package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;

public class Test75
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://selectorshub.com/shadow-dom-in-iframe/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Move mouse pointer to page location to get visibility of elements
		Actions act=new Actions(driver);
		act.moveToLocation(300,400).perform();
		Thread.sleep(5000);
		//switch to frame
		driver.switchTo().frame("pact");
		//target Element is inside a single shadow DOM(open)
		WebElement shadowHostElement=driver.findElement(By.id("snacktime"));
		SearchContext shadowRootElement=shadowHostElement.getShadowRoot();
		WebElement targetElement=shadowRootElement.findElement(By.className("food"));
		//Handle click on target element
		try
		{
			targetElement.click();
		}
		catch(Exception ex)
		{
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", targetElement);
		}
		//no separate code for exit from Shadow DOM, directly automate elements in rest of the page
		//Back to page
		driver.switchTo().defaultContent();
	}
}
