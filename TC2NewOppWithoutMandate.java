package week3.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;


public class TC2NewOppWithoutMandate extends BaseTest {

	@Test
	public void newOppWithoutMandate()  throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver.findElementByXPath("//p[text()='Sales']").click();
		Thread.sleep(10000);
		
		WebElement opportunity = driver.findElementByXPath("//span[text()='Opportunities']");
        JavascriptExecutor executor1 = (JavascriptExecutor) driver;
        executor1.executeScript("arguments[0].click();", opportunity);
        
		Thread.sleep(10000);
		driver.findElementByXPath("//a[@data-aura-class='forceActionLink']").click();
		Thread.sleep(10000);
		driver.findElementByXPath("(//input[@class='slds-input'])[3]").sendKeys("13/11/2021");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		WebElement opname=driver.findElement(By.xpath("(//div[@role='alert'])[3]"));
		WebElement stage=driver.findElement(By.xpath("(//div[@class='slds-form-element__help'])[2]"));
		String check1=opname.getText();
		String check2=stage.getText();
		
		if(check1.contains("Complete this field.")&& check2.contains("Complete this field."))
		{
			System.out.println("Verification successful");
		}
		


	}

}
