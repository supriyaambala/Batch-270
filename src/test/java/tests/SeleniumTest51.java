package tests;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest51
{
	public static void main(String[] args) throws Exception
	{
		//Get innings number from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter innings(1 or 2)");
		int in=sc.nextInt();
		sc.close();
		//open browser
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Launch site
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/87878/rsa-vs-ind-final-icc-mens-t20-world-cup-2024");
		Thread.sleep(5000);
		//Get and display names of who "did not bat" batters in given innings
		List<WebElement> dnbl=driver.findElements(By.xpath(
          "//div[@id='innings_"+in+"']/descendant::div[contains(text(),'Did not Bat')]/following-sibling::div/a"));
		for(WebElement dnbn:dnbl)
		{
			System.out.println(dnbn.getText());
		}
		//close site
		driver.quit();
	}
}
