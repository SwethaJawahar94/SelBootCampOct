package week2.day2;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaign {

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
		Thread.sleep(4000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();",driver.findElementByXPath("//a[@title='Campaigns']"));
        Thread.sleep(4000);
        driver.findElement(By.xpath("(//div[text()='New'])[1]")).click();
        driver.findElement(By.xpath("(//span[text()='Campaign Name'])[2]/parent::label/following-sibling::input")).sendKeys("Bootcamp");
       driver.findElement(By.xpath("//span[text()='Start Date']/following::div[1]//span[text()='Date Picker']/parent::a")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//span[contains(@class,'today')]/following::td[1]")).click();
    	driver.findElement(By.xpath("//span[text()='End Date']/following::div[1]//span[text()='Date Picker']/parent::a")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//span[contains(@class,'today')]/following::td[2]")).click();
    	
    	//Click on Save
    	driver.findElement(By.xpath("(//span[text()='Save']/parent::button)[2]")).click();
    	
    	//Verify that the campaign created message is displayed
    	try {
    		 driver.findElement(By.xpath("//span[text()[contains(.,'was created')]]")).isDisplayed();
    		System.out.println("The Campaign was created");
    	}catch(NoSuchElementException e) {
    		System.out.println("The Campaign was not created");
    	}
    	
    	
    	}
    }
//        driver.findElement(By.xpath("(//a[@class='datePicker-openIcon display'])[1]")).click();
//        Thread.sleep(2000);
//        String today=driver.findElement(By.xpath("//td[@aria-selected='true']/span")).getText();
//        executor.executeScript("arguments[0].click();",driver.findElement(By.xpath("//td[@aria-selected='true']/span")));
//        System.out.println(today);
//        driver.findElement(By.xpath("(//a[@class='datePicker-openIcon display'])[2]")).click();
//        int rowSize = driver.findElements(By.xpath("//table[@class='calGrid']/tbody/tr")).size();
//        for(int i=1;i<=rowSize;i++)
//        {
//        	int cellSize = driver.findElements(By.xpath("//table[@class='calGrid']/tbody/tr["+i+"]/td")).size();
//
//
//        for(int j=1;j<=cellSize;j++)
//        {
//        	String searchDate=driver.findElement(By.xpath("//table[@class='calGrid']/tbody/tr["+i+"]/td["+j+"]/span")).getText();
//        	if(searchDate.equals(today))
//        	{
//
//        		driver.findElement(By.xpath("//table[@class='calGrid']/tbody/tr["+i+"]/td["+(j+1)+"]")).click();
//        	}
//        }
//    }
//    	}
//    }