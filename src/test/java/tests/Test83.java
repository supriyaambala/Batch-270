package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test83
{
	public static void main(String[] args) throws Exception
	{
		//Open initial browser window 
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch google site
		driver.get("https://www.google.co.in");
		Thread.sleep(5000);
		//Create new tab
		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(5000);
		//Collect window handle values(strings) of those browser windows/tabs, switch to new tab(2nd)
		Set<String> s=driver.getWindowHandles(); //sequential set
		List<String> a=new ArrayList<String>(s); //random list
		driver.switchTo().window(a.get(1));
		//Launch gmail site
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		//Create new window
		driver.switchTo().newWindow(WindowType.WINDOW);
		//Recollect window handle values of those browser windows/tabs,switch to new window(3rd) 
		s=driver.getWindowHandles(); //sequential set
		a=new ArrayList<String>(s); //random list
		driver.switchTo().window(a.get(2));
		//Launch yahoo site
		driver.get("http://www.yahoomail.com");
		Thread.sleep(5000);
		//close all windows/tabs
		//driver.quit();
	}
}
