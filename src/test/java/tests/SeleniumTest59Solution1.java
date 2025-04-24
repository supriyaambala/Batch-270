package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest59Solution1
{
	public static void main(String[] args) throws Exception
	{
		//open browser
		FirefoxDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://www.goindigo.in/"); 
		Thread.sleep(10000);
		//Collect all neighbors to our targeted Pseudo radio buttons
		List<WebElement> neighbors=driver.findElements(By.xpath("//span[@role='radio']"));
		System.out.println(neighbors.size());
		//Get count of visible neighbors to our targeted Pseudo radio buttons
        int count = 0;
        for(WebElement neighbor:neighbors) 
        {
        	if(neighbor.isDisplayed())
        	{
        		//Check for the presence of the ::after pseudo-element by returning the after object
                String script="var after=window.getComputedStyle(arguments[0],'::after');" +
                              "return(after);";
                Object afterObject=driver.executeScript(script, neighbor);
                // Check if the after object has any styles applied
                if(afterObject!=null && !afterObject.toString().isEmpty()) {
                    count++;
        		}
            }
        }
        System.out.println("Count of radio buttons with ::after pseudo-element: " + count);
		//Close site
		driver.quit();
	}
}
