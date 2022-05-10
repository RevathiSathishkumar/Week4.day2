package week4.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          
	  //Open a Browser
		
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();   
        
      //open a URL
        
        driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize(); 
       
      //Send a topic value
        
        driver.switchTo().frame("frame1");
        
        driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Nested Frames");
        
      // click inner frame check box
        
        driver.switchTo().frame("frame3");
        
        driver.findElement(By.id("a")).click();
        
        driver.switchTo().defaultContent();
        
        driver.switchTo().frame("frame2");
        
     // Selecting the dropdown values
        
        WebElement findElement = driver.findElement(By.id("animals"));
        
        Select select=new Select(findElement);
        
        select.selectByIndex(3);
        
        
        
        
	}

}
