package tests;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest52mobileUrl
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
		//Get and display names of who "did not bat" batters in given innings
		List<WebElement> dnbl=driver.findElements(By.xpath(
          "//div[contains(@id,'innings-"+in+"')]//*[contains(text(),'Did not Bat')]/following-sibling::div/a"));
		for(WebElement dnbn:dnbl)
		{
			System.out.println(dnbn.getText());
		}
		//close site
		driver.quit();
	}
}
