package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest53
{
	public static void main(String[] args) throws Exception
	{
		//open chrome browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://my.aidaform.com/signup"); 
		Thread.sleep(5000);
		//Segregate various types of <input> tag elements
		List<WebElement> l=driver.findElements(By.tagName("input"));
		System.out.println(l.size());
		for(WebElement e:l)
		{
			String x=e.getDomAttribute("type");
			System.out.println(x);
		}
		//close site
		driver.quit();
	}
}






