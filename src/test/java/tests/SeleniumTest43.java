package tests;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest43
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
		//Note: If any captcha like unwanted verification, increase wait time and handle manually
		//Search for a product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(pro);
		driver.findElement(By.xpath("//input[@value='Go']")).click();
		Thread.sleep(5000);
		//collect all results page by page
		int trc=0;
		int pn=2; //already we are in 1st page
		while(true) //infinite loop for pagination
		{
			//Collect results in current page
			List<WebElement> results=driver.findElements(By.xpath(
                                            "//div[@data-component-type='s-search-result']")); 
			int prc=0;
			for(WebElement result:results)
			{
				if(result.isDisplayed())
				{
					prc++;
				}
			}
			System.out.println(prc);
			trc=trc+prc; //add to total results count
			//click on next page number link to go to next page if exist
			try
			{
			  driver.findElement(By.xpath("//a[@aria-label='Go to page "+pn+"']")).click();
			  Thread.sleep(3000);
			  pn++;
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
