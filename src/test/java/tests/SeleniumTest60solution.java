package tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest60solution
{
	public static void main(String[] args) throws Exception
	{
		//open chrome browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://my.aidaform.com/signup"); 
		Thread.sleep(5000);
		//Collect image type elements when they are Pseudo elements
		List<WebElement> l1=driver.findElements(By.xpath("//*"));
		List<WebElement> l2=new ArrayList<WebElement>();
		for(WebElement e:l1)
		{
			if(e.getCssValue("background-image").contains("url"))
			{
				l2.add(e);
			}
		}
		System.out.println(l2.size());
		//close site
		driver.close();
	}
}






