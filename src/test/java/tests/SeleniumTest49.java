package tests;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest49
{
	public static void main(String[] args) throws Exception
	{
		//Get innings number from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter innings(1 or 2)");
		int in=sc.nextInt();
		sc.close();
		//open browser
		FirefoxDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/87878/rsa-vs-ind-final-icc-mens-t20-world-cup-2024");
		Thread.sleep(5000);
		//Get and display names and runs of "not out" batters in given innings
		List<WebElement> nobl=driver.findElements(By.xpath(
				                            "//div[@id='innings_"+in+"']//span[text()='not out']"));
        for(WebElement nob:nobl)
        {
            String nob_name=nob.findElement(By.xpath("preceding::a[1]")).getText();
            String nob_runs=nob.findElement(By.xpath("following::div[1]")).getText();
            System.out.println(nob_name+" did "+nob_runs);
        }
		//close site
		driver.quit();
	}
}
