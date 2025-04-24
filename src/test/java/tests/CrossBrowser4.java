package tests;

import java.util.Scanner;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CrossBrowser4
{
	public static void main(String[] args)
	{
		//1. Take browser name from keyboard
        Scanner sc=new Scanner(System.in); //System.in indicates keyboard
        System.out.println("Enter browser name");
        String bn=sc.nextLine();
        sc.close();
        //Cross Browser
        //SearchContext driver=null; //declare
        //WebDriver driver=null; //declare
        RemoteWebDriver driver=null; //declare
        if(bn.equalsIgnoreCase("chrome"))
        {
        	driver=new ChromeDriver(); //define object using ChromeDriver() constructor
        }
        else if(bn.equalsIgnoreCase("firefox"))
        {
        	driver=new FirefoxDriver(); //define object using FirefoxDriver() constructor
        }
        else if(bn.equalsIgnoreCase("edge"))
        {
        	driver=new EdgeDriver(); //define object using EdgeDriver() constructor
        }
        else
        {
        	System.out.println("Wrong browser name");
        }  
	}
}





