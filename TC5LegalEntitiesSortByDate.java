package week3.day1;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class TC5LegalEntitiesSortByDate extends BaseTest {

	@Test
	public void legalEntitiesSortByDate() {
		// TODO Auto-generated method stub
		
		WebElement legal=driver.findElementByXPath("//p[text()='Legal Entities']");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", legal);	
        WebElement lastModified=driver.findElement(By.xpath("//span[text()='Last Modified Date']"));
        executor.executeScript("arguments[0].click();", lastModified);	
		String text=driver.findElement(By.xpath("//th[@aria-label='Last Modified Date']//a/following-sibling::span")).getText();
		if(text.contains("Ascending"))
		{
			System.out.println("Present in ascending order");
		}

		else
	        executor.executeScript("arguments[0].click();", lastModified);	
		    System.out.println("done");
			


	}

}
