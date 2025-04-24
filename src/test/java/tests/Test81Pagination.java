package tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class Test81Pagination
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site using base URL
		driver.get("https://www.flipkart.com");
		Thread.sleep(5000); 
		//Close banner if exists
		try
		{
			driver.findElement(By.xpath("//span[@role='button']")).click();
			Thread.sleep(5000); 
		}
		catch(Exception ex)
		{
			System.out.println("No banner this time");
		}
		//click on "beauty" link
		driver.findElement(By.xpath("//*[starts-with(@aria-label,'Beauty')]")).click();
		Thread.sleep(5000); 
		//click on "VIEW ALL"
		driver.findElement(By.xpath("//a[text()='View All']")).click();
		Thread.sleep(5000);
		//Pagination
		int pn=2;
		Map<String, Integer> products=new HashMap<String, Integer>();
		while(true)
		{
			//collect all models
			List<WebElement> all=driver.findElements(By.xpath(
					"//img[@loading='eager']/ancestor::div[5]/descendant::a[2]"));
			for(int i=0;i<all.size();i++)
			{
				//((JavascriptExecutor)driver).executeScript("arguments[0].click();",all.get(i));
				all.get(i).click();
				Thread.sleep(5000);
				//switch to newly opened window/tab(2nd tab)
				Set<String> s=driver.getWindowHandles();
				List<String> l=new ArrayList<String>(s);
				driver.switchTo().window(l.get(1));
				//get product image "src" path and amount
				String x=driver.findElement(By.xpath("(//img[@loading='eager'])[1]"))
						                                           .getDomAttribute("src");
				String y=driver.findElement(By.xpath(
						"//div[@id='price-info-icon']/preceding::div[3]")).getText();
				y=y.substring(1); //take text from 2nd position to avoid currency symbol
				y=y.replace(",",""); //remove "," in value
				products.put(x,Integer.parseInt(y));
				//close that newly opened browser window/tab
				driver.close();
				//back to previous page
				driver.switchTo().window(l.get(0));
				Thread.sleep(2000);
			}
			//Goto next page
			try {
				driver.findElement(By.xpath("//a[text()='"+pn+"']")).click();
				Thread.sleep(5000);
				pn++; //for next page
			}
			catch(Exception ex)
			{
				break; //terminate from loop
			}
		}
		//Find keys of max value in hash map
        int maxValue = Integer.MIN_VALUE;
        // First, find the maximum value in the map
        for (Integer value : products.values()) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        System.out.println(maxValue);
        // Next, collect all keys("src" of products) that have the maximum value
        List<String> maxKeys = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            if (entry.getValue().equals(maxValue)) {
                maxKeys.add(entry.getKey());
            }
        }
        System.out.println(maxKeys);
		//close site
		driver.quit();
	}
}
