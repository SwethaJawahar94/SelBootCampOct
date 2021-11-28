package week3.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class TC1NewOppurtunity extends BaseTest {

	@Test
	public void newOppurtunity() throws InterruptedException {
		// TODO Auto-generated method stub
		
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
