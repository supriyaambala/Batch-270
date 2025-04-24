package tests;


import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumTest44
{
	public static void main(String[] args) throws Exception
	{
		//Get product type to search from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter browser name");
		String bn=sc.nextLine();
		System.out.println("Enter product type to search");
		String pro=sc.nextLine();
		sc.close();
		//open specified browser
		//WebDriver driver; //able to call 13 methods on any browser
		RemoteWebDriver driver=null; //able to call 13+ methods on any browser
		if(bn.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(bn.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(bn.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("Wrong browser name");
			System.exit(0); //0 means forcibly
		}
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://www.flipkart.com");
		Thread.sleep(5000);
		//Close login banner if exist
		try
		{
			driver.findElement(By.xpath("//span[@role='button']")).click();
		}
		catch(Exception ex)
		{
			System.out.println("No banner exists");
		}
		//Search for a product
		driver.findElement(By.name("q")).sendKeys(pro, Keys.ENTER);
		Thread.sleep(5000);
		//collect all results in 1st page
		List<WebElement> results=driver.findElements(By.xpath(
  "(//div[contains(@data-tkid,'SEARCH')])|(//div[contains(@data-tkid,'ADVIEW')]/ancestor::div[1])")); 
		for(WebElement result:results)
		{
			driver.executeScript("arguments[0].style.border='2px red dotted';", result);
		}
		System.out.println("count of all results in 1st page is "+results.size());
		//close site
		//driver.close();
	}
}
