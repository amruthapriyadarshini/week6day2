package week6.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DuplicateLeadNG extends BaseClass{
	
	@Test(dataProvider = "getData")
	public void duplicate(String email) throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("(//div[@class='x-panel-header'])[2]/a")).click();
		driver.findElement(By.xpath("//div[@class='frameSectionBody']//li[3]/a")).click();
		driver.findElement(By.xpath("//ul[@class='x-tab-strip x-tab-strip-top']/li[3]//span[@class='x-tab-strip-text ']")).click();
		driver.findElement(By.xpath("//div[@class='x-form-element']/input[@name='emailAddress']")).sendKeys(email);
		driver.findElement(By.xpath("(//td[@class='x-panel-btn-td']//tbody//td[2])[6]//button[@type='button']")).click();
		//Accessing the first element 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		//Clicking Duplicate lead
		driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[1]")).click();
		//how to verify as 'duplicate lead'
		Thread.sleep(2000);
		String strTitle = driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
		System.out.println("Title is "+ strTitle);
		driver.findElement(By.xpath("//div[@class='frameSectionBody']//li[2]/a")).click();
		//Confirm the duplicated lead name is same as captured name
		if(strTitle.equals("Duplicate Lead"))
		{
			System.out.println("Its a duplicate lead");
		}
		else {
			System.out.println("Not a duplicate lead");
		}
		
		
	}
	@BeforeClass
	public void setData() {
		fileName = "Duplicate";
	}
	

}
