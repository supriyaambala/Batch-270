package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest30
{
	public static void main(String[] args) throws Exception
	{
		//open browser
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//1. collect all images from page source
		List<WebElement> images=driver.findElements(By.xpath("//img")); 
		//2. Goto each image in that list and check for it is visible in page or not
		int vc=0, hc=0;
		for(WebElement image:images)  //for each loop
		{
			if(image.isDisplayed()) 
			{
				vc++; //increase by 1
			}
			else
			{
				hc++;
			}
		}
		System.out.println("Total images count is "+images.size());
		System.out.println("Visible images count is "+vc);
		System.out.println("hidden images count is "+hc);
		//close site
		//driver.quit();
	}
}
