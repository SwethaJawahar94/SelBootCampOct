package week1.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaseWithoutMandate {

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
		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		driver.get("https://d2w00000dnnegeal-dev-ed.lightning.force.com/lightning/o/Case/new?count=1&nooverride=1&useRecordTypeCheck=1&navigationLocation=LIST_VIEW&uid=163740936942519745&backgroundContext=%2Flightning%2Fo%2FCase%2Flist%3FfilterName%3DRecent");
		driver.findElement(By.xpath("//input[@title='Search Contacts']")).click();
		driver.findElement(By.xpath("//div[@title='Anbu Selvam']")).click();
		driver.findElement(By.xpath("(//input[@class='slds-input slds-combobox__input'])[2]")).click();
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='--None--']")));
		driver.findElement(By.xpath("(//span[text()='Subject'])[2]/parent::label/following-sibling::input")).sendKeys("testing");
		driver.findElement(By.xpath("//span[text()='Description']/parent::label/following-sibling::textarea")).sendKeys("automation testing");
	    driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
	    String text= driver.findElement(By.xpath("//span[@class='genericError uiOutputText']")).getText();
	    if (text.contains("error"))
	    {
	    	System.out.println("Error shown");
	    }

	}

}
