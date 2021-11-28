package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadCampaign {

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
        driver.findElement(By.xpath("//a[@title='Bootcamp']")).click();
        Thread.sleep(4000);
        executor.executeScript("arguments[0].scrollIntoView(true);",driver.findElementByXPath("//div[text()='Add Leads'])"));
        executor.executeScript("arguments[0].click();",driver.findElementByXPath("//div[text()='Add Leads'])"));
        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@title='Search Leads']")).click();
        driver.findElement(By.xpath("//span[text()='New Lead']")).click();
        driver.findElement(By.xpath("//a[text()='--None--']")).click();
        driver.findElement(By.xpath("//a[@title='Mr']")).click();
        driver.findElement(By.xpath("//input[@class='firstName compoundBorderBottom form-element__row input']")).sendKeys("Swetha");
        driver.findElement(By.xpath("//input[@class='lastName compoundBLRadius compoundBRRadius form-element__row input']")).sendKeys("Jawahar");
        driver.findElement(By.xpath("(//input[@class=' input'])[3]]")).sendKeys("Testleaf");
        driver.findElement(By.xpath("(//span[text()='Save'])[4]")).click();
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        driver.findElement(By.xpath("//span[text()='Submit']")).click();
        driver.findElement(By.xpath("//div[@data-aura-class='forceToastMessage']")).isDisplayed();
        executor.executeScript("arguments[0].click();",driver.findElementByXPath("//a[@title='Campaigns']"));
        executor.executeScript("arguments[0].click();",driver.findElementByXPath("//span[text()='Leads']']"));
        driver.findElement(By.xpath("//input[@name='Lead-search-input']")).sendKeys("Jawahar" + Keys.ENTER);
        boolean msg = driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr[1]/th/span/a")).getText().equals("Jawahar");
        System.out.println(msg);


        


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
