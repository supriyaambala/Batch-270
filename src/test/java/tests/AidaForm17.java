package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AidaForm17{
	public static void main(String args[]) throws Exception
	{
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://my.aidaform.com/signup");
	driver.findElement(By.name("nickname")).sendKeys("Snigdha");
	Thread.sleep(3000);
	driver.findElement(By.name("email")).sendKeys("s@gmail.com");
	driver.findElement(By.name("password")).sendKeys("SSSSSS");
	driver.findElement(By.name("confirm")).sendKeys("SSSSSS");
	driver.findElement(By.xpath("(//*[name()='svg'])[4]")).click();
	//driver.findElement(By.xpath("(//*[name()='svg'])[4]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@type='submit']")).click();
	
	}
}