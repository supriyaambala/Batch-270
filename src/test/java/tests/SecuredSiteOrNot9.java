package tests;

import org.openqa.selenium.edge.EdgeDriver;

public class SecuredSiteOrNot9 
{
	public static void main(String[] args) throws Exception
	{
		//Open Edge browser
        EdgeDriver driver=new EdgeDriver();
        //Launch site using base URL
        driver.get("http://httpforever.com/");
        Thread.sleep(5000);
        //Get current URL of the page
        String x=driver.getCurrentUrl();
        if(x.startsWith("https"))
        {
            System.out.println("Secured site");
        }
        else
        {
            System.out.println("Not secured site");
        }
	}
}
