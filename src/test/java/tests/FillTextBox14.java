package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FillTextBox14 
{
	public static void main(String[] args) throws Exception
	{
		//Open Chrome browser
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(5000);
		//Launch google site
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		//Fill a text box with some text
		By obj=By.name("q");
		driver.findElement(obj).sendKeys("abdul kalam sir");
	}

}
