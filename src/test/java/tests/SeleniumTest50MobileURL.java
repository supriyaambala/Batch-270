package tests;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest50MobileURL
{
	public static void main(String[] args) throws Exception
	{
		//Get innings number from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter innings(1 or 2)");
		int in=sc.nextInt();
		sc.close();
		//open browser
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://m.cricbuzz.com/live-cricket-scorecard/87878/rsa-vs-ind-final-icc-mens-t20-world-cup-2024");
		Thread.sleep(5000);
		//Get and display names and runs of "not out" batters in given innings
		List<WebElement> nobl=driver.findElements(By.xpath(
						 "//div[contains(@id,'innings-"+in+"')]/descendant::div[text()='not out']"));
		for(WebElement nob:nobl)
		{
			if(nob.isDisplayed()) //because some matched elements are hidden
			{
				String nob_name=nob.findElement(By.xpath("preceding-sibling::a[1]")).getText();
				String nob_runs=nob.findElement(By.xpath("following::div[1]")).getText();
				System.out.println(nob_name+" did "+nob_runs);
			}
		}
		//close site
		driver.quit();
	}
}
