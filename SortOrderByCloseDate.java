package week2.day1;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortOrderByCloseDate {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com");
		driver.findElementById("username").sendKeys("makaia@testleaf.com");
		driver.findElementById("password").sendKeys("SelBootcamp$1234");
		driver.findElementById("Login").click();
		driver.findElementByClassName("slds-r5").click();
		driver.findElementByXPath("//button[text()='View All']").click();
		driver.findElementByXPath("//p[text()='Sales']").click();
		
		WebElement opportunity = driver.findElementByXPath("//span[text()='Opportunities']");
        JavascriptExecutor executor1 = (JavascriptExecutor) driver;
        executor1.executeScript("arguments[0].click();", opportunity);
        
		driver.findElement(By.xpath("//div[@title='Display as Table']//lightning-primitive-icon[1]")).click();
		WebElement dd= driver.findElement(By.xpath("//li[@title='Table']/a"));
	    executor1.executeScript("arguments[0].click();", dd);
       
	    List<WebElement> row=driver.findElements(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr"));
	    int rowCount=row.size();
	    List<String> defaultDates = new LinkedList<String>();

    	for(int i=1;i<=rowCount;i++)
	    {
	    	String dates=driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr["+i+"]/td[6]/span/span/span")).getText();
	    	defaultDates.add(dates);
	    	
        }
    	 
    	Collections.sort(defaultDates);
    //	System.out.println(defaultDates);
    	

    	
    	WebElement closeDate=driver.findElement(By.xpath("//span[text()='Close Date']"));
 	    executor1.executeScript("arguments[0].click();", closeDate);
 	    
 	    List<String> sortedDates = new LinkedList<String>();
 	     for(int i=1;i<=rowCount;i++)
        {
 	    	String dates1=driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr["+i+"]/td[6]/span/span/span[1]")).getText();
	    	//System.out.println(dates1);
	    	sortedDates.add(dates1);

        }
 	     
 	    boolean val = defaultDates.equals(sortedDates);
 	    
 	    if(val)
 	    {

 	    System.out.println("success");

	}
 	    else
 	    {
 	    	executor1.executeScript("arguments[0].click();", closeDate);
 	    }
 	    boolean val1 = defaultDates.equals(sortedDates);
 	    System.out.println(val1);


}}
