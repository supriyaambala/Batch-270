package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test84
{
	public static void main(String[] args) throws Exception
	{
		//open chrome browser
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch yahoo site
		driver.get("http://www.yahoomail.com");
		Thread.sleep(5000);
		driver.findElement(By.linkText("Sign in")).click();
		Thread.sleep(5000);
		//Do login
		driver.findElement(By.id("login-username")).sendKeys("xxxxxxxxxxx");
		driver.findElement(By.id("login-signin")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("login-passwd")).sendKeys("xxxxxxxxxxx");
		driver.findElement(By.id("login-signin")).click();
		Thread.sleep(5000);
		//Click on Compose
		driver.findElement(By.linkText("Compose")).click();
		Thread.sleep(5000);
		//fill fields
		driver.findElement(By.id("message-to-field")).sendKeys("xxxxxxxxxxx@fastmail.com");
		driver.findElement(By.xpath("//input[@aria-label='Subject']")).sendKeys("test mail");
		driver.findElement(By.xpath("//div[@aria-label='Message body']"))
		               .sendKeys("Hi,\nHow are you?\nI hope you are doing well");
		//attach file(file upload)
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("E:\\core java notes.pdf");
		Thread.sleep(10000); //wait for complete file upload
		//send mail
		driver.findElement(By.xpath("//button[@title='Send this email']")).click();
		Thread.sleep(10000); //wait for send mail successfully
		String x=driver.findElement(
				By.xpath("//div[@role='presentation']/following-sibling::div[1]")).getText();
		System.out.println(x);
		
		
		//Take new window/Tab and switch to it
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> s=driver.getWindowHandles(); 
		List<String> a=new ArrayList<String>(s); 
		driver.switchTo().window(a.get(1));
		//Launch fast mail site
		driver.get("http://www.fastmail.com");
		Thread.sleep(5000);
		//do login
		driver.findElement(By.xpath("(//p[text()='Log in']/ancestor::a)[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("username")).sendKeys("xxxxxxxxxxx@fastmail.com");
		driver.findElement(By.name("current-password")).sendKeys("xxxxxxxxxxx");
		driver.findElement(By.xpath("//span[text()='Log in']/parent::button")).click();
		Thread.sleep(5000);
		//Test case-1: Test latest mail "From address" in mailbox
		String y=driver.findElement(By.xpath(
				"//ul[contains(@class,'Mailbox')]/li[1]/a/div/span/span")).getDomAttribute("title");
		if(y.equals("magnitiabatch251@yahoo.com"))
		{
			System.out.println("From address Test passed");
		}
		else
		{
			System.out.println("From address Test failed");
		}
		//Test case-2: Test "subject" of latest mail in mailbox
		String z=driver.findElement(By.xpath(
				"//ul[contains(@class,'Mailbox')]/li[1]/a/div[4]")).getDomAttribute("title");
		if(z.equals("test mail"))
		{
			System.out.println("Subject Test passed");
		}
		else
		{
			System.out.println("Subject Test failed");
		}
		//Test case-3: Attachment does exist or not in latest mail?
		try {
			if(driver.findElement(By.xpath(
				"//ul[contains(@class,'Mailbox')]/li[1]/a/div[contains(@class,'s-has-attachment')]"))
				.isDisplayed())
			{
				System.out.println("File Attachment Test passed");
			}
			else
			{
				System.out.println("File Attachment Test failed");
			}
		}
		catch(Exception ex)
		{
			System.out.println("File Attachment Test failed");
		}
		//Logout in fast mail
		driver.findElement(By.xpath("//div[contains(@class,'MainNavToolbar')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Log out")).click();
		Thread.sleep(5000);
		driver.close(); //close fast mail
		
		//Logout in yahoo mail
		driver.switchTo().window(a.get(0)); //back to yahoo mail
		driver.findElement(By.id("ybarAccountMenuOpener")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("profile-signout-link")).click();
		Thread.sleep(5000);
		driver.quit(); //close yahoo mail
	}
}
