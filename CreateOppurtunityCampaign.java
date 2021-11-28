package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOppurtunityCampaign {

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
        driver.findElement(By.xpath("//div[text()='New Opportunity']")).click();
        driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("Oppurtunity from Swetha");
        driver.findElement(By.xpath("//a[@class='datePicker-openIcon display']")).click();
        String today=driver.findElement(By.xpath("//td[@class='slds-is-selected uiDayInMonthCell']//span[1]")).getText();
        int rowCount= driver.findElements(By.xpath("//table[@class='calGrid']/tbody/tr")).size();
        for(int i=1;i<=rowCount;i++)
        {
        	int cellCount=driver.findElements(By.xpath("//table[@class='calGrid']/tbody/tr["+i+"]/td")).size();
        	for(int j=1;j<=cellCount;j++)
        	{
        		
        		if(driver.findElement(By.xpath("//table[@class='calGrid']/tbody/tr["+i+"]/td["+j+"]/span")).getText().equals(today))
        		{
        			driver.findElement(By.xpath("//table[@class='calGrid']/tbody/tr["+i+"]/td["+(j+1)+"]/span")).click();
        		}
        		
        	}
        }
        driver.findElement(By.xpath("//a[@class='select']")).click();
        driver.findElement(By.xpath("//a[@title='Need Analysis']")).sendKeys("Need Analysis");
        driver.findElement(By.xpath("//span[text()='Save']")).click();
        WebElement opportunity = driver.findElementByXPath("//span[text()='Opportunities']");
        executor.executeScript("arguments[0].click();", opportunity);
        if(driver.findElement(By.xpath("//a[@title='Swetha']")).getText().equals("Swetha"))
        {
        	System.out.println("Validation successful");
        }
	}

}
