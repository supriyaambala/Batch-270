package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;

public class Test77
{
	public static void main(String[] args) throws Exception
	{
		//try on this "https://selectorshub.com/xpath-practice-page/" site also for quick practice
		//Open chrome browser
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://selectorshub.com/shadow-dom-in-iframe/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Move mouse pointer to page body to get visibility of elements
		Actions act=new Actions(driver);
		act.moveToLocation(300,400).perform();
		Thread.sleep(5000);
		//switch to frame
		driver.switchTo().frame("pact");
		//target Element is inside a single shadow DOM
		WebElement shadowHostElement=driver.findElement(By.id("snacktime"));
		SearchContext shadowRootElement=shadowHostElement.getShadowRoot();
		WebElement targetElement=shadowRootElement.findElement(By.className("food"));
		try
        {
            targetElement.click();
            Thread.sleep(5000);
        }
        catch(JavascriptException ex)
        {
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", targetElement);
            Thread.sleep(5000);
        }
		//switch to newly opened window/tab
		Set<String> s=driver.getWindowHandles();
        List<String> l=new ArrayList<String>(s);
        driver.switchTo().window(l.get(1)); //switch to newly opened 2nd window/tab
        driver.findElement(By.xpath("(//a[text()='Courses'])[2]")).click();
		Thread.sleep(5000);
		List<WebElement> courses=driver.findElements(By.xpath(
			"(//span[contains(text(),'Watch on Udemy')])|(//span[contains(text(),'View on')])|(//span[contains(text(),'Online Live')])"));
		System.out.println(courses.size());
		//Close that 2nd browser window/tab
		driver.close();
		Thread.sleep(5000);
		//back to 1st window/tab from 2nd window/tab
        driver.switchTo().window(l.get(0)); 
        driver.close();
	}
}
