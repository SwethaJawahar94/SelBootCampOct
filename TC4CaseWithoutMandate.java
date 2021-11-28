package week3.day1;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;


public class TC4CaseWithoutMandate extends BaseTest {

	
	@Test
	public void caseWithoutMandate() throws InterruptedException {
		// TODO Auto-generated method stub
		
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
