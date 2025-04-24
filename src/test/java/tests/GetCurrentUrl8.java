package tests;

import java.util.Scanner;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GetCurrentUrl8 
{
	public static void main(String[] args) throws Exception
	{
		//1. Take browser name from keyboard
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter browser name");
        String bn=sc.nextLine();
        sc.close();
        //Cross Browser
        //SearchContext driver=null; //declare
        //WebDriver driver=null; //declare
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
        //Launch site using base URL
        driver.get("http://www.facebook.com/");
        Thread.sleep(5000);
        //Get current URL of the page
        String x=driver.getCurrentUrl();
        if(x.startsWith("https"))
        {
            System.out.println("Secured site");
        }
        else
        {
            System.out.println("Not secured site");
        }
        //Close site
        driver.close();
	}
}
