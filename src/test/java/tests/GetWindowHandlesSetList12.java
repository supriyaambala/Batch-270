package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class GetWindowHandlesSetList12 
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
        //1. Get Window handles of all browser windows and tabs on desktop
        Set<String> whs=driver.getWindowHandles();
        //2. Convert that set of values into a list
        List<String> l=new ArrayList<String>(whs);
        //3. switch to 2nd window/tab using corresponding window handle in list
        driver.switchTo().window(l.get(1)); 
        //4. Close that 2nd window/tab
        driver.close(); 
	}
}





