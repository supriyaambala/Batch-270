package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;

public class SeleniumTest36
{
	public static void main(String[] args) throws Exception
    {
        // Open browser
		ChromeDriver driver=new ChromeDriver();
        //Launch Site
        driver.get("https://www.google.co.in"); 
        Thread.sleep(5000);
        // 1. Get all elements on the page
        List<WebElement> allelements=driver.findElements(By.xpath("//*"));
        // 2. Goto each element and take "href" attribute value
        for(WebElement element:allelements) 
        {
        	String linkUrl=element.getAttribute("href");
        	if(linkUrl!=null && !linkUrl.isEmpty()) //every element is not having "href" attribute
        	{
        		if(linkUrl.startsWith("http") || linkUrl.startsWith("https"))
        		{
        			try 
        			{
        				URI uri=new URI(linkUrl); //consider "href" value as a resource address
        				URL url=uri.toURL(); //consider that address as URL to connect
        				HttpURLConnection con=(HttpURLConnection) url.openConnection();
        				con.setRequestMethod("HEAD");
        				con.connect(); //submit a request to given URL server via HEAD method
        				Thread.sleep(1000);
        				int resCode=con.getResponseCode();
            			if(resCode>=400) {
            				System.out.println(linkUrl + " is a broken link due to "+resCode);
            			} 
            			else
            			{
            				System.out.println(linkUrl + " is a valid link.");
            			}
            		} 
            		catch(Exception ex) 
            		{
            			System.out.println(linkUrl + " is a broken link due to "+ex.getMessage());
            		}
            	}
            }
        }
        // Close the browser
        driver.quit();
    }
}