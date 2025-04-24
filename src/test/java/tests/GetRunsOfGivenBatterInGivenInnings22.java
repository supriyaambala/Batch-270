package tests;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetRunsOfGivenBatterInGivenInnings22 
{
	public static void main(String[] args) throws Exception
	{
		//Get innings number and batter number from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Innings number like 1 or 2");
		int inum=sc.nextInt();
		System.out.println("Enter batter number like 1 or 2 or ...etc upto 11");
		int bnum=sc.nextInt();
		sc.close();
		//open browser
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/112462/ind-vs-aus-1st-semi-final-a1-v-b2-icc-champions-trophy-2025");
		Thread.sleep(5000);
		//Get runs of given bater in given innings
		WebElement e=driver.findElement(By.xpath(
			"(//div[@id='innings_"+inum+"']/div[1]/descendant::div[contains(@class,'cb-scrd-itms')])["+bnum+"]/div[3]"));
		String runs=e.getText();
		System.out.println("Hi students,\nOutPut is:");//with escape sequences or escape chars
		System.out.println(bnum+" scored "+runs+" Runs in "+inum+" innings"); //with Concatenation(+)
		System.out.printf("Hi students,\nOutPut is:");//with escape sequences or escape chars
		System.out.printf("%d scored %s Runs in %d innings",bnum,runs,inum);// with format specifiers
		//Close site
		driver.quit();
	}
}
