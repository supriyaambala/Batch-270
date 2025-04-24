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

public class SeleniumTest48
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
		//collect all results page by page
		int trc=0;
		while(true) //infinite loop for pagination
		{
			//Collect results in current page
			List<WebElement> results=driver.findElements(By.xpath(
  "(//div[contains(@data-tkid,'SEARCH')])|(//div[contains(@data-tkid,'ADVIEW')]/ancestor::div[1])")); 
			int cprc=results.size();
			trc=trc+cprc; //add to total results count
			//click on "Next" link to go to next page if exist
			try
			{
				String msg1=driver.findElement(By.xpath("//a[text()='Home']/following::span[1]")).getText();
				driver.findElement(By.xpath("//span[text()='Next']/parent::a")).click();
				Thread.sleep(3000);
				String msg2=driver.findElement(By.xpath("//a[text()='Home']/following::span[1]")).getText();
				if(msg1.equals(msg2))
				{
					break;
				}
			}
			catch(Exception ex)
			{
			  break;  //terminate from loop when next link disabled or not available
			}
		}
		System.out.println("count of all results in all pages is "+trc);
		//close site
		//driver.close();
	}
}
