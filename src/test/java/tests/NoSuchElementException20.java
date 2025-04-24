package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NoSuchElementException20
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
		driver.findElement(By.xpath("//input[@value='submit']")).click(); //lower case "submit"
		Thread.sleep(5000);
		//"NoSuchElementException" in above statement because our element's value is "Submit"
	}
}
