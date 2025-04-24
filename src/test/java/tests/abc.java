package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class abc
{
	public static void main(String[] args) throws Exception
	{
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.google.com/");
		driver.findElement(By.id='input').sendKeys("Hi");
		driver.close();
		
	}
	
	
	
}