package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest32
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
		//2. Goto each image in that list and highlight visible images
		for(WebElement image:images)  //for each loop
		{
			if(image.isDisplayed()) 
			{
				driver.executeScript("arguments[0].style.border='5px yellow solid';",image);
			}
		}
		//close site
		//driver.quit();
	}
}
