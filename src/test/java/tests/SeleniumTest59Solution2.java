package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest59Solution2
{
	public static void main(String[] args) throws Exception
	{
		//open browser
		FirefoxDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://www.goindigo.in/"); 
		Thread.sleep(5000);
		//Collect all radio buttons
		List<WebElement> neighbors=driver.findElements(By.xpath("//span[@role='radio']"));
		System.out.println(neighbors.size());
		//Get selected radio button's neighbor span
        for (WebElement neighbor:neighbors) 
        {
            if(neighbor.isDisplayed()) 
            {
                // Check if the radio button is selected
                String script="var after = window.getComputedStyle(arguments[0],'::after');" +
                                "return(after.getPropertyValue('opacity'));";
                String temp=(String)driver.executeScript(script,neighbor);
                int x=Integer.parseInt(temp); //Convert String to int
                // If opacity is 1, the radio button is selected
                if(x==1) 
                {
                    // Get aria-label of the selected radio button's neighbor span
                    String y=neighbor.getDomAttribute("aria-label");
                    System.out.println("Selected radio button aria-label: "+y);
                }
            }
        }
		//Close site
		driver.quit();
	}
}
