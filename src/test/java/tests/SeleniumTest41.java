package tests;


import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest41
{
	public static void main(String[] args) throws Exception
	{
		//Get product type to search from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter product type to search");
		String pro=sc.nextLine();
		sc.close();
		//open browser
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Search for a product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(pro);
		driver.findElement(By.xpath("//input[@value='Go']")).click();
		Thread.sleep(5000);
		//collect all results in page source
		List<WebElement> results=driver.findElements(By.xpath(
	                                        "//div[@data-component-type='s-search-result']"));  
		System.out.println("Count of all results in first page is "+results.size());
		//Goto each result and collect price value
		int vc=0;
		for(WebElement result:results)
		{
			if(result.isDisplayed())
			{
				vc++;
				//Highlight Price element in result element if exist
				try 
				{
					WebElement price=result.findElement(
						            By.xpath("descendant::span[@class='a-price-whole']"));
					driver.executeScript("arguments[0].style.border='2px blue solid';", price);
				}
				catch(Exception ex) //To avoid exception for results which does not have Price
				{
				}
				//Highlight result
				driver.executeScript("arguments[0].style.border='2px red dotted';", result);
			}
		}
		System.out.println("prices of visible results in first page is "+vc);
		//close site
		//driver.close();
	}
}
