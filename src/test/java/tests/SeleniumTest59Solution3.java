package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest59Solution3
{
	public static void main(String[] args) throws Exception
	{
		//open browser
		FirefoxDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://www.goindigo.in/"); 
		Thread.sleep(10000);
		//Select Pseudo round trip radio button by clicking on neighbor <span> element
		driver.findElement(By.xpath("//span[@aria-label='roundTrip']")).click();
		Thread.sleep(5000);
		//Collect all radio buttons
		List<WebElement> neighbors=driver.findElements(By.xpath("//span[@role='radio']"));
		System.out.println(neighbors.size());
		//Get selected radio button's neighbor span
        for(WebElement neighbor:neighbors) {
            if (neighbor.isDisplayed()) {
                // Check if the radio button is selected
                String script="var after=window.getComputedStyle(arguments[0],'::after');" +
                                "return(after.getPropertyValue('opacity'));";
                String x=(String) driver.executeScript(script, neighbor);
                // If opacity is 1, the radio button is selected
                if("1".equals(x)) // if(x.equals("1"))
                {
                    // Get aria-label of the selected radio button's neighbor span
                    String ariaLabel = neighbor.getDomAttribute("aria-label");
                    System.out.println("Selected radio button aria-label: "+ariaLabel);
                }
            }
        }
		//Close site
		driver.quit();
	}
}
