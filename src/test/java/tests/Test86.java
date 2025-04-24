package tests;
 
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class Test86 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser window
		WebDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Minimize
		driver.manage().window().minimize();
		Thread.sleep(5000);
		//get size(width and height) of browser window
		int w=driver.manage().window().getSize().getWidth();
		int h=driver.manage().window().getSize().getHeight();
		System.out.println(w+" "+h);
		//set size
		Dimension d=new Dimension(400,200); //expected width and height
		driver.manage().window().setSize(d);
		Thread.sleep(5000);
		//get position of browser window on desktop
		int x=driver.manage().window().getPosition().getX();
		int y=driver.manage().window().getPosition().getY();
		System.out.println(x+" "+y);
		//set position of browser window on desktop
		Point p=new Point(400,200); //expected x and y
		driver.manage().window().setPosition(p);
		Thread.sleep(5000);
		//full screen
		driver.manage().window().fullscreen();
		Thread.sleep(5000);
		driver.manage().window().maximize(); //to exit from full screen
		Thread.sleep(5000);
	}

}
