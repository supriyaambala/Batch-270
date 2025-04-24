package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;

public class SeleniumTest39StaleIssueSolution2 
{
    public static void main(String[] args) throws Exception
    {
        // Open browser
        WebDriver driver = new ChromeDriver();
        // Launch site
        driver.get("https://www.amazon.in"); 
        Thread.sleep(5000);
        // 1. Get all elements on the page
        List<WebElement> allelements = driver.findElements(By.xpath("//*"));
        // 2. Go to each element and take "href" attribute value
        int allhyperlinks=0;
        int validlinks=0;
        int brokenlinks=0;
        int staledelements=0;
        for(int i=0; i<allelements.size(); i++) 
        {
            try //To handle StaleElementReferenceException"
            {
            	WebElement element = allelements.get(i);
                String linkUrl = element.getDomAttribute("href");
                if (linkUrl != null && !linkUrl.isEmpty()) // every element is not having "href" attribute
                {
                    if (linkUrl.startsWith("http") || linkUrl.startsWith("https")) 
                    {
                    	allhyperlinks++;
                        try 
                        {
                            URI uri = new URI(linkUrl); // consider "href" value as a resource address
                            URL url = uri.toURL(); // consider that address as URL to connect
                            HttpURLConnection con = (HttpURLConnection) url.openConnection();
                            con.setRequestMethod("HEAD");
                            con.connect(); // submit a request to given URL server via HEAD method
                            Thread.sleep(1000);
                            int resCode = con.getResponseCode();
                            if (resCode >= 400) 
                            {
                                System.out.println(linkUrl + " is a broken link due to " + resCode);
                                brokenlinks++;
                            } 
                            else 
                            {
                                System.out.println(linkUrl + " is a valid link.");
                                validlinks++;
                            }
                        } 
                        catch (Exception ex) 
                        {
                            System.out.println(linkUrl + " is a broken link due to " + ex.getMessage());
                            brokenlinks++;
                        }
                    }
                }
            } catch (Exception e) {
            	staledelements++;
                // If element becomes stale, re-fetch the list of elements and continue
                allelements = driver.findElements(By.xpath("//*"));
                i--; //Decrement the index to re-process the same element
            }
        }
        System.out.println("All elements count is "+allelements.size());
        System.out.println("Staled elements count is "+staledelements);
        System.out.println("All Hyper links count is "+allhyperlinks);
        System.out.println("Valid links count is "+validlinks);
        System.out.println("Broken links count is "+brokenlinks);
        // Close the browser
        driver.quit();
    }
}
