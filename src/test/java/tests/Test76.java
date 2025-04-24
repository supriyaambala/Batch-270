package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test76
{
	public static void main(String[] args) throws Exception
	{
		//open "chrome" browser 
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site using URL
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		Thread.sleep(5000);
		//switch to frame and click on a button to get a web alert
		driver.switchTo().frame("iframeResult"); 
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Thread.sleep(5000);
		//switch to alert
		Alert al=driver.switchTo().alert();
		String x=al.getText(); //get visible text in that alert
		System.out.println(x);
		al.accept(); //close alert(Here, "driver" will back to frame by default)
		Thread.sleep(5000);
		//back to page from frame
		driver.switchTo().defaultContent(); 
		//close site
		driver.close();
	}
}



















