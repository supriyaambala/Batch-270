package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest31
{
	public static void main(String[] args) throws Exception
	{
		//open browser
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.amazon.in");
		Thread.sleep(5000);
		//collect all images
		List<WebElement> images=driver.findElements(By.xpath("//img")); 
		//Goto each image in that list
		int index=0;
		for(WebElement image:images)
		{
			if(image.isDisplayed())
			{
				index++;
				System.out.println(index+")."+image.getDomAttribute("src"));
			}
		}
		//close site
		driver.close();
	}
}
