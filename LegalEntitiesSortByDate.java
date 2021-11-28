package week1.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LegalEntitiesSortByDate {

	public static void main(String[] args) {
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
		WebElement legal=driver.findElementByXPath("//p[text()='Legal Entities']");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", legal);	
        WebElement lastModified=driver.findElement(By.xpath("//span[text()='Last Modified Date']"));
        executor.executeScript("arguments[0].click();", lastModified);	
		String text=driver.findElement(By.xpath("//th[@aria-label='Last Modified Date']//a/following-sibling::span")).getText();
		if(text.contains("Ascending"))
		{
			System.out.println("Present in ascending order");
		}

		else
	        executor.executeScript("arguments[0].click();", lastModified);	
		    System.out.println("done");

	}

}
