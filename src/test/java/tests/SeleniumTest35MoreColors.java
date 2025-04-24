package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SeleniumTest35MoreColors 
{
    public static void main(String[] args) 
    {
        // Open browser
        ChromeDriver driver=new ChromeDriver();
        //Launch Site
        driver.get("https://www.google.co.in"); 
        driver.manage().window().maximize();
        // Get all elements on the page
        List<WebElement> elements=driver.findElements(By.xpath("//*"));
        // List of CSS properties that can have color values
        String[] colorProperties = {
            "color",
            "background-color",
            "border-top-color",
            "border-right-color",
            "border-bottom-color",
            "border-left-color",
            "outline-color",
            "text-decoration-color",
            "column-rule-color",
            "caret-color",
            "box-shadow",
            "text-shadow"
        };
        //Extract unique colors in "rgba" form
        Set<String> uniquecolors=new HashSet<>();
        //Goto each element
        for(WebElement element : elements) 
        {
            for(String property : colorProperties) 
            {
                String colorValue=element.getCssValue(property);
                // Handle box-shadow and text-shadow properties specially to extract color values
                if(property.equals("box-shadow") || property.equals("text-shadow")) 
                {
                    if (colorValue!=null && !colorValue.isEmpty()) {
                        // Extract rgba values from shadow properties
                        String[] shadowColors=colorValue.split(",");
                        for (String shadowColor : shadowColors) {
                            String trimmedColor = shadowColor.trim();
                            if (trimmedColor.matches("[r][g][b][a]?[(][.*][)]")) {
                            	uniquecolors.add(trimmedColor);
                            }
                        }
                    }
                } 
                // Handle other properties specially to extract color values
                else 
                {
                    if (colorValue != null && !colorValue.isEmpty()) {
                    	uniquecolors.add(colorValue);
                    }
                }
            }
        }
        // Print the colors
        System.out.println("Total count of used colors in web page is "+uniquecolors.size());
        for(String color:uniquecolors) {
            System.out.println(color);
        }
        // Close the browser
        driver.quit();
    }
}
