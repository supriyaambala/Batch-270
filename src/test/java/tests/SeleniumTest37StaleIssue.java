package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class SeleniumTest37StaleIssue
{
	public static void main(String[] args) throws Exception
    {
        //Get product type to search from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter product type to search");
		String pro=sc.nextLine();
		sc.close();
		//open browser
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.amazon.in");
		Thread.sleep(5000);
		//Search for a product
		driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']")).sendKeys(pro);
		driver.findElement(By.xpath("//input[@value='Go']")).click();
		Thread.sleep(5000);
        // 1. Get all elements on the page
        List<WebElement> allelements=driver.findElements(By.xpath("//*"));
        System.out.println("Total count of elements is "+allelements.size());
        // 2. Goto each element and take "href" attribute value
        int hyperlinkscount=0;
        int brokenlinkscount=0;
        int workinglinkscount=0;
        for(WebElement element:allelements) 
        {
        	String linkUrl=element.getDomAttribute("href");
            if(linkUrl!=null && !linkUrl.isEmpty()) //every element is not having "href" attribute
            {
            	if(linkUrl.startsWith("http") || linkUrl.startsWith("https"))
            	{
            		hyperlinkscount++; //increment by 1
            		try 
            		{
            			URI uri = new URI(linkUrl);
                        URL url = uri.toURL();
            			HttpURLConnection con=(HttpURLConnection) url.openConnection();
            			con.setRequestMethod("HEAD");
            			con.connect();
            			int resCode=con.getResponseCode();
            			if(resCode>=400) 
            			{
            				System.out.println(linkUrl + " is a broken link due to "+resCode);
            				brokenlinkscount++;
            				if(element.isDisplayed())
            				{
            					((JavascriptExecutor) driver).executeScript(
            							"arguments[0].style.border='2px green solid';",element);
            				}
            			} 
            			else 
            			{
            				workinglinkscount++;
            			}
            		} 
            		catch(Exception e) //Handle any Network issue raised while connecting
            		{
            			System.out.println(linkUrl+" is a broken link due to "+e.getMessage());
        				brokenlinkscount++;
        				if(element.isDisplayed())
        				{
        					((JavascriptExecutor) driver).executeScript(
        							"arguments[0].style.border='2px green solid';",element);
        				}
            		}
            	}
            }
        }
        System.out.println("Total count of hyper links is "+hyperlinkscount);
        System.out.println("Total count of broken links is "+brokenlinkscount);
        System.out.println("Total count of working links is "+workinglinkscount);
        // Close the browser
        //driver.quit();
    }
}