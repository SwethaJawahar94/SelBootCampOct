package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AttachmentToCampaign {

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
        driver.findElement(By.xpath("(//div[@title='Upload Files'])[3]")).sendKeys("C:\\Users\\Swetha\\Desktop\\file1.pdf");
        driver.findElement(By.xpath("//span[text()='Done']")).click();
        if(driver.findElement(By.xpath("//span[@class='itemTitle slds-text-body--regulardesktop uiOutputText']")).getText().equals("file1"))
        {
        	System.out.println("file name present");
        }
        driver.findElement(By.xpath("//span[contains(text(),'added')]")).isDisplayed();
	}

}
