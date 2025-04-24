package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FillFieldsWithData15 
{
	public static void main(String[] args) throws Exception
	{
		//Open Chrome browser
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(5000);
		//Launch google site
		driver.get("https://my.aidaform.com/signup");
		Thread.sleep(5000);
		//Fill fields with data
		driver.findElement(By.name("nickname")).sendKeys("batch270");
		driver.findElement(By.name("email")).sendKeys("apj@abdulkalam.com");
		driver.findElement(By.name("password")).sendKeys("Batch@270");
		driver.findElement(By.name("confirm")).sendKeys("Batch@270");
		driver.findElement(By.xpath("(//*[local-name()='svg'])[4]")).click();
		//driver.findElement(By.xpath("(//*[name()='svg'])[4]")).click(); 

		driver.findElement(By.xpath("//button[text()='Create My Free Account']")).click();
	  //  driver.findElement(By.xpath("//*[@type='submit']")).click();

	}

}
