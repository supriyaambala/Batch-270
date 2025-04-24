package tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class GetWindowHandles11 
{
	public static void main(String[] args) throws Exception
	{
		//Open Edge browser
        EdgeDriver driver=new EdgeDriver();
        //Launch site using base URL
        driver.get("https://www.w3schools.com/html/html_intro.asp");
        Thread.sleep(5000);
        //Click a button
        driver.findElement(By.linkText("Try it Yourself »")).click();
        Thread.sleep(5000);
        //Get Window handles of all browser windows and tabs on desktop
        Set<String> whs=driver.getWindowHandles();
        System.out.println(whs);
        //Close site
        driver.quit(); //Close all windows and tabs
	}
}
