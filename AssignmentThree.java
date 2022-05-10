package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentThree {

	public static void main(String[] args) {
		
	  //Open a Browser
		
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();   
        
      //open a URL
        
        driver.get("http://www.leafground.com/pages/Dropdown.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize(); 
        
      // select training program using index
        
        WebElement findElement = driver.findElement(By.id("dropdown1"));
        
        Select slect=new Select(findElement);
        
        slect.selectByIndex(1);
        
      //select training program using text
        
        WebElement findElement2 = driver.findElement(By.name("dropdown2"));
        
        Select select1=new Select(findElement2);
        
        select1.selectByVisibleText("UFT/QTP");
        
      // select training program using value
        
        WebElement findElement3 = driver.findElement(By.id("dropdown3"));
        
        Select select2=new Select(findElement3);
        
        select2.selectByValue("4");
        
      //Get the number of dropdown from options
	  	
	  	WebElement findElement4 = driver.findElement(By.className("dropdown"));
        
	  	Select select3=new Select(findElement4);
	  	
	  	List<WebElement> options = select3.getOptions();
	  	
	  	System.out.println(options.size());
	  	
	  //select training program using sendKeys
	  	
	  	driver.findElement(By.xpath("//option[text()='You can also use sendKeys to select']/parent::select")).sendKeys("Appium");
	  	
      //select by program
	  	
	  	WebElement findElement5 = driver.findElement(By.xpath("//option[text()='Select your programs']/parent::select"));
	  	
	  	Select select4=new Select(findElement5);
	  	
	  	select4.selectByValue("4");
	  	select4.selectByValue("3");
	}

}
