package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest56
{
	public static void main(String[] args) throws Exception
	{
		//open chrome browser
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://my.aidaform.com/signup"); 
		Thread.sleep(5000);
		//Note: Please observe DOM of corresponding page and identify tags used by DEV
		//Collect button type elements
		List<WebElement> bl=driver.findElements(By.xpath(
				"(//button)|(//input[@type='button' or @type='submit'])"));
		System.out.println("Total Buttons are "+bl.size());
		int vb=0, hb=0;
		for(WebElement b:bl)
		{
			if(b.isDisplayed()) //If a block of code has one line code, then curly braces are optional
				vb++;
			else
				hb++;
		}
		System.out.println("Visible Buttons are "+vb);
		System.out.println("Hidden Buttons are "+hb);
		//close site
		driver.quit();
	}
}






