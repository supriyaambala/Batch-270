package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest60
{
	public static void main(String[] args) throws Exception
	{
		//open chrome browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://my.aidaform.com/signup"); 
		Thread.sleep(5000);
		//Collect image type elements 
		List<WebElement> l=driver.findElements(By.xpath("(//img)|(//input[@type='image'])"));
		int count=0;
		for(WebElement e:l)
		{
			if(e.isDisplayed())
			{
				count++;
			}
		}
		System.out.println(count); //count is 0 because of pseudo elements for those images
		//close site
		driver.close();
	}
}






