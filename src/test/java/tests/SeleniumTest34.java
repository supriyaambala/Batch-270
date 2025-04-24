package tests;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest34
{
	public static void main(String[] args) throws Exception
	{
		//open browser
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//1. collect all elements from page source
		List<WebElement> ae=driver.findElements(By.xpath("//*")); 
		//2. Goto each element in that list and get bgcolor and color of that element
		Set<String> colors=new HashSet<String>(); //to store unique values(without duplicate)
		for(WebElement e:ae)  //for each loop
		{
			String bgcolor = e.getCssValue("background-color");
            String elementcolor = e.getCssValue("color");
            colors.add(bgcolor);
            colors.add(elementcolor);
		}
		System.out.println(colors.size());
		System.out.println(colors);
		//close site
		driver.quit();
	}
}
