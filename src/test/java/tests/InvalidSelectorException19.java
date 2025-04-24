package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvalidSelectorException19 
{
	public static void main(String[] args) throws Exception
	{
		//open browser
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_test");
		Thread.sleep(5000);
		//fill fields
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.name("fname")).sendKeys("abdul");
		driver.findElement(By.id("lname")).sendKeys("kalam");
		driver.findElement(By.xpath("//input[@value=Submit']")).click(); //single quote missing
		Thread.sleep(5000);
		//"InvalidSelectorException" in above statement because our xpath is in wrong syntax
	}
}
