package week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditCase {

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
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@class='slds-context-bar']//span[text()='More']")));
		executor1.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//span[text()='Cases'])[2]")));
		Thread.sleep(5000);
		int rowCount=driver.findElements(By.xpath("//table[@data-aura-class='uiVirtualDataTable']//tr")).size();
		for(int i=1;i<=rowCount;i++)
		{

            String caseNumber=driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody/tr["+i+"]/th/span/a")).getText();
			if (caseNumber.equals("00001434"))
					{
				      System.out.println(i);
				      driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']//tr["+i+"]/td[7]//div/a")).click();
				      Thread.sleep(4000);
				      driver.findElement(By.xpath("//a[@title='Edit']")).click();
				      break;
				    
					}
		}
        
	      Thread.sleep(4000);
		driver.findElement(By.xpath("(//input[@class='slds-input slds-combobox__input'])[2]")).click();
		driver.findElement(By.xpath("//span[@title='Working']")).click();
		driver.findElement(By.xpath("//a[@class='select'][1]")).click();
		driver.findElement(By.xpath("//a[@title='Low']")).click();
		driver.findElement(By.xpath("(//a[@class='select'])[3]")).click();
	    driver.findElement(By.xpath("//a[@title='Phone']")).click();
//	    Actions builder=new Actions(driver);
//	    builder.moveToElement(driver.findElement(By.xpath("(//a[text()='--None--'])[5]"))).click().perform();
		executor1.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//span[text()='SLA Violation']//following::div/div/div//a")));
		executor1.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='SLA Violation']//following::div/div/div//a")));
	    driver.findElement(By.xpath("//a[@title='No']")).click();
	    driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();


	    
	}

}
