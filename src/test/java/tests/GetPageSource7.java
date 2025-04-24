package tests;

import org.openqa.selenium.chrome.ChromeDriver;

public class GetPageSource7 
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(3000);
		//Launch site
		driver.get("http://www.facebook.com");
		Thread.sleep(3000);
		//get page source
		String p=driver.getPageSource();
		System.out.println("Page source is "+p);
		//close site
		driver.close();
	}
}
