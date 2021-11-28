package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLeadCampaign {

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
        executor.executeScript("arguments[0].click();",driver.findElementByXPath("//span[text()='Leads']']"));
        driver.findElement(By.xpath("//input[@name='Lead-search-input']")).sendKeys("Jawahar" + Keys.ENTER);
        driver.findElement(By.xpath("(//span[@class='slds-icon_container slds-icon-utility-down']//span)[1]")).click();
        driver.findElement(By.xpath("//a[@title='Delete']")).click();
        driver.findElement(By.xpath("//span[text()='Delete']")).click();
        System.out.println(driver.findElement(By.xpath("//span[@data-aura-rendered-by='forceActionsText']")).getText().equals("deleted"));
        executor.executeScript("arguments[0].click();",driver.findElementByXPath("//a[@title='Campaigns']"));
        driver.findElement(By.xpath("//a[@title='Bootcamp']")).click();
        int rowCount = driver.findElements(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr")).size();
        for(int i=2;i<=rowCount;i++)
        {
        	if(!driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr["+i+"]/td[4]")).getText().equals("Swetha Jawahar"))
        	{
        		System.out.println("Lead deleted successfully");
        	}
        }

	}

}
