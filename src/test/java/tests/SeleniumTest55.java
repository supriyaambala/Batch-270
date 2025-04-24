package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest55
{
	public static void main(String[] args) throws Exception
	{
		//open chrome browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://my.aidaform.com/signup"); 
		Thread.sleep(5000);
		//Segregate various types of <input> tag elements
		List<WebElement> el=driver.findElements(By.tagName("input"));
		System.out.println("All input tagged elements count is "+el.size());
		int rbc=0, cbc=0, tbc=0, fac=0, rabc=0, ubc=0, bc=0, sbc=0, sebc=0, pbc=0, dc=0, hec=0;
		int others=0;
		for(WebElement e:el)
		{
			String x=e.getDomAttribute("type");
			switch(x)
			{
				case "text":
					tbc++;
					break;
				case "radio":
					rbc++;
					break;
				case "checkbox":
					cbc++;
					break;
				case "file":
					fac++;
					break;
				case "password":
					pbc++;
					break;
				case "range":
					rabc++;
					break;
				case "search":
					sebc++;
					break;
				case "date":
					dc++;
					break;
				case "hidden":
					hec++;
					break;
				case "url":
					ubc++;
					break;
				case "button":
					bc++;
					break;
				default:
					others++;
					break;  //optional here only
			}
		}
		System.out.println("Text boxes count is "+tbc);
		System.out.println("Check boxes count is "+cbc);
		System.out.println("radio buttons count is "+rbc);
		System.out.println("file attachments count is "+fac);
		System.out.println("URL boxes count is "+ubc);
		System.out.println("Push buttons count is "+bc);
		System.out.println("Hidden elements count is "+hec);
		System.out.println("Submit buttons count is "+sbc);
		System.out.println("Password boxes count is "+pbc);
		System.out.println("Search boxes count is "+sebc);
		System.out.println("Range boxes count is "+rabc);
		System.out.println("Date boxes count is "+dc);
		System.out.println("Others count is "+others);
		//close site
		driver.quit();
	}
}






