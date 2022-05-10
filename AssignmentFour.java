package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentFour {

	public static void main(String[] args) throws IOException {

	      //Open a Browser
	
			WebDriverManager.chromedriver().setup();
	        ChromeDriver driver=new ChromeDriver();   
	        
	      //open a URL
	        
	        driver.get(" https://www.amazon.in/");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize(); 
	        
	      //search as one plus 9 pro 
	        
	        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
	        
	     //Get the price of the first product
	        
	        String text = driver.findElement(By.xpath("//span[text()='55,990']")).getText();
	        
	        System.out.println("The price of the first product :  " +text);
	     
	     //Print the number of customer ratings for the first displayed product
	        
            String price = driver.findElement(By.xpath("//span[@aria-label='519']//span")).getText();
	        
	        System.out.println("The number of customer ratings for the first displayed product :  " +price);
	        
	      //Click the first text link of the first image
	        
	         driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-fixed-height']/img")).click();
	         
	         Set<String> windowHandles = driver.getWindowHandles();
	         
	         System.out.println(windowHandles);
	         
	         List<String> windowHandleslist=new ArrayList<String>(windowHandles);
	         
	         driver.switchTo().window(windowHandleslist.get(1));
	         
	         System.out.println(driver.getCurrentUrl());
	        
          // Take a screen shot of the product displayed
	         
	         File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
	         
	         File oneplusscreenshot=new File("./snaps/IMG001.png");
	         
	         FileUtils.copyFile(screenshotAs,oneplusscreenshot);
	         
	      //Click 'Add to Cart' button
	         
	         driver.findElement(By.id("add-to-cart-button")).click();
	         
	      // Get the cart sub total and verify if it is correct.
	     
	     	String subtotal = driver.findElement(By.xpath("//span[contains(@class,'a-size-base-plus a-color-price a-text-bold')]/span")).getText();
	         if(price.contains(subtotal)) {
	         	System.out.println("Total is Equal");
	         	
	         }
	         else {
	         	System.out.println("Total Not Equal");
	         }        
	         
	}

}
