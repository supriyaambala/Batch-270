package tests;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest46
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
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Close banner if exist
		try
		{
			driver.findElement(By.xpath("//span[@role='button']")).click();
		}
		catch(Exception ex)
		{
			System.out.println("No banner exists");
		}
		//Search for a product
		driver.findElement(By.name("q")).sendKeys(pro);
		driver.findElement(By.xpath("//button[starts-with(@title,'Search for Products')]")).click();
		Thread.sleep(5000);
		//collect all results page by page
		int trc=0;
		int pn=2; //already we are in 1st page
		while(true) //infinite loop for pagination
		{
			//Collect results in current page
			List<WebElement> results=driver.findElements(By.xpath(
		                                              "//div[contains(@data-tkid,'SEARCH')]")); 
			int prc=results.size();
			trc=trc+prc; //add to total results count
			//click on next page number link to go to next page if exist
			try
			{
				String bc=driver.findElement(By.linkText(""+pn)).getCssValue("background");
				driver.findElement(By.linkText(""+pn)).click(); //convert "int" to "String"
				Thread.sleep(3000);
				String ac=driver.findElement(By.linkText(""+pn)).getCssValue("background");
				if(ac.equals(bc))
				{
					System.out.println("Last page number with results is "+(pn-1));
					break;
				}
				else
				{
					pn++;
				}
			}
			catch(Exception ex)
			{
			  break;  //terminate from loop when next page number disabled or not available
			}
		}
		System.out.println("count of all results in all pages is "+trc);
		//close site
		//driver.close();
	}
}
