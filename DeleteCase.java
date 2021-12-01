package week1.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteCase extends NewCase{

	public static void main(String[] args) throws InterruptedException {
		//NewCase d=new NewCase();
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
			if (caseNumber.equals("00001429"))
					{
				      System.out.println(i);
				      driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']//tr["+i+"]/td[7]//div")).click();
					  driver.findElement(By.xpath("//a[@title='Delete']")).click();
					  driver.findElement(By.xpath("//span[text()='Delete']")).click();
				      break;
					}
		}
	}

}
