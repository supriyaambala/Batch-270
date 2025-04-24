package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test82
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//launch site
		driver.get("http://www.facebook.com");
		Thread.sleep(5000);
		//Fill active element(EmailId)
		driver.switchTo().activeElement().sendKeys("abdulkalam",Keys.TAB);
		Thread.sleep(5000);
		//Fill active element(Password)
		driver.switchTo().activeElement().sendKeys("batch270",Keys.TAB, Keys.TAB);
		Thread.sleep(5000);
		//Click on active element
		driver.switchTo().activeElement().click(); 
	}
}

