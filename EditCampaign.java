package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditCampaign {

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
        driver.findElement(By.xpath("//span[text()='Details']")).click();
        driver.findElement(By.xpath("//span[text()='Edit End Date']")).click();
        driver.findElement(By.xpath("(//a[@class='datePicker-openIcon display'])[2]")).click();
        int rowSize = driver.findElements(By.xpath("//table[@class='calGrid']/tbody/tr")).size();
        for(int i=1;i<=rowSize;i++)
        {
        	int cellSize = driver.findElements(By.xpath("//table[@class='calGrid']/tbody/tr["+i+"]/td")).size();
    
        for(int j=1;j<=cellSize;j++)
        {
        	String searchDate=driver.findElement(By.xpath("//table[@class='calGrid']/tbody/tr["+i+"]/td["+j+"]")).getText();
        	if(searchDate.equals(driver.findElement(By.xpath("//span[@class='slds-day weekday selectedDate DESKTOP uiDayInMonthCell--default']")).getText()))
        	{
        		driver.findElement(By.xpath("//table[@class='calGrid']/tbody/tr["+i+"]/td["+(j+4)+"]")).click();
        	}
        }
	}
        driver.findElement(By.xpath("//span[text()='Expected Revenue in Campaign']/parent::label/following-sibling::input")).sendKeys("1000000");
        driver.findElement(By.xpath("//span[text()='Budgeted Cost in Campaign']/parent::label/following-sibling::input")).sendKeys("1000000");
        driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
        if(driver.findElement(By.xpath("//span[text()='Expected Revenue in Campaign']/parent::div/following-sibling::div/span/span")).getText().equals("10000001000000")&& driver.findElement(By.xpath("//span[text()='Budgeted Cost in Campaign']/parent::div/following-sibling::div/span/span")).getText().equals("1000000"))
        {
        	System.out.println("Verification successful");
        }

}}
