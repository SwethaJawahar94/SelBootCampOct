package week1.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewOppurtunity {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.findElementById("username").sendKeys("makaia@testleaf.com");
		driver.findElementById("password").sendKeys("SelBootcamp$1234");
		driver.findElementById("Login").click();
		Thread.sleep(10000);
		driver.findElementByClassName("slds-r5").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//button[text()='View All']").click();
		Thread.sleep(10000);
		driver.findElementByXPath("//p[text()='Sales']").click();
		Thread.sleep(10000);
		
		WebElement opportunity = driver.findElementByXPath("//span[text()='Opportunities']");
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", opportunity);
        
		Thread.sleep(10000);
		driver.findElementByXPath("//a[@data-aura-class='forceActionLink']").click();
			
		Thread.sleep(10000);
		driver.findElementByXPath("(//div[@class='slds-form-element__control slds-grow']//input)[3]").sendKeys("Salesforce Automation by Swetha");
		driver.findElementByXPath("(//input[@class='slds-input'])[3]").sendKeys("13/11/2021");
		WebElement dropDown=driver.findElement(By.xpath("(//input[@class='slds-input slds-combobox__input'])[3]"));
		executor.executeScript("arguments[0].click();", dropDown);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		
		

	}

}
