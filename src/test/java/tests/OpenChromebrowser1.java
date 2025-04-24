package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.chromium.ChromiumDriver;

public class OpenChromebrowser1

{
	public static void main(String[] args)
	{
		//Open chrome browser
		ChromeDriver driver=new ChromeDriver(); //Create an object to class using same class's constructor
		//SearchContext driver=new ChromeDriver();//Create an object to interface using concrete class's constructor
		//WebDriver driver=new ChromeDriver(); //Create an object to interface using concrete class's constructor
		//ChromiumDriver driver=new ChromeDriver();//Create an object to class using child class's constructor
		//RemoteWebDriver driver=new ChromeDriver();//Create an object to class using child class's constructor
	}
}
