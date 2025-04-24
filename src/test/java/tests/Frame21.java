package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame21 
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
		driver.findElement(By.xpath("//*[contains(@id,'name')]")).sendKeys("abdul",Keys.ENTER);
		driver.findElement(By.id("lname")).sendKeys("kalam");
		driver.findElement(By.xpath("//input[@value='Submit']")).click(); 
		Thread.sleep(5000);
		//In above code, "//*[contains(@id,'name')]" matches two elements in page source.
		//So, SWD runs given operation on 1st matched element by default.
	}
}
