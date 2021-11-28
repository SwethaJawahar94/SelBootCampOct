package week3.day1;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;


public class TC3NewCase extends BaseTest {

	@Test
	public void newCase() throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver.findElementByXPath("//p[text()='Sales']").click();
		Thread.sleep(4000);
	    JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@class='slds-context-bar']//span[text()='More']")));
        driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//span[text()='Cases'])[2]")));
    	driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("//input[@title='Search Contacts']")).click();
		driver.findElement(By.xpath("//div[@title='Anbu Selvam']")).click();
		driver.findElement(By.xpath("(//input[@class='slds-input slds-combobox__input'])[2]")).click();
		WebElement escalated = driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Escalated']/span"));
		executor1.executeScript("arguments[0].click();", escalated);
	    driver.findElement(By.xpath("//a[text()='--None--']")).click();
	    driver.findElement(By.xpath("//a[@title='Email']")).click();
	    driver.findElement(By.xpath("(//span[text()='Subject'])[2]/parent::label/following-sibling::input")).sendKeys("testing");
	    driver.findElement(By.xpath("//span[text()='Description']/parent::label/following-sibling::textarea")).sendKeys("dummy");
	    driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
	    String text=driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText();
	    text = text.replaceAll("[^\\d]", "");
	    String text1=driver.findElement(By.xpath("(//p[text()='Case Number']/following-sibling::p/slot/lightning-formatted-text)")).getText();
	    if(text.equalsIgnoreCase(text1))
        {
           System.out.println("validation successful");
	    }
		


}
}
