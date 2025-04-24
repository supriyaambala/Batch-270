package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest57
{
	public static void main(String[] args) throws Exception
	{
		//open chrome browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://my.aidaform.com/signup"); 
		Thread.sleep(5000);
		//Note: Please observe DOM of corresponding page manually and identify tags used by DEV
		//Collect link type elements
		List<WebElement> l=driver.findElements(By.xpath("(//a)|(//link)"));
		System.out.println(l.size());
		//close site
		driver.quit();
	}
}






