package tests;

import org.openqa.selenium.edge.EdgeDriver;

public class GetWindowHandle10 
{
	public static void main(String[] args) throws Exception
	{
		//Open Edge browser
        EdgeDriver driver=new EdgeDriver();
        //Launch site using base URL
        driver.get("https://www.w3schools.com/html/html_intro.asp");
        Thread.sleep(5000);
        //Get Window handle
        String wh=driver.getWindowHandle();
        System.out.println(wh);
        //Close site
        driver.close();
	}
}
