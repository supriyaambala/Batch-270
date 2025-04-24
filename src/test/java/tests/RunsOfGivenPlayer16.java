package tests;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class RunsOfGivenPlayer16
{
	public static void main(String[] args) throws Exception
	{
		//Give matchid, series, innings number, batsman name from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter matchid");
		String mid=sc.nextLine();
		System.out.println("Enter Series");
		String mdt=sc.nextLine();
		System.out.println("Enter innngs number");
		String inn=sc.nextLine();
		System.out.println("Enter batsman name");
		String bn=sc.nextLine();
		sc.close();
		//Open Chrome browser
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(5000);
		//Launch site
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/"+mid+"/"+mdt);
		Thread.sleep(5000);
		//Get an display runs of given player
		String runs=driver.findElement(
				By.xpath("(//div[@id='innings_"+inn+"']/descendant::a[contains(text(),'"+bn+"')])[1]/following::div[2]")).getText();
		System.out.println("Runs scored by "+bn+" is "+runs);
		//Close site
		driver.quit();
	}
}










