package tests;

import java.util.Scanner;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GetUrl5
{
	public static void main(String[] args)
	{
		//1. Take browser name from keyboard
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter browser name");
        String bn=sc.nextLine();
        System.out.println("Enter site url");
        String url=sc.nextLine();
        sc.close();
        //2. Cross Browser
        RemoteWebDriver driver=null; //declare
        if(bn.equalsIgnoreCase("chrome"))
        {
        	driver=new ChromeDriver(); //define
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
        } 
        //3. Launch site
        driver.get(url);
        
        System.out.println("This is my first change");
	}
}
