package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test67NestedFramesOtherSite
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://demoqa.com/nestedframes");
		Thread.sleep(5000);
		//Switch to Outer frame
		driver.switchTo().frame("frame1");
		//Switch to inner frame
		driver.switchTo().frame(0);
		String x=driver.findElement(By.tagName("p")).getText();
		System.out.println(x);
		//Back to Outer frame
		driver.switchTo().parentFrame();
		//Back to page
		driver.switchTo().parentFrame();
		//Close site
		driver.quit();
	}
}
