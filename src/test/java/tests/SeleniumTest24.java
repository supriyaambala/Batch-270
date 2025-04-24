package tests;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest24
{
	public static void main(String[] args) throws Exception{
		//Get innings number and batter number from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter matchid");
		String mid=sc.nextLine();
		System.out.println("Enter Series");
		String mdt=sc.nextLine();
		System.out.println("Enter Innings number like 1 or 2 ...etc upto 4");
		int inum=sc.nextInt();
		System.out.println("Enter batter number like 1 or 2 or ...etc upto 11");
		int bnum=sc.nextInt();
		sc.close();
		//open browser
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/"+mid+"/"+mdt);
		Thread.sleep(5000);
		//Get runs of 1st bater in 1st innings
		try {
			WebElement e=driver.findElement(By.xpath("(//div[@id='innings_"+inum+"']/div[1]/descendant::div[contains(@class,'cb-scrd-itms')])["+bnum+"]/div[3]"));
			String runs=e.getText();
			driver.executeScript("arguments[0].style.border='5px yellow solid';",e); //Used JavaScript
			System.out.printf("%d scored %s Runs in %d innings",bnum,runs,inum);
		}
		catch(NoSuchElementException ex)
		{
			System.out.println("No given innings or no given batter found in page source");
		}
		//Close site
		driver.quit();
	}
}
