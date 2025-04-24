package tests;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumTest28
{
	public static void main(String[] args) throws Exception
	{
		//open any browser
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Browser name");
		String bn=sc.nextLine();
		sc.close();
		RemoteWebDriver driver=null;
		if(bn.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(bn.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(bn.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("Wrong browser name");
			System.exit(0); //0 means forcibly
		}
		//Launch site
		driver.get("http://www.amazon.in");
		Thread.sleep(5000);
		//get count of all links in page source
		List<WebElement> l=driver.findElements(By.xpath("//a")); //"a" tag for links in HTML
		System.out.println(l.size());
		//Close site
		driver.quit();
	}
}
