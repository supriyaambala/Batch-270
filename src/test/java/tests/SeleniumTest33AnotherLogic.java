package tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest33AnotherLogic
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
		List<WebElement> allimages=driver.findElements(By.xpath("//img")); 
		//2. Goto each image in that list and collect visible images only into another list
		List<WebElement> vimages=new ArrayList<WebElement>();
		for(WebElement image:allimages)  //for each loop
		{
			if(image.isDisplayed()) 
			{
				vimages.add(image);
			}
		}
		//3. Highlight each image in visible images list
		for(WebElement image:vimages)  //for each loop
		{
			driver.executeScript("arguments[0].style.border='3px red dotted';", image);
		}
		//close site
		//driver.quit();
	}
}
