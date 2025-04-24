package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test61
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
		Thread.sleep(5000);
		//switch to frame by using that frame's "id/name" as String.
		driver.switchTo().frame("iframeResult"); 
		//fill fields and submit 
		driver.findElement(By.name("fname")).clear(); //to remove existing value
		driver.findElement(By.name("fname")).sendKeys("abdul"); 
		Thread.sleep(5000);
		driver.findElement(By.name("lname")).clear(); //to remove existing value
		driver.findElement(By.name("lname")).sendKeys("kalam sir");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(3000);
		//back to page
		driver.switchTo().defaultContent(); 
		//Close site
		//driver.close();
	}
}
