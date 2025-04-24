package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test64
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
		Thread.sleep(5000);
		//switch to frame using wrong index or wrong id/name or wrong element locator
		WebElement e=driver.findElement(By.id("menuOverlay")); //element found
		driver.switchTo().frame(e); //but that element is not a frame 
		//"NoSuchFrameException" for wrong index/id/name/xpath/...etc
	}
}




