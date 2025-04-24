package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;

public class SeleniumTest36StaleIssue
{
	public static void main(String[] args) throws Exception
    {
        //1. Open browser
		ChromeDriver driver=new ChromeDriver();
        //2. Launch Site
        driver.get("https://www.google.co.in"); 
        driver.manage().window().maximize();
        Thread.sleep(5000);
        //3. Get all elements on the page
        List<WebElement> allelements=driver.findElements(By.xpath("//*"));
        //4. Goto each element and take "href" attribute value
        int alllinks=0;
        int validlinks=0;
        int brokenlinks=0;
        for(WebElement element:allelements) 
        {
        	String linkUrl=element.getDomAttribute("href");
        	if(linkUrl!=null && !linkUrl.isEmpty()) //every element is not having "href" attribute
        	{
        		if(linkUrl.startsWith("http") || linkUrl.startsWith("https"))
        		{
        			alllinks++;
        			//5. Check that URL for either valid or broken
        			try 
        			{
        				URI uri=new URI(linkUrl); //consider "href" value as a resource address
        				URL url=uri.toURL(); //consider that address as URL of a server to connect
        				HttpURLConnection con= (HttpURLConnection) url.openConnection();
        				con.setRequestMethod("HEAD");
        				con.connect(); //submit a request to given URL server via HEAD method
        				Thread.sleep(1000);
        				int resCode=con.getResponseCode();
            			if(resCode>=400) {
            				System.out.println(linkUrl + " is a broken link due to "+resCode);
            				brokenlinks++;
            			} 
            			else
            			{
            				System.out.println(linkUrl + " is a valid link.");
            				validlinks++;
            			}
            		} 
            		catch(Exception ex) //Handle any Network issue raised while connecting
            		{
            			System.out.println(linkUrl + " is a broken link due to "+ex.getMessage());
            		}
            	}
            }
        }
        System.out.println("All Hyper links count is "+alllinks);
        System.out.println("Valid links count is "+validlinks);
        System.out.println("Broken links count is "+brokenlinks);
        // Close the browser
        driver.quit();
    }
}