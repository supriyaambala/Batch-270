package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test63
{
	public static void main(String[] args) throws Exception
	{
		//create "driver" object
		RemoteWebDriver	driver=new ChromeDriver();
		//Launch site
		driver.get(
		 "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_file");
		Thread.sleep(5000);
		//switch to frame
		WebElement fe=driver.findElement(By.xpath("//iframe[@name='iframeResult']"));
		driver.switchTo().frame(fe); //using element locator
		//file upload and submit
		driver.findElement(By.xpath("(//input[@type='file'])[1]"))
		                            .sendKeys("C:\\Users\\Hp\\Pictures\\Charminar-Feature.jpg");
		driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
		Thread.sleep(5000);
		//back to page level
		driver.switchTo().defaultContent(); 
		Thread.sleep(5000); 
	}
}



















