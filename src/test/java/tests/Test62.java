package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test62
{
	public static void main(String[] args) throws Exception
	{
		//open chrome browser
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://the-internet.herokuapp.com/iframe"); 
		Thread.sleep(5000);
		//switch to frame by using that frame's index as Integer.
		driver.switchTo().frame(0); //frame index
		//get visible text in a frame
		String x=driver.findElement(By.tagName("p")).getText();
		System.out.println(x);
		//back to page
		driver.switchTo().defaultContent();
		//close site
		driver.quit();
	}
}






