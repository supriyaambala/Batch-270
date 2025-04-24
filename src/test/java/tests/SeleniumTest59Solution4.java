package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest59Solution4
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
		//Get CSS details(background, color, border-color, opacity) of Pseudo elements
        for(WebElement neighbor:neighbors) {
            if (neighbor.isDisplayed()) {
                // Check if the radio button is selected
                String script1="var after=window.getComputedStyle(arguments[0],'::after');" +
                                "return(after.getPropertyValue('background'));";
                String x=(String) ((JavascriptExecutor) driver).executeScript(script1, neighbor);
                System.out.println("Radio button background is: "+x);
                
                String script2="var after=window.getComputedStyle(arguments[0],'::after');" +
                               "return(after.getPropertyValue('color'));";
                String y=(String) ((JavascriptExecutor) driver).executeScript(script2, neighbor);
                System.out.println("Radio button color is: "+y);
                
                String script3="var after=window.getComputedStyle(arguments[0],'::after');" +
                				"return(after.getPropertyValue('border-color'));";
                String z=(String) ((JavascriptExecutor) driver).executeScript(script3, neighbor);
                System.out.println("Radio button border-color is: "+z);
                
                String script4="var after=window.getComputedStyle(arguments[0],'::after');" +
                				"return(after.getPropertyValue('opacity'));";
                String w=(String) ((JavascriptExecutor) driver).executeScript(script4, neighbor);
                System.out.println("Radio button opacity is: "+w);
            }
        }
		//Close site
		driver.quit();
	}
}
